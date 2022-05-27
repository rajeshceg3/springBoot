package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller{

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/banks")
    public List<Bank> banks(){
        List<Bank> banks = new ArrayList<>();
        final String uri = "http://user:8081/api/users:"
        List result = restTemplate.getForObject(uri, List.class);

        for( Object user: result){
            LinkedHashMap userMap = (LinkedHashMap) user;
            User user_obj = new User(Long.valueOf(userMap.get("id").toString())
                                        ,String.valueOf(userMap.get("name")));
                                
            banks.add( new Bank(user_obj, "State Bank of India", "SBI"));
                                        
        }
        return banks;
    }

}