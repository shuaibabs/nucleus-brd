package brd.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    //no code needed
}

/*
In Spring web applications, security is implemented using DelegatingFilterProxy. To register it, with spring container in Java configuration, you shall use AbstractSecurityWebApplicationInitializer.

The spring will detect the instance of this class during application startup, and register the DelegatingFilterProxy to use the springSecurityFilterChain before any other registered Filter. It also register a ContextLoaderListener.
 */
