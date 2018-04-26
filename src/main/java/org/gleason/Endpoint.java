package org.gleason;

import com.auth0.IdentityVerificationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class Endpoint{
	@Autowired
	private AuthenticationService authService;


	@GetMapping("")
	String get(final Principal principal){
		return "index";
	}

	@GetMapping("/ui")
	String ui(){
		return "forward:/";
	}

	@GetMapping("/login")
	protected void login(final HttpServletRequest req, final HttpServletResponse http) throws IOException{
		http.sendRedirect(authService.getUrl(req));
	}
	@GetMapping("/callback")
	protected void getCallback(final HttpServletRequest req, final HttpServletResponse res) throws IdentityVerificationException, IOException {
        authService.setToken(req);
		res.sendRedirect("/");
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