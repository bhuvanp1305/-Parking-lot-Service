package com.nokia.ParkingLot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Ronnie
 *
 */
@Entity
public class ParkingSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long parkingId;
	private String name;
	@OneToOne
	@JoinColumn(name = "carId")
	private Car car;

	/*
	 * @Transient private boolean entry;
	 * 
	 * @Transient private boolean exit;
	 */

	public long getParkingId() {
		return parkingId;
	}

	public ParkingSlot() {
	}

	public ParkingSlot(String name, Car car) {
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParkingId(long parkingId) {
		this.parkingId = parkingId;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	/*
	 * public boolean isEntry() { return entry; }
	 * 
	 * public void setEntry(boolean entry) { this.entry = entry; }
	 * 
	 * public boolean isExit() { return exit; }
	 * 
	 * public void setExit(boolean exit) { this.exit = exit; }
	 */
	@Override
	public String toString() {
		return "ParkingSlot [parkingId=" + parkingId + ", name=" + name + ", car=" + car + ", entry=" + null + ", exit="
				+ null + "]";
	}

}
