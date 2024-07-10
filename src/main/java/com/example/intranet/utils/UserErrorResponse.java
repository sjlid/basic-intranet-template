package com.example.intranet.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserErrorResponse {
    private String message;
    private long timestamp;
}
