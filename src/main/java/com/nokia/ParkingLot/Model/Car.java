package com.nokia.ParkingLot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long carId;
	private String name;

	public Car() {
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", name=" + name + "]";
	}

}