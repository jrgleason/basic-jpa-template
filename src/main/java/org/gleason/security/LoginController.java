package org.gleason.security;

import com.auth0.AuthenticationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
public class LoginController {

    @Autowired
    private AuthenticationController controller;
    @Autowired
    private Auth0Config appConfig;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    protected String login(final HttpServletRequest req) {
        logger.debug("Performing login");
        String redirectUri = req.getScheme() +
                "://" +
                req.getServerName() +
                ":" +
                req.getServerPort() +
                "/callback";
        String authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri)
                .withAudience(
                        String.format(
                                "https://%s/userinfo",
                                appConfig.getDomain()
                        )
                )
                .build();
        return "redirect:" + authorizeUrl;
    }

}
