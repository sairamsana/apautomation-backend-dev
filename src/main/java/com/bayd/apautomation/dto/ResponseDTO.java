package com.bayd.apautomation.dto;

import com.bayd.apautomation.enums.Status;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ResponseDTO {
    private String message;
    private Object data;
    private Status status;
}
