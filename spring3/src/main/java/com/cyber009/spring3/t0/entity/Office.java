package com.cyber009.spring3.t0.entity;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;

import java.util.List;

@Entity
@Table(name = "offices", indexes = {
        @Index(columnList = "name")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@Slf4j
public class Office extends BaseEntity {

    @Column(columnDefinition = "NVARCHAR2(1024)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office parentOffice;

    @OneToMany(mappedBy = "parentOffice")
    private List<Office> childOffices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
