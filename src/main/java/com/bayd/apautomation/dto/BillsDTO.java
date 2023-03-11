package com.bayd.apautomation.dto;

import lombok.Data;

import java.util.List;

@Data
public class BillsDTO {
    private int page;
    private int limit;
    private long total;
    private List<BillDTO> billDTOS;
}
