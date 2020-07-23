package com.zero.managemeal.abc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private DataSource dataSource;
	
	private final String USERS_QUERY = "select email, password, active from user where email=?";
	private final String ROLES_QUERY = "select u.email, r.name from user u inner join role r on (u.user_roles = r.id) where u.email=?";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		.usersByUsernameQuery(USERS_QUERY)
		.authoritiesByUsernameQuery(ROLES_QUERY)
		.dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/signup").permitAll()
				.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.csrf()
				.disable()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.failureUrl("/login?message=error")
				.defaultSuccessUrl("/welcome")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.and()
//			.rememberMe()
//				.tokenRepository(persistentTokenRepository())
//				.tokenValiditySeconds(60*60)
				/* .and() */
			.exceptionHandling()
				.accessDeniedPage("/access_denied");
	}
	
	public PersistentTokenRepository persistentTokenRepository() {
		
		JdbcTokenRepositoryImpl jdbcTRI = new JdbcTokenRepositoryImpl();
		jdbcTRI.setDataSource(dataSource);
		return jdbcTRI;
	}
}
