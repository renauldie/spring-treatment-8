package com.spring.threatment.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {
    private String code;
    private String message;
    private Object data;
}