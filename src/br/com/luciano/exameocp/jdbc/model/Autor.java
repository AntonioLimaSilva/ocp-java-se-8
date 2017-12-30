package br.com.luciano.exameocp.jdbc.model;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Autor {

	private Long id;
	private String firstName;
	private String lastName;
	
	public Autor() {
	}

	public Autor(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[ id = " + id + "] [ first name = " + firstName + "] [ last name = " + lastName + " ]";
	}
}
