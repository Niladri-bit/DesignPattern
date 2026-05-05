package entities;

public class User {
	private final String id;
	private final String name;
	private final String email;
	private final String phoneNumber;
	
	public User(String id,String name,String email,String phoneNumber) {
		if(id==null|| name==null) {
			throw new RuntimeException("userid / name can't be null");
		}
		this.id = id;
		this.email =email;
		this.name= name;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
}
