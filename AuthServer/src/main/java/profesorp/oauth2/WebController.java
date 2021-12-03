package profesorp.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	 @RequestMapping({"/","index"})
	  public String inicio() {
	    return "index";
	  }

	 @RequestMapping("/webpriver")
	  public String privado() {
	    return "prier";
	  }
	 @RequestMapping("/webpublic")
	  public String loginpub() {
	    return "public";
	  }
	 @RequestMapping("/webadmin")
	  public String admin() {
	    return "admin";
	  }
	 @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }
}
