/**
 * @author L.I. Pablo Antonio García Santiago
 * @name ResourceServerConfig
 * @version 1.0.0
 * @autor-mail jack.skell.loki@gmail.com
 * @date 07/02/2024
 */
package mx.gob.oaxaca.nombre_proyecto.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        //.antMatchers(HttpMethod.GET,"/").permitAll()
        //.antMatchers(HttpMethod.POST,"/").permitAll()
        .anyRequest().authenticated()
        .and().cors().configurationSource(corsConfigurationSource()); 
    }
    
    @Bean    
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
            config.addAllowedOriginPattern("*");
            config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
            config.setAllowCredentials(true);
            config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    
    @Bean 
    public FilterRegistrationBean<CorsFilter>corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
