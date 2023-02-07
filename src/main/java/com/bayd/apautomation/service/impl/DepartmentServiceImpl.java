package com.bayd.apautomation.service.impl;

import com.bayd.apautomation.dto.DepartmentDto;
import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.enums.Status;
import com.bayd.apautomation.service.DepartmentService;

import java.util.Optional;
import java.util.UUID;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Optional<DepartmentDto> save(DepartmentDto businessDto, UUID userUUID) {
        return Optional.empty();
    }

    @Override
    public Optional<DepartmentDto> get(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Status delete(UUID uuid) {
        return null;
    }
}
