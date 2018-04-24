package org.gleason;
import com.auth0.AuthenticationController;
import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import com.auth0.jwt.JWT;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class Endpoint{
	@Autowired
	private AuthenticationController controller;
	@Autowired
	private AuthConfig appConfig;

	@GetMapping("")
	String get(final Principal principal){
		if(principal instanceof TokenAuthentication){
			return ((TokenAuthentication)principal).getUsername();
		}
		else{
			return "Not logged in";
		}
	}

	@GetMapping("/login")
	protected void login(final HttpServletRequest req, final HttpServletResponse http) throws IOException{
		String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
		String authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri)
				.withScope("openid email")
				.withAudience(String.format("https://%s/userinfo", appConfig.getDomain()))
				.build();
		http.sendRedirect(authorizeUrl);
	}
	@GetMapping("/callback")
	protected String getCallback(final HttpServletRequest req, final HttpServletResponse res) throws IOException {
        try {
			Tokens tokens = controller.handle(req);
			TokenAuthentication tokenAuth = new TokenAuthentication(JWT.decode(tokens.getIdToken()));
			SecurityContextHolder.getContext().setAuthentication(tokenAuth);
			res.sendRedirect("/");
		} catch (IdentityVerificationException e) {
			e.printStackTrace();
			SecurityContextHolder.clearContext();
			res.sendRedirect("/loginFailed");
		}
		return "Callback";
	}
	@GetMapping(value = "/logout2")
	protected void logout(final HttpServletRequest req, final HttpServletResponse res) throws IOException{
		invalidateSession(req);
		res.sendRedirect("https://jackiergleason.auth0.com/v2/logout");
	}
	private void invalidateSession(HttpServletRequest request) {
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
	}
}