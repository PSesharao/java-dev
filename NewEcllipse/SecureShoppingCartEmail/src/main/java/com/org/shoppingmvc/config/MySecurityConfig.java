package com.org.shoppingmvc.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

@EnableWebSecurity // @EnableGlobalMethodSecurity(prePostEnabled=true) public
class MySecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
        .antMatchers("/registeruser").permitAll()
		.antMatchers("/register").permitAll().antMatchers("/home").hasAnyRole("USER", "ADMIN")
		.antMatchers("/shop").hasAnyRole("USER", "ADMIN").antMatchers("/category").hasAnyRole("ADMIN").antMatchers("/product").hasAnyRole("ADMIN").anyRequest()
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
