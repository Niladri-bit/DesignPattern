package entities;

import enumerations.CarType;

public class Car {
	private String carNo;
	private String carName;
	private CarType carType;
	private double pricePerDay;
	public Car(String carNo, String carName, CarType carType, double pricePerDay) {
		super();
		this.carNo = carNo;
		this.carName = carName;
		this.carType = carType;
		this.pricePerDay = pricePerDay;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
}
