package sysc4806.pm4y.models;

public enum UserType {
	PROFESSOR("professor"),
	STUDENT("student"),
	COORDINATOR("coordinator")
	;
	private String value;
	public static final String MODEL_NAME = "userType";
	UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static UserType fromValue(String value) throws IllegalArgumentException {
		if(value.equals(null)) {
			throw new IllegalArgumentException("Cannot determine UserType from Null value");
		}
		if(value.isEmpty()) {
			throw new IllegalArgumentException("Cannot determine UserType from empty value");
		}
		for (UserType userType : values()) {
			if(userType.value.equals(value)) {
				return userType;
			}
		}
		throw new IllegalArgumentException("There is no UserType corresponding to the value " + String.valueOf(value));
	}
}
