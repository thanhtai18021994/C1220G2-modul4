package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.ws.Service;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;
    private String rentTypeName;
    private Double rentTypeCost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<EntityService> services;
}
