package me.janah.patientsmvc.security;

import me.janah.patientsmvc.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("user"));
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN")
                .and()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER");*/

        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal, role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);*/

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        // .hasAuthority("ADMIN") -> userDetailsService
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN"); /*.hasRole("ADMIN");*/
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER"); /*.hasRole("USER");*/
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests()
                .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }

}
