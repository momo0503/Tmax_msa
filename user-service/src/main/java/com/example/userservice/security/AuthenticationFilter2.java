package com.example.userservice.security;

import com.example.userservice.vo.RequestLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter2 extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //요청정보를 보냈을때 처리시켜주는 메서드 정의해보겠따.
        // 사용자 요청 정보가 RequestLogin 클래스로 들어옴. Objectmapper로 변환해보겠음 , 전달되어진 inputStream에
        //전달되어진 inputStream에 어떤 값이 들어가있을때 그 값을 우리가 원하는 class 형태로 바꿈.
        //inputStream으로 받은 이유는 우리가 전달시켜주고자 하는 로그인의 값은 post형태로 전달되죠 post형태로 전달되는 것은 request parameter로 받을수 없기때문에
        //inputStream으로 처리해주시면 수작업으로 데이터가 어떤게 들어오는지 ? 처리하실수 있음
        try {
            RequestLogin creds = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
