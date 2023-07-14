package com.example.wondugallery.response;


import lombok.*;
import org.springframework.http.HttpStatus;
import org.w3c.dom.html.HTMLAppletElement;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicResponse {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private Integer count;
    private List<?> result;

    public static BasicResponse of(Integer code, HttpStatus httpStatus, String message, Integer count, List<Object> result) {
        return new BasicResponse(code,httpStatus,message,count,result);
    }

}
