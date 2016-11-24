package com.blueberry.spittr.conf;


import com.blueberry.spittr.services.SpitterRepository;
import com.blueberry.spittr.services.impl.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


/**
 * Created by Administrator on 11/23/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    javax.sql.DataSource dataSource = null;

    @Autowired
    SpitterRepository spitterRepository;

    public void setSpitterRepository(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /**
     * 通过重载，配置Spring Security的Filter链。
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    /**
     * 通过重载，配置如何通过拦截器保护请求。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/spitters/me").hasAuthority("ROLE_SPITTER")
                .antMatchers("/spitters/ttt").hasRole("SPITTER")
                .antMatchers("/spitters/xxx").access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.2')")
                .antMatchers(HttpMethod.POST, "/spittles")
                .authenticated()
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure()/*需要Https*/
                .and()
                .formLogin()
        ;
    }

    /**
     * 通过重载，配置user-detail服务
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 启动内存用户存储,
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER","ADMIN");

        // 基于数据库表进行认证
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,true" +
//                        "from Spitter where username=?")
//                .groupAuthoritiesByUsername(
//                        "select username,'ROLE_USER' from Spitter where username=?"
//                ).passwordEncoder(new StandardPasswordEncoder("53dsxews"));

        // 基于LDAP 进行认证
        // userSearchBase() 属性为查找用户提供了基础查询,同样，groupSearchBase()为
        // 查找组指定了基础查询。我们声明用户应该在名为people的组织单元下搜索而不是从
        // 跟开始，而组应该在名为groups的组织单元下搜索。
//        auth.ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
////                .passwordCompare()
////                .passwordEncoder(new Md5PasswordEncoder())
////                .passwordAttribute("passcode");
//                .contextSource()
//                .root("dc=habuma,dc=com")
//                .ldif("classpath:users.ldif");

        // 配置自定义的用户服务
        auth.userDetailsService(new SpitterUserService(spitterRepository));

    }
}
