package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto;

public record CarUpdateDto(Integer id,
                           String make,
                           String model,
                           int year,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           String color) {
}
