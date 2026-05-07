package interfaces;

import java.util.List;

import enumerations.Direction;

public interface DispatchStrategy {
	Elevator selectElevator(List<Elevator> elevators,int floors,Direction direction);
}
