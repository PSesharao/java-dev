
package com.mindtree.shoppingmvc.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity // @EnableGlobalMethodSecurity(prePostEnabled=true) public
class MySecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll()
		 * .antMatchers("/registeruser").permitAll()
		 * .antMatchers("/register").permitAll().antMatchers("/home").hasAnyRole("USER",
		 * "ADMIN") .antMatchers("/shop").hasAnyRole("USER",
		 * "ADMIN").antMatchers("/category").hasAnyRole("ADMIN").antMatchers("/product")
		 * .hasAnyRole("ADMIN").anyRequest()
		 * .authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl(
		 * "/home").permitAll().and()
		 * .logout().logoutSuccessUrl("/login?logout=true").permitAll().and().csrf().
		 * disable();
		 */
		http.csrf().disable().authorizeRequests() 
		.anyRequest().authenticated();
	}
	
	 @Override
     public void configure(WebSecurity web) throws Exception {
         web
             .ignoring()
             .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/assets/**","/fonts/**","/dis/**","/vendor1/**");
     }

	
}
