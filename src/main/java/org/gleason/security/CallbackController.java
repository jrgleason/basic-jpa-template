package org.gleason.security;

import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.example.security.TokenAuthentication;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
@Controller
public class CallbackController {

    @Autowired
    private AuthenticationController controller;
    private final String redirectOnFail;
    private final String redirectOnSuccess;

    public CallbackController() {
        this.redirectOnFail = "/login";
        this.redirectOnSuccess = "/portal/home";
    }

    @GetMapping("/callback")
    protected void getCallback(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        handle(req, res);
    }

    @PostMapping(
            value = "/callback",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    protected void postCallback(
            final HttpServletRequest req,
            final HttpServletResponse res
    ) throws IOException {
        handle(req, res);
    }

    private void handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            Tokens tokens = controller.handle(req);
            TokenAuthentication tokenAuth = new TokenAuthentication(JWT.decode(tokens.getIdToken()));
            SecurityContextHolder.getContext().setAuthentication(tokenAuth);
            System.out.println("Questioning Reality Because it is redirecting correctly");
            res.sendRedirect(redirectOnSuccess);
        } catch (AuthenticationException | IdentityVerificationException e) {
            System.out.println("We are where I thought we would be");
            e.printStackTrace();
            SecurityContextHolder.clearContext();
            res.sendRedirect(redirectOnFail);
        }
    }
}