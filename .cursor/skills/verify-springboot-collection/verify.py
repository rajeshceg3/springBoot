#!/usr/bin/env python3
"""Purpose-fit verification for the Spring Boot Microservices Collection.

Packages every subproject and runs the existing test suites where they
exist. Exit 0 and FAILURES=0 mean green.
"""
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile

REPO_ROOT = os.path.abspath(os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', '..', '..'))

SUBPROJECTS = [
    'springBoot-jwt',
    'springBoot-kafka-consumer',
    'springBoot-kafka-producer',
    'springBoot-oauth',
    'springBoot-rabbitmq-consumer',
    'springBoot-rabbitmq-producer',
    'springBoot-restapi-crud',
    'springBoot-security',
    'springBoot-docker-compose/user-service',
    'springBoot-docker-compose/bank-service',
]
# Subprojects with real test suites that run without external infra.
TESTED = {
    'springBoot-jwt': 'context load (H2-backed JPA/security app)',
    'springBoot-restapi-crud': 'MovieController WebMvcTest suite',
}

checks = []
failures = []


def record(name, ok, detail=''):
    checks.append({'name': name, 'ok': bool(ok), 'detail': detail})
    print(('PASS' if ok else 'FAIL') + ' ' + name + (' :: ' + detail if detail else ''))
    if not ok:
        failures.append(name)


def java_ok():
    try:
        out = subprocess.run(['java', '-version'], capture_output=True, text=True).stderr
        return True, out.split('\n')[0]
    except Exception as e:
        return False, str(e)


def main():
    ok, detail = java_ok()
    record('doctor: JDK on PATH', ok, detail + ' (Java 11 expected; JDK 17 also packages cleanly)')
    record('doctor: maven on PATH', shutil.which('mvn') is not None, shutil.which('mvn') or 'not found')
    if failures:
        return finish()

    for proj in SUBPROJECTS:
        path = os.path.join(REPO_ROOT, proj)
        if not os.path.isdir(path):
            record('package %s' % proj, False, 'directory missing')
            continue
        pkg = subprocess.run(['mvn', '-B', '-q', '-DskipTests', 'package'], cwd=path,
                             capture_output=True, text=True, timeout=600)
        record('package %s' % proj, pkg.returncode == 0,
               'jar built' if pkg.returncode == 0 else (pkg.stdout + pkg.stderr).strip()[-300:])

    for proj, desc in TESTED.items():
        path = os.path.join(REPO_ROOT, proj)
        test = subprocess.run(['mvn', '-B', 'test'], cwd=path,
                              capture_output=True, text=True, timeout=600)
        counts = [int(m) for m in re.findall(r'Tests run: (\d+),', test.stdout + test.stderr)]
        record('tests %s (%s)' % (proj, desc), test.returncode == 0,
               ('%d tests run' % max(counts)) if counts else 'rc=%d' % test.returncode)
    return finish()


def finish():
    evidence_dir = tempfile.mkdtemp(prefix='verify-springboot-collection-')
    with open(os.path.join(evidence_dir, 'evidence.json'), 'w') as f:
        json.dump({'repo': 'springBoot', 'checks': checks, 'failures': failures}, f, indent=2)
    print('EVIDENCE_DIR=' + evidence_dir)
    print('FAILURES=%d' % len(failures))
    return 0 if not failures else 1


if __name__ == '__main__':
    sys.exit(main())
