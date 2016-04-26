package com.mycompany;

import java.io.Serializable;

/**
 * @author testuser
 * This is DTO class. It will be used for carrying one row of Contact Table
 */
public class Contact implements Serializable{
	Integer contactId;
	//Using JSR303 bean validation
	String firstName;
	String lastName;
	String email;
	public Contact(){
		
	}
	public Contact(Integer id, String firstName, String lastName, String email) {
		contactId = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @return Returns the contactId.
	 */
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId The contactId to set.
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer contactStr = new StringBuffer();
		contactStr.append("[ContactId="+contactId);
		contactStr.append(", First Name="+firstName);
		contactStr.append(", Last Name="+lastName +"]");
		return contactStr.toString();
	}
}
