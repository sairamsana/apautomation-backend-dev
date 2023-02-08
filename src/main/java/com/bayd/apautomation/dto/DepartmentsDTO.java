package com.bayd.apautomation.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentsDTO {
    private int page;
    private int limit;
    private long total;
    private List<DepartmentDTO> departmentsDTO;
}
