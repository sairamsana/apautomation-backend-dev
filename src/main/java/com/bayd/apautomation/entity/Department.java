package com.bayd.apautomation.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Departments", schema = "apautomation")
@Data
@AllArgsConstructor
@Builder
@ToString
public class Department extends AbstractEntity implements Serializable {
    @Id
    @Type(type="uuid-char")
    @Column(name = "deptid")
    private UUID deptid;
    @Column(name = "name")
    private String name;
    public Department() {
        this.deptid = UUID.randomUUID();
    }

}
