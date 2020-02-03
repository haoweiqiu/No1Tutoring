package ca.mcgill.ecse321.tutoring_service.dto;

public class BillDto {

	private RegistrationDto registrationDto;
	private double amount;
	private Boolean isPayed;

	public BillDto() {

	}

	/**
	 * Constructor of th bill dto
	 * 
	 * @param amount
	 */
	public BillDto(double amount) {
		this.amount = amount;
		this.isPayed = false;
	}

	/**
	 * Constructor of th bill dto
	 * 
	 * @param amount
	 * @param registrationDto
	 */
	public BillDto(double amount, RegistrationDto registrationDto) {
		this.amount = amount;
		this.registrationDto = registrationDto;
		this.isPayed = false;
	}

	/**
	 * Getter of the registration dto
	 * 
	 * @return
	 */
	public RegistrationDto getRegistrationDto() {
		return registrationDto;
	}

	/**
	 * Getter of the amount.
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Getter of the get is payed
	 * 
	 * @return
	 */
	public Boolean getIsPayed() {
		return isPayed;
	}

}
