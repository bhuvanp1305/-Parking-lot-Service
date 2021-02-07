package com.nokia.ParkingLot.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nokia.ParkingLot.Model.Car;
import com.nokia.ParkingLot.Model.ParkingSlot;

@Service
public class CarSlotAllocationService {

	private static final String ENTRY_TOPIC = "entry";
	private static final String EXIT_TOPIC = "exit";

	@Autowired
	ParkingLotService lotService;
	@Autowired
	CarService carService;

	/**
	 * Consume Kafka Messages
	 */
	@KafkaListener(topics = ENTRY_TOPIC, groupId = "group_id")
	public void allocateParkingSlot(Car car) {

		System.out.println(car.toString());
		car = carService.saveCar(car);
		System.out.println(car.toString());
		Iterable<ParkingSlot> parkingSlots = lotService.getParkingSlots();
		Iterator<ParkingSlot> iterator = parkingSlots.iterator();
		while (iterator.hasNext()) {
			ParkingSlot parkingSlot = iterator.next();
			if (parkingSlot.getCar() == null || parkingSlot.getCar().getCarId() == 0) {
				parkingSlot.setCar(car);
				lotService.saveParkingSlot(parkingSlot);
				break;
			}
		}
	}

	@KafkaListener(topics = EXIT_TOPIC, groupId = "group_id")
	public void releaseParkingSlot(Car car) {
		System.out.println(car.toString());

		car = carService.getCarByName(car.getName());
		Optional<ParkingSlot> parkingSlot = lotService.getParkingSlotByCar(car);
		ParkingSlot newParkingSlot = parkingSlot.get();
		newParkingSlot.setCar(null);
		lotService.saveParkingSlot(newParkingSlot);
		carService.delete(car);
	}

	/**
	 * Check In DB for free slot
	 */
	public boolean checkForFreeSLot() {

		Iterable<ParkingSlot> slots = lotService.getParkingSlots();
		Iterable<Car> cars = carService.getCars();

		long slotCount = slots.spliterator().getExactSizeIfKnown();
		long carCount = cars.spliterator().getExactSizeIfKnown();

		System.out.println(slotCount);
		System.out.println(carCount);
		if (slotCount > carCount) {
			return true;
		}
		return false;
	}

	public boolean checkForCar(Car car) {

		car = carService.getCarByName(car.getName());
		if (car == null) {
			return false;
		}
		return true;
	}
}