
package com.mindtree.shoppingmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableOAuth2Sso
@Configuration
@EnableWebSecurity // @EnableGlobalMethodSecurity(prePostEnabled=true) public
class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http. antMatcher("/**"). authorizeRequests().
		 * antMatchers("/").permitAll().anyRequest().
		 * authenticated().and().oauth2Login();
		 */
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll().anyRequest().
		 * authenticated().and() .csrf().disable();
		 */
		//http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
		http.antMatcher("/**").
		authorizeRequests().
		antMatchers("/").permitAll().
		anyRequest().
		authenticated().and()
		.oauth2Login();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/assets/**",
				"/fonts/**", "/dis/**", "/vendor1/**");
	}

}
