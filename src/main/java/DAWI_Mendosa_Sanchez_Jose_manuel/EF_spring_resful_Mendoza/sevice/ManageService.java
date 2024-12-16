package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.sevice;

import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDetailDto;
import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDto;


import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int carId) throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
