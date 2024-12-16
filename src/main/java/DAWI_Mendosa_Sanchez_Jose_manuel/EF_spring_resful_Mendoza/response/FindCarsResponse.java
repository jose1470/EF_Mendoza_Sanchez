package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.response;

import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
