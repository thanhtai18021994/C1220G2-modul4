package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;
    @Pattern(regexp = "^DV-\\d{4}$",message = "DV-xxxx x là số 0-9")
    private String codeService;
    @NotBlank
    private String serviceName;
    @Min(1)
    private Double serviceArea;
    @Min(1)
    private Double serviceCost;
    @Min(1)
    private Integer serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(1)
    private Double poolArea;
    @Min(1)
    private Integer numberOfFloor;
    @ManyToOne()
    @JoinColumn(name = "service_type_id",nullable = false)
    private ServiceType serviceType;
    @ManyToOne()
    @JoinColumn(name = "rent_type_id",nullable = false)
    private RentType rentType;
    @OneToMany(mappedBy = "services")
    private Set<Contract> contracts;
}

