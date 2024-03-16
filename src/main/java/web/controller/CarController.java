package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import Model.Car;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/cars")
    public String getCars (Model model, @RequestParam(name = "count", defaultValue = "-1") int count) {
        List<Car> allCars = carService.listCars();
        List<Car> cars = carsByRequest(allCars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
    private List<Car> carsByRequest (List<Car> allCars, int count) {
        if (count > 0 && count < 5) {
            int min = Math.min(count, allCars.size());
            return allCars.subList(0, min);
        } else {
            return allCars;
        }
    }

}
