package com.tipu.spring_security.security.jwt;
import com.tipu.spring_security.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    protected UserDetailsServiceImp userDetailsService;

    private  String parseJwt(HttpServletRequest request){
        String headerAuth = request.getHeader("Authorization");

        if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")){

            return headerAuth.substring(7);
        }
        return null;
    }


    @Override
    protected  void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain){
        try {
            String jwt = parseJwt(request);
            if(jwt != null && jwtUtils.validateJwtToken(jwt) ){

            }
        }
    }

}
