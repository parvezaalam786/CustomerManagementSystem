package com.cms.CustomerManagementSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMSException extends Exception {
    private String errorMessage;
    private HttpStatus httpStatus;
}
