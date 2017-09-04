package top.jengeo;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


/**
 * Created by jajeo on 31/08/2017.
 */

@Configuration
@ConditionalOnWebApplication
public class ShiroAutoConfiguration {

    @Value("${shiro.config.location}")
    private String shiroConfigLocation;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new ShiroFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new EnvironmentLoaderListener());
        registrationBean.addInitParameter("shiroEnvironmentClass", "org.apache.shiro.web.env.IniWebEnvironment");
        registrationBean.addInitParameter("shiroConfigLocations", shiroConfigLocation);
        return registrationBean;
    }

}
