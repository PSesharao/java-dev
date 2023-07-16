
package com.mindtree.passenger.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration

@EnableWebSecurity // @EnableGlobalMethodSecurity(prePostEnabled=true) public
class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")

	@Bean

	@Override
	public UserDetailsService userDetailsService() {

		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests().antMatchers("/").permitAll()
        .antMatchers("/registeruser").permitAll()
		.antMatchers("/register").permitAll().antMatchers("/home").hasAnyRole("USER", "ADMIN")
		.antMatchers("/passenger").hasAnyRole("USER", "ADMIN").antMatchers("/city").hasAnyRole("ADMIN").antMatchers("/train").hasAnyRole("ADMIN").antMatchers("/approve").hasAnyRole("ADMIN").anyRequest()
		.authenticated().and().formLogin().loginPage("/login").usernameParameter("email").defaultSuccessUrl("/home").permitAll().and()
		.logout().logoutSuccessUrl("/login?logout=true").permitAll().and()
        .exceptionHandling().accessDeniedPage("/forbidden").and().csrf().disable();
	}
	
	 @Override
     public void configure(WebSecurity web) throws Exception {
         web
             .ignoring()
             .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/assets/**","/fonts/**","/dis/**","/vendor1/**");
     }

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
