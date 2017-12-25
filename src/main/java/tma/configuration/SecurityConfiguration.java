package tma.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import tma.service.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
    UserDetailsServiceImpl userDetailsService ;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService); 
    }
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.authorizeRequests()
      
        .antMatchers("/", "/home").permitAll() 
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/user/**").access("hasRole('USER')")
        .antMatchers("/dba/**").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login")
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf().disable();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }
}