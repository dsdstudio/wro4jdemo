package net.dsdstudio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.isdc.wro.http.ConfigurableWroFilter;
import ro.isdc.wro.http.WroFilter;

import java.util.Arrays;

/**
 * Created by bhkim on 2016. 10. 28..
 */
@Configuration
public class Wro4jConfig {
    @Bean
    @ConfigurationProperties(locations = "classpath:wro.properties")
    public WroFilter wroFilter() {
        return new ConfigurableWroFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(WroFilter wroFilter) {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(wroFilter);
        bean.setName("wroFilter");
        bean.setUrlPatterns(Arrays.asList("/wro/*"));
        return bean;
    }
}
