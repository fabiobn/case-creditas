package com.creditas.entrypoint.exceptionhandler;

import com.creditas.entrypoint.response.ResponseApi;
import com.creditas.entrypoint.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<?>> exceptionHandler(final Exception ex) {
        ResponseError apiError = ResponseError.builder().build();

        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, apiError);
    }

    private ResponseEntity<ResponseApi<?>> buildResponseError(final HttpStatus httpStatus,
                                                              final ResponseError responseError) {
        return ResponseEntity
                .status(httpStatus)
                .body(ResponseApi.builder().error(responseError).build());
    }
}
