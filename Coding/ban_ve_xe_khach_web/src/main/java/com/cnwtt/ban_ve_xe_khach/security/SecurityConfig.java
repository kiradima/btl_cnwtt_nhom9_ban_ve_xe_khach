//package com.cnwtt.ban_ve_xe_khach.security;
//
//import com.cnwtt.ban_ve_xe_khach.enums.Role;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${application.enable-security}")
//    private boolean enableSecurity;
//    private org.slf4j.Logger Logger = LoggerFactory.getLogger(SecurityConfig.class);
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        if(enableSecurity){
//            Logger.info("Enable application security.");
//            http.authorizeRequests()
//                    .antMatchers("/swagger-ui.html").hasRole(Role.ADMIN.getName())
//                    .anyRequest()
//                    .authenticated();
//        } else{
//            Logger.info("Disble application security.");
//            http.authorizeRequests().anyRequest().permitAll();
//        }
//
//        http.formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/")
//                .usernameParameter("username")
//                .passwordParameter("password");
//
//        http.csrf().disable();
//    }
//}
