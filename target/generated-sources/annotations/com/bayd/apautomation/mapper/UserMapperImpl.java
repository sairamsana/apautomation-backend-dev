package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.DepartmentDTO;
import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.Department;
import com.bayd.apautomation.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T19:32:39-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertEntity(UserDto s) {
        if ( s == null ) {
            return null;
        }

        User user = new User();

        user.setUserid( s.getUserid() );
        user.setFirstname( s.getFirstname() );
        user.setLastname( s.getLastname() );
        user.setPassword( s.getPassword() );
        user.setEmail( s.getEmail() );
        user.setMobile( s.getMobile() );
        user.setIsverified( s.getIsverified() );
        user.setUserdepartments( departmentDTOListToDepartmentList( s.getUserdepartments() ) );

        return user;
    }

    @Override
    public UserDto convertDto(User t) {
        if ( t == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserid( t.getUserid() );
        userDto.setFirstname( t.getFirstname() );
        userDto.setLastname( t.getLastname() );
        userDto.setPassword( t.getPassword() );
        userDto.setEmail( t.getEmail() );
        userDto.setMobile( t.getMobile() );
        userDto.setIsverified( t.getIsverified() );
        userDto.setUserdepartments( departmentListToDepartmentDTOList( t.getUserdepartments() ) );

        return userDto;
    }

    @Override
    public List<UserDto> convertDtos(List<User> tList) {
        if ( tList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( tList.size() );
        for ( User user : tList ) {
            list.add( convertDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> convertEntities(List<UserDto> sList) {
        if ( sList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( sList.size() );
        for ( UserDto userDto : sList ) {
            list.add( convertEntity( userDto ) );
        }

        return list;
    }

    protected Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDeptid( departmentDTO.getDeptid() );
        department.setName( departmentDTO.getName() );

        return department;
    }

    protected List<Department> departmentDTOListToDepartmentList(List<DepartmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Department> list1 = new ArrayList<Department>( list.size() );
        for ( DepartmentDTO departmentDTO : list ) {
            list1.add( departmentDTOToDepartment( departmentDTO ) );
        }

        return list1;
    }

    protected DepartmentDTO departmentToDepartmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setDeptid( department.getDeptid() );
        departmentDTO.setName( department.getName() );

        return departmentDTO;
    }

    protected List<DepartmentDTO> departmentListToDepartmentDTOList(List<Department> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentDTO> list1 = new ArrayList<DepartmentDTO>( list.size() );
        for ( Department department : list ) {
            list1.add( departmentToDepartmentDTO( department ) );
        }

        return list1;
    }
}
