package com.wpollock.search.config;

import org.slf4j.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class LoginAttemptsLogger
    implements ApplicationListener<AbstractAuthenticationEvent> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @EventListener({ AuthenticationSuccessEvent.class, InteractiveAuthenticationSuccessEvent.class })
    public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
        if (authenticationEvent instanceof AuthenticationSuccessEvent
                || authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
            // ignored to prevent duplicate logging:
            // Spring actually sends 3 events on success!
            return;
        }

        Authentication authentication = authenticationEvent.getAuthentication();
        log.info("Login attempt with username \"{}\", {}", authentication.getName(),
                (authentication.isAuthenticated() ? "Success" : "Failled"));
    }

}
