package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 *
	 * Disable http basic authentication. We don't want to see the prompt.
	 * Permit access to the /api/public endpoint
	 * All other requests need to be secured.
	 *
	 * @param http
	 * @throws Exception
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.httpBasic().disable()
			.authorizeRequests()
				.antMatchers("/api/public").permitAll()
				.anyRequest().authenticated()
				.and()
//			.formLogin()
//				.defaultSuccessUrl("/", true)
//				.permitAll()
//				.and()
//			.httpBasic()
//				.and()
			.csrf().disable()
			.logout()
				.logoutSuccessUrl("/");
	}

}
// end::code[]