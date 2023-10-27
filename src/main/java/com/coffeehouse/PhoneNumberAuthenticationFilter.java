package com.coffeehouse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhoneNumberAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public PhoneNumberAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/phone", "POST"));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String phoneNumber = request.getParameter("phoneNumber");
        PhoneNumberAuthenticationToken authRequest = new PhoneNumberAuthenticationToken(phoneNumber);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
