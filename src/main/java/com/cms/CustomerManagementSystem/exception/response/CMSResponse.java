package com.cms.CustomerManagementSystem.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMSResponse {
    private String message;
    Object data = new Object();
}
