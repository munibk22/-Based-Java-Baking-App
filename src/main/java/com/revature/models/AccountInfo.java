package com.revature.models;

public class AccountInfo {
	private String sSecurity;
	private String address;
	private String password;

	public AccountInfo(String sSecurity, String address, String password) {
		super();
		this.sSecurity = sSecurity;
		this.address = address;
		this.password = password;
	}

	public AccountInfo() {
		super();
	}

	public String getsSecurity() {
		return sSecurity;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public void setsSecurity(String sSecurity) {
		this.sSecurity = sSecurity;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sSecurity == null) ? 0 : sSecurity.hashCode());
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
		AccountInfo other = (AccountInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sSecurity == null) {
			if (other.sSecurity != null)
				return false;
		} else if (!sSecurity.equals(other.sSecurity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountInfo [sSecurity=" + sSecurity + ", address=" + address + ", password=" + password + "]";
	}

}
