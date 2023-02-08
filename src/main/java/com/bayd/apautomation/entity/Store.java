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
@Table(name = "Stores", schema = "apautomation")
@Data
@AllArgsConstructor
@Builder
@ToString
public class Store extends AbstractEntity implements Serializable {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "storeid")
    private UUID storeid;
    @Column(name = "name")
    private String name;

    public Store() {
        this.storeid = UUID.randomUUID();
    }

}
