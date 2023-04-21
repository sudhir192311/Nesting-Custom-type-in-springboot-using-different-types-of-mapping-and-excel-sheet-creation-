package com.example.devtools.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book", schema = "public")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Status status;

	@OneToMany(cascade = CascadeType.ALL)
	private List<address> addressList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", status=" + status + ", addressList=" + addressList + "]";
	}

	public Book(int id, String name, Status status, List<address> addressList) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.addressList = addressList;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
