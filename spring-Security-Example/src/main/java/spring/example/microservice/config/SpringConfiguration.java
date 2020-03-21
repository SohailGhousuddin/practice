package spring.example.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("test").password("test").roles("USER");
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
		.authorizeRequests()
		//.antMatchers("**/rest/*")
		.anyRequest()
		.fullyAuthenticated()
		.and().httpBasic();
		httpSecurity.csrf().disable();
		
		
	}

}
