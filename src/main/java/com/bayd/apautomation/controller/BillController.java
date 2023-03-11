package com.bayd.apautomation.controller;


import com.bayd.apautomation.dto.*;
import com.bayd.apautomation.enums.Status;
import com.bayd.apautomation.service.BillService;
import com.bayd.apautomation.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/bill")
@RequiredArgsConstructor
public class BillController implements AbstractController {

    private final DepartmentService departmentService;

    private final BillService billService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/save")
    public ResponseEntity<ResponseDTO> save(@ModelAttribute BillReqDTO billReqDTO, @RequestParam(name = "userId", required = false) UUID userUUID) {
        ApprovalDTO save = new ApprovalDTO();
        try {
            save = billService.saveorupdate(billReqDTO, userUUID);
        } catch (Exception e) {
            return getResponseWithErrorData(Status.NOT_FOUND, e.getMessage());
        }
        return !Objects.nonNull(save) ? getResponse(Status.FAILED) : getResponseWithData(Status.SUCCESS, save);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{uuid}")
    public ResponseEntity<ResponseDTO> get(@PathVariable("uuid") UUID uuid) {
        Optional<BillDTO> billDTO = billService.get(uuid);
        return !billDTO.isPresent() ? getResponse(Status.FAILED) : getResponseWithData(Status.SUCCESS, billDTO.get());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<ResponseDTO> getAllDepartments() {
        BillsDTO billsDTO = billService.getAllBills();
        return billsDTO.getBillDTOS().isEmpty() ? getResponse(Status.FAILED) : getResponseWithData(Status.SUCCESS, billsDTO);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{uuid}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable("uuid") UUID id) {
        return getResponse(departmentService.delete(id));
    }


}
