package web.service;

import Model.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    @Override
    public List<Car> listCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Brand A", "333", 150));
        cars.add(new Car("Brand B", "Z5", 249));
        cars.add(new Car("Brand C", "MMX", 249));
        cars.add(new Car("Brand D", "Vimana", 300));
        cars.add(new Car("Brand E", "Juggernaut", 350));
        return cars;
    }

}
