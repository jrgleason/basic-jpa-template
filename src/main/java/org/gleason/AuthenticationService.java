package org.gleason;

//import com.auth0.AuthenticationController;
//import com.auth0.IdentityVerificationException;
//import com.auth0.Tokens;
import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.example.security.TokenAuthentication;
import com.auth0.jwt.JWT;
import org.gleason.security.Auth0Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationService {
    @Autowired
    private Auth0Config appConfig;
    @Autowired
    private AuthenticationController controller;
    public void setToken(HttpServletRequest req) throws IdentityVerificationException {
        Tokens tokens = controller.handle(req);
        TokenAuthentication tokenAuth = new TokenAuthentication(JWT.decode(tokens.getIdToken()));
        SecurityContextHolder.getContext().setAuthentication(tokenAuth);
    }
    public String getUrl(final HttpServletRequest req){
        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
        return controller.buildAuthorizeUrl(req, redirectUri)
                .withScope("openid email")
                .withAudience(String.format("https://%s/userinfo", appConfig.getDomain()))
                .build();
    }
}
