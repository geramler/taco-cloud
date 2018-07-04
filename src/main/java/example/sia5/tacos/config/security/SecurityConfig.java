package example.sia5.tacos.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from Users " + "where username=?")
				.authoritiesByUsernameQuery("select username, authority from UserAuthorities " + "where username=?")
				.passwordEncoder(encoder());

		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests().
				antMatchers("/design", "/orders").
					hasRole("USER").
				antMatchers("/**")
					.permitAll()
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/design", true)
					.loginProcessingUrl("/authenticate")
					.usernameParameter("user")
					.passwordParameter("pwd");		
	}

	@Bean
	public StandardPasswordEncoder encoder() {
		return new StandardPasswordEncoder("53cr3t");
	}

}