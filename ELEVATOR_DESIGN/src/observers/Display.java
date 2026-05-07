package observers;

import enumerations.Direction;
import interfaces.ElevatorObserver;

public class Display implements ElevatorObserver{
	
	private final int elevatorId;
	private int floor;
	private Direction direction;
	
	public Display(int elevatorId) {
		this.elevatorId = elevatorId;
		this.floor = 1;
		this.direction = Direction.IDLE;
	}

	@Override
	public void onElevatorChanged(int elevatorId, int floor, Direction direction) {
		// TODO Auto-generated method stub
		if(this.elevatorId == elevatorId) {
			this.floor = floor;
			this.direction = direction;
			show();
		}
	}
	
	public void show() {
		System.out.println("Display|| Elevator " + elevatorId + " at floor " + floor + " direction " + direction.name());
	}
	
	public int getElevatorId() {
		return this.elevatorId;
	}

}
