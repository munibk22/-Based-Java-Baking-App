package com.revature.models;

public class Employee extends Character {

	private String department;
	private int id;

//Constructor
	public Employee(String firstName, String lastName, String password, int checkingBalance, boolean isRegistered,
			boolean isActive) {
		super(firstName, lastName, password, checkingBalance, isRegistered, isActive);

	}

	// No Args Constructor
	public Employee() {
		super();
	}

	// Getters n Setters
	public String getDepartment() {
		return department;
	}

	public int getId() {
		return id;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(int id) {
		this.id = id;
	}

	// HashCode & equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [department=" + department + ", id=" + id + ", getLastName()=" + getLastName()
				+ ", getFirstName()=" + getFirstName() + ", getLoggedIn()=" + getLoggedIn() + ", getPassWord()="
				+ getPassWord() + "]";
	}

}
