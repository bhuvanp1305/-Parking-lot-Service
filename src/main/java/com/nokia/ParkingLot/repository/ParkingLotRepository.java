package com.nokia.ParkingLot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nokia.ParkingLot.Model.Car;
import com.nokia.ParkingLot.Model.ParkingSlot;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingSlot, Long> {

	public Optional<ParkingSlot> findByCar(Car car);

	public Iterable<ParkingSlot> findByCarIsNull();

}
