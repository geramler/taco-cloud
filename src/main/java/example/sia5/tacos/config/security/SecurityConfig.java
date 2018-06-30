package example.sia5.tacos.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(
						"select username, password, enabled from Users "
								+ "where username=?")
				.authoritiesByUsernameQuery(
						"select username, authority from UserAuthorities "
								+ "where username=?")
				.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
	}
	*/
}