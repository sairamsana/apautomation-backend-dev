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
    date = "2023-02-23T19:32:39-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class BillMapperImpl implements BillMapper {

    @Override
    public Bill convertEntity(BillDTO s) {
        if ( s == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setBillid( s.getBillid() );
        bill.setName( s.getName() );
        bill.setAmount( s.getAmount() );
        bill.setTax( s.getTax() );
        bill.setDeptname( s.getDeptname() );
        bill.setFilename( s.getFilename() );
        bill.setBilldate( s.getBilldate() );
        bill.setBilluser( userDtoToUser( s.getBilluser() ) );
        bill.setApprovals( approvalDTOListToApprovalList( s.getApprovals() ) );

        return bill;
    }

    @Override
    public BillDTO convertDto(Bill t) {
        if ( t == null ) {
            return null;
        }

        BillDTO billDTO = new BillDTO();

        billDTO.setBillid( t.getBillid() );
        billDTO.setName( t.getName() );
        billDTO.setAmount( t.getAmount() );
        billDTO.setTax( t.getTax() );
        billDTO.setDeptname( t.getDeptname() );
        billDTO.setFilename( t.getFilename() );
        billDTO.setBilldate( t.getBilldate() );
        billDTO.setBilluser( userToUserDto( t.getBilluser() ) );
        billDTO.setApprovals( approvalListToApprovalDTOList( t.getApprovals() ) );

        return billDTO;
    }

    @Override
    public List<BillDTO> convertDtos(List<Bill> tList) {
        if ( tList == null ) {
            return null;
        }

        List<BillDTO> list = new ArrayList<BillDTO>( tList.size() );
        for ( Bill bill : tList ) {
            list.add( convertDto( bill ) );
        }

        return list;
    }

    @Override
    public List<Bill> convertEntities(List<BillDTO> sList) {
        if ( sList == null ) {
            return null;
        }

        List<Bill> list = new ArrayList<Bill>( sList.size() );
        for ( BillDTO billDTO : sList ) {
            list.add( convertEntity( billDTO ) );
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

    protected Approval approvalDTOToApproval(ApprovalDTO approvalDTO) {
        if ( approvalDTO == null ) {
            return null;
        }

        Approval approval = new Approval();

        approval.setAppid( approvalDTO.getAppid() );
        approval.setStatus( approvalDTO.getStatus() );
        approval.setComments( approvalDTO.getComments() );

        return approval;
    }

    protected List<Approval> approvalDTOListToApprovalList(List<ApprovalDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Approval> list1 = new ArrayList<Approval>( list.size() );
        for ( ApprovalDTO approvalDTO : list ) {
            list1.add( approvalDTOToApproval( approvalDTO ) );
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

    protected ApprovalDTO approvalToApprovalDTO(Approval approval) {
        if ( approval == null ) {
            return null;
        }

        ApprovalDTO approvalDTO = new ApprovalDTO();

        approvalDTO.setAppid( approval.getAppid() );
        approvalDTO.setStatus( approval.getStatus() );
        approvalDTO.setComments( approval.getComments() );

        return approvalDTO;
    }

    protected List<ApprovalDTO> approvalListToApprovalDTOList(List<Approval> list) {
        if ( list == null ) {
            return null;
        }

        List<ApprovalDTO> list1 = new ArrayList<ApprovalDTO>( list.size() );
        for ( Approval approval : list ) {
            list1.add( approvalToApprovalDTO( approval ) );
        }

        return list1;
    }
}
