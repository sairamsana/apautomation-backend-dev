package com.bayd.apautomation.controller;


import com.bayd.apautomation.dto.DepartmentDto;
import com.bayd.apautomation.dto.ResponseDTO;
import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.enums.Status;
import com.bayd.apautomation.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/department")
@RequiredArgsConstructor
public class DepartmentController implements AbstractController{

    DepartmentService departmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/save")
    public ResponseEntity<ResponseDTO> userRegister(@RequestBody DepartmentDto departmentDto,  @RequestParam("userId") UUID userUUID) {
        Optional<DepartmentDto> save = Optional.empty();
        System.out.println("value "+userUUID);
        try{
            save = departmentService.save(departmentDto,userUUID);
        }
        catch (Exception e){
            return getResponseWithErrorData(Status.NOT_FOUND,e.getMessage());
        }

        return !save.isPresent() ? getResponse(Status.FAILED) : getResponseWithData(Status.SUCCESS, save.get());
    }

}
