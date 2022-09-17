package com.wpollock.search.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Define View Controllers. These are trivial controllers that do nothing more
 * than set a view from a URL; if a controller processes input or update a model
 * (the data used by a view), then you need a regular Spring controller.
 *
 * @author wpollock
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/maint").setViewName("maint");
    }
}
