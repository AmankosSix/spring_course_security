package com.amankos.spring.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // This method returns the root configuration of your application (beans defined in MyConfig and SecurityConfig)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // This method returns the configuration of the servlet application (beans defined in MyConfig)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    }

    // This method returns the servlet mapping for the DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
