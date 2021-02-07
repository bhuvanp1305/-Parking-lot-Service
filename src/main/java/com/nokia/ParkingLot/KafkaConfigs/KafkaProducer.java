package com.nokia.ParkingLot.KafkaConfigs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nokia.ParkingLot.Model.Car;

@Service
public class KafkaProducer {

	private static final String ENTRY_TOPIC = "entry";
	private static final String EXIT_TOPIC = "exit";

	@Autowired
	private KafkaTemplate<String, Car> parkingTemplate;

	public void parkTheCar(Car car) {
		System.out.println(car.toString());
		this.parkingTemplate.send(ENTRY_TOPIC, car);
	}

	public void billTheCar(Car car) {
		System.out.println(car.toString());
		this.parkingTemplate.send(EXIT_TOPIC, car);
	}
}