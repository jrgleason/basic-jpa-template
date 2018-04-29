package org.gleason;

import org.gleason.coffeeshop.domain.Person;
import org.gleason.coffeeshop.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/coffee")
public class CoffeeShopEndpoint {
    @Autowired
    CoffeeShopService service;

    @GetMapping("people")
    @ResponseBody
    String people(){
        String result = "";
        for(Person person : service.getPeople())
        {
            result += person.getName();
        }
        return result;
    }
}
