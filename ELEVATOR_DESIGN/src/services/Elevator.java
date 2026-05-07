package services;

import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import entities.Door;
import enumerations.Direction;
import enumerations.ElevatorState;
import exceptions.ElevatorException;
import interfaces.ElevatorObserver;
import observers.Display;

public class Elevator {

	private final int id;
	private int currentFloor;
	private Direction direction;
	private ElevatorState state;
	private final Door door;
	private final Display display;
	private final TreeSet<Integer> upRequests;
	private final TreeSet<Integer> downRequests;
	private final CopyOnWriteArrayList<ElevatorObserver> observers;
	private final int totalFloors;
	
	public Elevator(int id,int totalFloors) {
		this.id = id;
		this.currentFloor=1;
		this.direction =Direction.IDLE;
		this.state = ElevatorState.IDLE;
		this.door=new Door();
		this.display=new Display(id);
		this.upRequests = new TreeSet<Integer>();
		this.downRequests = new TreeSet<Integer>(Collections.reverseOrder());
		this.observers = new CopyOnWriteArrayList<ElevatorObserver>();
		this.totalFloors = totalFloors;
		addObserver(display);
	}
	
	public synchronized void addRequest(int floorId, Direction direction) {
		if(state == ElevatorState.OUT_OF_DERVICE) {
			throw new ElevatorException("elevator " +id +" is out of service");
		}
		if(floorId<1 ||floorId>totalFloors) {
			throw new ElevatorException("Invalid floor number");
		}
		if(direction == Direction.UP || floorId>currentFloor) {
			upRequests.add(floorId);
		}else {
			downRequests.add(floorId);
		}
		
		System.out.println("Elevator " + id + " received a request to go to "+ floorId +" floor");
	}
	
	
	
	
}
