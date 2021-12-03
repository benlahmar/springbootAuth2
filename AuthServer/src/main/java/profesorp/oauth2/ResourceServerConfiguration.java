package profesorp.oauth2;



import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{
	  @RequestMapping("/publication")
	  public String publico() {
	    return "page de Publication";
	  }
	  @RequestMapping("/priver")
	  public String privada() {
	    return "page Priver";
	  }
	  @RequestMapping("/admin")
	  public String admin() {
	    return "page Administration";
	  }
	  @Override
		public void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publication").permitAll();
//			 .anyRequest().authenticated();
			http.requestMatchers().antMatchers("/priver")
			.and().authorizeRequests()
			.antMatchers("/priver").access("hasRole('USER')")
			.and().requestMatchers().antMatchers("/admin")
			.and().authorizeRequests()
			.antMatchers("/admin").access("hasRole('ADMIN')");
		}   

}

