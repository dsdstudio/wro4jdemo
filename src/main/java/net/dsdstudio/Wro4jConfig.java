package net.dsdstudio;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.isdc.wro.http.WroFilter;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;

import java.util.Arrays;

/**
 * Created by bhkim on 2016. 10. 28..
 */
@Configuration
public class Wro4jConfig {
    @Bean
    public WroFilter wroFilter() {
        return new WroFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(WroFilter wroFilter) {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("wroFilter");
        bean.setFilter(wroFilter);
        bean.setUrlPatterns(Arrays.asList("/wro/*"));
        return bean;
    }
}
