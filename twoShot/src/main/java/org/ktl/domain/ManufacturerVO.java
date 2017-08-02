package org.ktl.domain;

public class ManufacturerVO {

	private String manufacturerid;
	private String manufacturername;
	private String manufacturephone;
	private String manufactureaddress;
	public String getManufacturerid() {
		return manufacturerid;
	}
	public void setManufacturerid(String manufacturerid) {
		this.manufacturerid = manufacturerid;
	}
	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}
	public String getManufacturephone() {
		return manufacturephone;
	}
	public void setManufacturephone(String manufacturephone) {
		this.manufacturephone = manufacturephone;
	}
	public String getManufactureaddress() {
		return manufactureaddress;
	}
	public void setManufactureaddress(String manufactureaddress) {
		this.manufactureaddress = manufactureaddress;
	}
	@Override
	public String toString() {
		return "manufacturerVO [manufacturerid=" + manufacturerid + ", manufacturername=" + manufacturername
				+ ", manufacturephone=" + manufacturephone + ", manufactureaddress=" + manufactureaddress + "]";
	}

	
	
}
