package com.example.devtools.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Address", schema = "public")

public class address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;

	private String city;

	private String pin;

	private int book_id;
	/*
	 * @ManyToOne() private Book book;
	 */

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Override
	public String toString() {
		return "address [address_id=" + address_id + ", city=" + city + ", pin=" + pin + ", book_id=" + book_id + "]";
	}
	

}
