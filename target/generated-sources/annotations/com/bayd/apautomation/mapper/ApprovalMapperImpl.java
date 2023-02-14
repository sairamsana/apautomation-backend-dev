package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.ApprovalDTO;
import com.bayd.apautomation.dto.BillDTO;
import com.bayd.apautomation.dto.DepartmentDTO;
import com.bayd.apautomation.dto.UserDto;
import com.bayd.apautomation.entity.Approval;
import com.bayd.apautomation.entity.Bill;
import com.bayd.apautomation.entity.Department;
import com.bayd.apautomation.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-12T21:11:22-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class ApprovalMapperImpl implements ApprovalMapper {

    @Override
    public Approval convertEntity(ApprovalDTO s) {
        if ( s == null ) {
            return null;
        }

        Approval approval = new Approval();

        approval.setStatus( s.getStatus() );
        approval.setComments( s.getComments() );
        approval.setApprovalbill( billDTOToBill( s.getApprovalbill() ) );

        return approval;
    }

    @Override
    public ApprovalDTO convertDto(Approval t) {
        if ( t == null ) {
            return null;
        }

        ApprovalDTO approvalDTO = new ApprovalDTO();

        approvalDTO.setStatus( t.getStatus() );
        approvalDTO.setComments( t.getComments() );
        approvalDTO.setApprovalbill( billToBillDTO( t.getApprovalbill() ) );

        return approvalDTO;
    }

    @Override
    public List<ApprovalDTO> convertDtos(List<Approval> tList) {
        if ( tList == null ) {
            return null;
        }

        List<ApprovalDTO> list = new ArrayList<ApprovalDTO>( tList.size() );
        for ( Approval approval : tList ) {
            list.add( convertDto( approval ) );
        }

        return list;
    }

    @Override
    public List<Approval> convertEntities(List<ApprovalDTO> sList) {
        if ( sList == null ) {
            return null;
        }

        List<Approval> list = new ArrayList<Approval>( sList.size() );
        for ( ApprovalDTO approvalDTO : sList ) {
            list.add( convertEntity( approvalDTO ) );
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

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserid( userDto.getUserid() );
        user.setFirstname( userDto.getFirstname() );
        user.setLastname( userDto.getLastname() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setMobile( userDto.getMobile() );
        user.setIsverified( userDto.getIsverified() );
        user.setUserdepartments( departmentDTOListToDepartmentList( userDto.getUserdepartments() ) );

        return user;
    }

    protected Bill billDTOToBill(BillDTO billDTO) {
        if ( billDTO == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setBillid( billDTO.getBillid() );
        bill.setName( billDTO.getName() );
        bill.setAmount( billDTO.getAmount() );
        bill.setTax( billDTO.getTax() );
        bill.setDeptname( billDTO.getDeptname() );
        bill.setFilename( billDTO.getFilename() );
        bill.setBilldate( billDTO.getBilldate() );
        bill.setBilluser( userDtoToUser( billDTO.getBilluser() ) );
        bill.setApprovals( convertEntities( billDTO.getApprovals() ) );

        return bill;
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

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserid( user.getUserid() );
        userDto.setFirstname( user.getFirstname() );
        userDto.setLastname( user.getLastname() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setMobile( user.getMobile() );
        userDto.setIsverified( user.getIsverified() );
        userDto.setUserdepartments( departmentListToDepartmentDTOList( user.getUserdepartments() ) );

        return userDto;
    }

    protected BillDTO billToBillDTO(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillDTO billDTO = new BillDTO();

        billDTO.setBillid( bill.getBillid() );
        billDTO.setName( bill.getName() );
        billDTO.setAmount( bill.getAmount() );
        billDTO.setTax( bill.getTax() );
        billDTO.setDeptname( bill.getDeptname() );
        billDTO.setFilename( bill.getFilename() );
        billDTO.setBilldate( bill.getBilldate() );
        billDTO.setBilluser( userToUserDto( bill.getBilluser() ) );
        billDTO.setApprovals( convertDtos( bill.getApprovals() ) );

        return billDTO;
    }
}
