package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String  make;
    private String model;
    private Integer year;
    private String vin;
    private String licensePlate;
    private String ownerName;
    private String ownerContact;
    private Date purchaseDate;
    private Integer mileage;
    private String engineType;
    private String color;
    private String insuranceCompany;
    private String insurancePolicyNumber;
    private Date registrationExpirationDate;
    private Date serviceDueDate;

}