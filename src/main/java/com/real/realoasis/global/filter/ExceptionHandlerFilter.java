package com.real.realoasis.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.realoasis.domain.user.exception.UserNotFoundException;
import com.real.realoasis.global.error.response.ErrorResponse;
import com.real.realoasis.global.error.type.ErrorCode;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            setErrorResponse(ErrorCode.EXPIRATION_TOKEN_EXCEPTION, response);
        } catch (JwtException | IllegalArgumentException e) {
            setErrorResponse(ErrorCode.INVALID_TOKEN_EXCEPTION, response);
        } catch (UserNotFoundException e) {
            setErrorResponse(ErrorCode.USER_NOT_FOUND_EXCEPTION, response);
        }
    }

    public void setErrorResponse(ErrorCode errorCode, HttpServletResponse response) throws IOException {
        response.setStatus(errorCode.getStatus());
        response.setContentType("application/json");
        ErrorResponse errorResponse = new ErrorResponse(errorCode);
        String errorResponseEntityToJson = objectMapper.writeValueAsString(errorResponse);
        response.getWriter().write(errorResponseEntityToJson);
    }
}
