package com.bayd.apautomation.mapper;

import com.bayd.apautomation.dto.ApprovalDTO;
import com.bayd.apautomation.entity.Approval;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T19:32:40-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_351 (Oracle Corporation)"
)
public class ApprovalMapperImpl implements ApprovalMapper {

    @Override
    public Approval convertEntity(ApprovalDTO s) {
        if ( s == null ) {
            return null;
        }

        Approval approval = new Approval();

        approval.setAppid( s.getAppid() );
        approval.setStatus( s.getStatus() );
        approval.setComments( s.getComments() );

        return approval;
    }

    @Override
    public ApprovalDTO convertDto(Approval t) {
        if ( t == null ) {
            return null;
        }

        ApprovalDTO approvalDTO = new ApprovalDTO();

        approvalDTO.setAppid( t.getAppid() );
        approvalDTO.setStatus( t.getStatus() );
        approvalDTO.setComments( t.getComments() );

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
}
