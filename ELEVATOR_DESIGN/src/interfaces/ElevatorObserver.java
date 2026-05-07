package interfaces;

import enumerations.Direction;

public interface ElevatorObserver {
	void onElevatorChanged(int elevatorId,int floor,Direction direction);
}
