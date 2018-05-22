package org.gleason.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
public class LogoutController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/logout")
    protected String logout(final HttpServletRequest req) {
        logger.debug("Performing logout");
        invalidateSession(req);
        return "redirect:" + req.getContextPath() + "/login";
    }

    private void invalidateSession(HttpServletRequest request) {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
    }

}

