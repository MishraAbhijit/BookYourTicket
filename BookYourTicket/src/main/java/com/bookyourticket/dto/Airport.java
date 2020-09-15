package com.bookyourticket.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

	@Id
	private String code;
	private String city;
	private String name;
	private String country;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airport [code=" + code + ", city=" + city + ", name=" + name + ", country=" + country + "]";
	}

}
