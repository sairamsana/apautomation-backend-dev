package com.bayd.apautomation.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class AbstractEntity {

    @Column(name = "createdon")
    private Date createdon;
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updatedon")
    private Date updatedon;
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "isactive")
    private Boolean isactive;
    @Column(name = "isdeleted")
    private Boolean isdeleted;

}
