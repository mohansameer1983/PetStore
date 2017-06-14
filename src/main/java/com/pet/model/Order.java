package com.pet.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * Order
 */
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated order ID")
	private Integer id;

	@ApiModelProperty(notes = "The pet ID")
	private Integer petId;

	@ApiModelProperty(notes = "Number of pets")
	private Integer quantity;

	@ApiModelProperty(notes = "Shipping date")
	private DateTime shipDate;

	/**
	 * Order Status
	 */
	public enum StatusEnum {
		PLACED("placed"),
		APPROVED("approved"),
		DELIVERED("delivered");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@ApiModelProperty(notes = "Order Status")
	private StatusEnum status;

	@ApiModelProperty(notes = "Order Complete or not")
	private Boolean complete;

	public Order id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order petId(Integer petId) {
		this.petId = petId;
		return this;
	}

	/**
	 * Get petId
	 * @return petId
	 **/
	@ApiModelProperty(example = "0", value = "ID for pet")
	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Order quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Get quantity
	 * @return quantity
	 **/
	@ApiModelProperty(example = "1", value = "Pet Quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order shipDate(DateTime shipDate) {
		this.shipDate = shipDate;
		return this;
	}

	/**
	 * Get shipDate
	 * @return shipDate
	 **/
	@ApiModelProperty(example = "2017-06-13T03:10:54.815Z", value = "Shipping Date for Order")
	public DateTime getShipDate() {
		return shipDate;
	}

	public void setShipDate(DateTime shipDate) {
		this.shipDate = shipDate;
	}

	public Order status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Order Status
	 * @return status
	 **/
	@ApiModelProperty(example = "placed", value = "Order Status")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Order complete(Boolean complete) {
		this.complete = complete;
		return this;
	}

	/**
	 * Get complete
	 * @return complete
	 **/
	@ApiModelProperty(example = "false", value = "Order complete or not")
	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(this.id, order.id) &&
				Objects.equals(this.petId, order.petId) &&
				Objects.equals(this.quantity, order.quantity) &&
				Objects.equals(this.shipDate, order.shipDate) &&
				Objects.equals(this.status, order.status) &&
				Objects.equals(this.complete, order.complete);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, petId, quantity, shipDate, status, complete);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    petId: ").append(toIndentedString(petId)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    shipDate: ").append(toIndentedString(shipDate)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
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

