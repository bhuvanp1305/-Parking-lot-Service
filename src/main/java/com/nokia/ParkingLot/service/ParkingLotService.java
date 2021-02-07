package com.nokia.ParkingLot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.ParkingLot.Model.Car;
import com.nokia.ParkingLot.Model.ParkingSlot;
import com.nokia.ParkingLot.repository.ParkingLotRepository;

@Service
public class ParkingLotService {

	@Autowired
	ParkingLotRepository parkingLotRepository;

	public void saveParkingSlot(ParkingSlot parkingSlot) {
		parkingLotRepository.save(parkingSlot);
	}

	public Iterable<ParkingSlot> getParkingSlots() {
		return parkingLotRepository.findAll();
	}

	public Optional<ParkingSlot> getParkingSlot(Long id) {
		return parkingLotRepository.findById(id);
	}

	public Optional<ParkingSlot> getParkingSlotByCar(Car car) {
		return parkingLotRepository.findByCar(car);
	}

	public Iterable<ParkingSlot> getAvailabeParkingSlots() {
		return parkingLotRepository.findByCarIsNull();
	}
}
