package entities;

import enumerations.DoorState;

public class Door {
	private DoorState doorState;
	
	public Door() {
		this.doorState = DoorState.CLOSED;
	}
	
	public synchronized void open() {
		this.doorState = DoorState.OPEN;
	}
	
	public synchronized void close() {
		this.doorState = DoorState.CLOSED;
	}
	
	public synchronized boolean isOpen() {
		return this.doorState == DoorState.OPEN;
	}
	
	public synchronized DoorState getDoorState() {
		return this.doorState;
	}
}

