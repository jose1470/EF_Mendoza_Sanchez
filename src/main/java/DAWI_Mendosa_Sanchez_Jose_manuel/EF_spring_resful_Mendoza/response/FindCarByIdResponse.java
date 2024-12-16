package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.response;

import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDetailDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDetailDto car) {
}
