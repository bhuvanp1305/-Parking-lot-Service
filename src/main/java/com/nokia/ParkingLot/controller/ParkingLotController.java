package com.nokia.ParkingLot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.ParkingLot.KafkaConfigs.KafkaProducer;
import com.nokia.ParkingLot.Model.Car;
import com.nokia.ParkingLot.service.CarSlotAllocationService;
import com.nokia.ParkingLot.service.ParkingLotService;

@RestController
@RequestMapping(value = "/parking-lot/")
public class ParkingLotController {

	@Autowired
	CarSlotAllocationService carSlotAllocationService;
	@Autowired
	ParkingLotService parkingLotService;

	private final KafkaProducer producer;

	public ParkingLotController(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping("/entry")
	@ResponseBody
	public String entryInParkingLot(@RequestBody Car car) {
		System.out.println("Entry");
		System.out.println(car.toString());
		if (!carSlotAllocationService.checkForCar(car)) {
			if (carSlotAllocationService.checkForFreeSLot()) {
				producer.parkTheCar(car);
				return "Car " + car.getName() + " parked.";
			} else
				return "No Slots available.";
		} else
			return "Car " + car.getName() + " is already parked.";

	}

	@GetMapping("/slots")
	public Iterable<com.nokia.ParkingLot.Model.ParkingSlot> ParkingSlot() {
		// TODO Auto-generated method stub
		System.out.println("Slots");
		return parkingLotService.getParkingSlots();
	}

	@PostMapping("/exit")
	@ResponseBody
	public String exitFromParkingLot(@RequestBody Car car) {
		// TODO Auto-generated method stub
		System.out.println("Exit");
		System.out.println(car.toString());
		if (carSlotAllocationService.checkForCar(car)) {
			producer.billTheCar(car);
			return "Car " + car.getName() + " billed and leaving parking slot.";
		} else
			return "No car available.";
	}

	@GetMapping("/available-slots")
	public Object availableSlots() {
		// TODO Auto-generated method stub
		System.out.println("Available Slots");
		return parkingLotService.getAvailabeParkingSlots();
	}
}