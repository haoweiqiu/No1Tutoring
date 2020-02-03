package ca.mcgill.ecse321.tutoring_service.dto;

public class SchoolDto {
	private String name;
	private String ad;

	public SchoolDto() {

	}

	/**
	 * Constructor of the school dto
	 * 
	 * @param name
	 */
	public SchoolDto(String name) {
		this.name = name;
		this.ad = null;

	}

	/**
	 * getter of the name
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter of the address
	 * 
	 * @return
	 */
	public String getAd() {
		return this.ad;
	}

}
