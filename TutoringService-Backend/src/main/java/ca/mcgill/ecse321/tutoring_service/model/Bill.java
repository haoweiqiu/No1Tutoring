package ca.mcgill.ecse321.tutoring_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Bill {
	private Registration registration;

	@OneToOne(mappedBy = "bill", optional = true)
	public Registration getRegistration() {
		return this.registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	private Boolean isPayed;

	public void setIsPayed(Boolean value) {
		this.isPayed = value;
	}

	public Boolean getIsPayed() {
		return this.isPayed;
	}

	private double amount;

	public void setAmount(double value) {
		this.amount = value;
	}

	public double getAmount() {
		return this.amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

}
