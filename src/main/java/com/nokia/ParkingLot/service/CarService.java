package com.nokia.ParkingLot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.ParkingLot.Model.Car;
import com.nokia.ParkingLot.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;

	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	public Car getCarByName(String name) {
		return carRepository.findByName(name);
	}

	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}

	public Optional<Car> getCar(Long id) {
		return carRepository.findById(id);
	}
	
	public void delete(Car car) {
		carRepository.delete(car);
	}
}
