package com.nokia.ParkingLot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.ParkingLot.Model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

	public Car findByName(String name);

}
