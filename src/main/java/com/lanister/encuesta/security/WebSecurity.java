package com.lanister.encuesta.security;

import com.lanister.encuesta.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@AllArgsConstructor
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter {

    private  final UserService userService;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception  {

        http.cors().and().csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/polls/**/questions").permitAll()
                .antMatchers(HttpMethod.POST, "/polls/reply").permitAll()
                .anyRequest().authenticated();
        http.addFilter(getAuthenticationFilter())
            .addFilter(new AuthorizationFilter(authenticationManager()))

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

    @Override
    public  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager());

        authenticationFilter.setFilterProcessesUrl(SecurityConstants.LOGIN_URL);

        return authenticationFilter;
    }
}
