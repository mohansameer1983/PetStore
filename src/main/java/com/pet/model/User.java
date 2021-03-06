
package com.pet.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated user ID")
	private Integer id;

	@ApiModelProperty(notes = "User Name")
	private String userName;

	@ApiModelProperty(notes = "First Name")
	private String firstName;

	@ApiModelProperty(notes = "Last Name")
	private String lastName;

	private String email;

	private String password;

	private String phone;

	private Integer userStatus;

	public User id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User userName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * Get userName
	 * @return userName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * @return firstName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public User lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * @return lastName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * @return email
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * @return password
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User phone(String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * Get phone
	 * @return phone
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User userStatus(Integer userStatus) {
		this.userStatus = userStatus;
		return this;
	}

	/**
	 * User Status
	 * @return userStatus
	 **/
	@ApiModelProperty(example = "null", value = "User Status")
	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.id, user.id) &&
				Objects.equals(this.userName, user.userName) &&
				Objects.equals(this.firstName, user.firstName) &&
				Objects.equals(this.lastName, user.lastName) &&
				Objects.equals(this.email, user.email) &&
				Objects.equals(this.password, user.password) &&
				Objects.equals(this.phone, user.phone) &&
				Objects.equals(this.userStatus, user.userStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userName, firstName, lastName, email, password, phone, userStatus);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
		sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}

