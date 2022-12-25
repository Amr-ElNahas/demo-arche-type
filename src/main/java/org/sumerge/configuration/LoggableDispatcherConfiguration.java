package org.sumerge.configuration;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.sumerge.common.LoggableDispatcherServlet;

//@Configuration
public class LoggableDispatcherConfiguration {

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        LoggableDispatcherServlet loggableDispatcherServlet=new LoggableDispatcherServlet();
//        loggableDispatcherServlet.setEnableLoggingRequestDetails(true);
        return loggableDispatcherServlet;
    }
}
