package net.dsdstudio;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ro.isdc.wro.http.ConfigurableWroFilter;
import ro.isdc.wro.http.WroFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by bhkim on 2016. 10. 28..
 */
@Configuration
public class Wro4jConfig {
    @Bean
    public WroFilter wroFilter() {
        ConfigurableWroFilter wroFilter = new ConfigurableWroFilter();
        Properties p = new Properties();
        try {
            p.load(new ClassPathResource("wro.properties").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        wroFilter.setProperties(p);
        return wroFilter;
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
