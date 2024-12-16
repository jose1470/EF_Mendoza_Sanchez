package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto;

public record CarDetailDto(Integer id,
                           String make,
                           String model,
                           String licensePlate,
                           int year,
                           String ownerName,
                           String ownerContact,
                           String color) {
}
