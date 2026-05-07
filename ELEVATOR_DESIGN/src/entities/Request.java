package entities;

import enumerations.Direction;
import enumerations.RequestType;

public class Request {
	private final int door;
	private final Direction direction;
	private final RequestType requestType;
	private final Long timestamp;
	
	public Request(int door, Direction direction, RequestType requestType) {
		super();
		this.door = door;
		this.direction = direction;
		this.requestType = requestType;
		this.timestamp = System.currentTimeMillis();
	}

	public int getDoor() {
		return door;
	}

	public Direction getDirection() {
		return direction;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public Long getTimestamp() {
		return timestamp;
	}
	
}
