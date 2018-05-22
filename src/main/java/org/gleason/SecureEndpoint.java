package org.gleason;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/secure")
public class SecureEndpoint {
    @Autowired
    private UserRepoService service;
    @GetMapping("/dynamo")
    @ResponseBody
    protected String getDynamo(final Principal principal){
//        String email = ((TokenAuthentication)principal).getUsername();
        return service.getUser("test").toString();
    }
}
