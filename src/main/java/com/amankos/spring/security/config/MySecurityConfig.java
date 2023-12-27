package com.amankos.spring.security.config;

import com.amankos.spring.security.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.jdbcAuthentication().dataSource(dataSource);

//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("aman").password("aman").roles(Roles.EMPLOYEE.toString()))
//                .withUser(userBuilder.username("kostas").password("kostas").roles(Roles.EMPLOYEE.toString(), Roles.MANAGER.toString()))
//                .withUser(userBuilder.username("mary").password("mary").roles(Roles.EMPLOYEE.toString(), Roles.ADMIN.toString()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(Roles.EMPLOYEE.toString(), Roles.MANAGER.toString(), Roles.HR.toString())
                .antMatchers("/api/employees/manager-page").hasRole(Roles.MANAGER.toString())
                .antMatchers("/api/employees/hr-page").hasRole(Roles.HR.toString())
                .and().formLogin().permitAll();
    }
}
