package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller{

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/banks")
    public List<Bank> banks(){
        List<Bank> banks = new ArrayList<>();
        //final String uri = "http://user:8081/api/users:";
       final String uri = "https://8081-rajeshceg3-springboot-wje4o2fvjme.ws-us54.gitpod.io/api/";

        List<Object> result = restTemplate.getForObject(uri, List.class);

        for( Object user: result){
            LinkedHashMap userMap = (LinkedHashMap) user;
            User user_obj = new User(Long.valueOf(userMap.get("id").toString())
                                        ,String.valueOf(userMap.get("name")));
                                
            banks.add( new Bank(user_obj, "State Bank of India", "SBI"));
                                        
        }
        return banks;
    }

}