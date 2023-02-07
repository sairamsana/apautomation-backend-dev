package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.DepartmentDto;
import com.bayd.apautomation.entity.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-05T19:18:16-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department convertEntity(DepartmentDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( arg0.getName() );

        return department;
    }

    @Override
    public DepartmentDto convertDto(Department arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setName( arg0.getName() );

        return departmentDto;
    }

    @Override
    public List<DepartmentDto> convertDtos(List<Department> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( arg0.size() );
        for ( Department department : arg0 ) {
            list.add( convertDto( department ) );
        }

        return list;
    }

    @Override
    public List<Department> convertEntities(List<DepartmentDto> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Department> list = new ArrayList<Department>( arg0.size() );
        for ( DepartmentDto departmentDto : arg0 ) {
            list.add( convertEntity( departmentDto ) );
        }

        return list;
    }
}
