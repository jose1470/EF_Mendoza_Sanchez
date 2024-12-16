package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.api;


import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDetailDto;
import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDto;
import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.response.*;
import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.sevice.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {

                Optional<CarDto> optional = manageService.getAllCarsById(Integer.parseInt(id));

                if (optional.isPresent()) {

                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));

                } else {

                    return new FindCarsResponse("02", "Car not found", null);
                }

            } else {

                List<CarDto> cars = manageService.getAllCars();
                if (!cars.isEmpty())
                    return new FindCarsResponse("01", "", cars);
                else
                    return new FindCarsResponse("03", "Car list not found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "service not found", null);
        }
    }


    @GetMapping("/detail")
    public FindCarByIdResponse findCarByID(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {

                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));

                if (optional.isPresent()) {

                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDetailDto);

                } else {
                    return new FindCarByIdResponse("02", "Car not found", null);
                }

            } else {

                return new FindCarByIdResponse("03", "Parameter not found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "service not found", null);
        }
    }


    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

        try {

            if (manageService.updateCar(carDto)) {

                return new UpdateCarResponse("01", "Carro Actualizado Correctamente");

            } else {

                return new UpdateCarResponse("02", "Car not found");
            }

        } catch (Exception e) {

            e.printStackTrace();
            return new UpdateCarResponse("99", "service not found");
        }
    }


    @DeleteMapping("/delete")
    public DeleteCarResponseById deleteCarByID(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            int carId = Integer.parseInt(id);
            if (carId > 0) {
                boolean deleted = manageService.deleteCarById(carId);

                if (deleted) {
                    return new DeleteCarResponseById("01", "Carro Eliminado Correctamente");
                } else {
                    return new DeleteCarResponseById("02", "Car not found");
                }

            } else {
                return new DeleteCarResponseById("03", "Invalid parameter");
            }

        } catch (NumberFormatException e) {
            return new DeleteCarResponseById("03", "Invalid parameter format");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponseById("99", "please try again");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {

        try {
            if (manageService.addCar(carDetailDto))

                return new CreateCarResponse("01", null);

            else return new CreateCarResponse("02", "User already exists");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Error en el servicio");
        }
    }
}
