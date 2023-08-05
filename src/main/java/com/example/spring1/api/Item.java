package com.example.spring1.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class Item {

    @GetMapping(params = "data")
    public String getItemsWithParams(@RequestParam String data){
        System.out.println("getItemsWithParams");
        return "Get item "+data;
    }


    @PostMapping(headers = "X-token")
    public String setItemWithCustomTokens(@RequestHeader("X-token") String token){
        System.out.println("getItemsWithParams");
        return "Save the item as : "+token;
    }

    @PostMapping(value = "/{code}" ,headers = "X-token")
    public String setItemWithCustomTokensAndValue(@RequestHeader("X-token") String token, @PathVariable String code){
        System.out.println("getItemsWithParams");
        return "Save the item as(token) : "+token+ " and Value "+code;
    }


}
