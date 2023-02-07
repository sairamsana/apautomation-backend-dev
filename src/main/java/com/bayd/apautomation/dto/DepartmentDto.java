package com.bayd.apautomation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class DepartmentDto extends AbstractDto {
    private UUID userid;
    private String name;

}
