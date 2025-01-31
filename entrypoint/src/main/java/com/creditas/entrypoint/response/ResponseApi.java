package com.creditas.entrypoint.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T> {
    protected T content;
    protected ResponseError error;
}
