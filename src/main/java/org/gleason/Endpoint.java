package org.gleason;

//import com.auth0.IdentityVerificationException;
import com.auth0.Tokens;
import org.gleason.authorization.domain.Role;
import org.gleason.authorization.service.RoleService;
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
	private RoleService roleService;


	@GetMapping("")
	String get(final Principal principal){
		return "index";
	}

	@GetMapping("/ui")
	String ui(){
		return "forward:/";
	}
	@GetMapping(value = "/logout2")
	protected void logout(final HttpServletRequest req, final HttpServletResponse res) throws IOException{
		invalidateSession(req);
		res.sendRedirect("https://jackiergleason.auth0.com/v2/logout");
	}
	@GetMapping("/roles")
	@ResponseBody
	protected String getRoles(){
		return roleService.getRoles().toString();
	}
	@PostMapping("/roles")
	protected void addRole(){
		Role result = new Role();
		result.setName("Role Name");
		roleService.addRole(result);
	}


	private void invalidateSession(HttpServletRequest request) {
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
	}
}