package com.bayd.apautomation.mapper;


import com.bayd.apautomation.dto.DepartmentDto;
import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.Department;
import com.bayd.apautomation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper extends com.bayd.apautomation.mapper.Mapper<Department, DepartmentDto> {
    DepartmentMapper INSTANCE= Mappers.getMapper(DepartmentMapper.class);

//    User convertDTOtoEntity(UserDto userDto);
}
