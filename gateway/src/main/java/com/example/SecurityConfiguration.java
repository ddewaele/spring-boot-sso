/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/backend1","/backend2").permitAll().anyRequest().authenticated();
		http
			.authorizeRequests()
				.antMatchers("/","index.html").permitAll()
				.anyRequest().authenticated()
				.and()
//          By addng this, we are getting a formlogin redirect on all protected resources, even the ones proxied by zuul
			.formLogin()
				.defaultSuccessUrl("/", true)
				.permitAll()
				.and()
			.httpBasic()
				.and()
			.logout()
                .logoutUrl("/logout")
		        .logoutSuccessUrl("/")
                .and()
            .csrf().disable();

	}

}
