
package com.pet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

/**
 * Pet
 */
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated pet ID")
	private Integer id;

	@ApiModelProperty(notes = "The pet category")
	@ManyToOne
	private Category category;

	@ApiModelProperty(notes = "The pet name")
	private String name;

	@ApiModelProperty(notes = "Pet Photo URLs")
	@ElementCollection
	private List<String> photoUrls = new ArrayList<String>();

	@ApiModelProperty(notes = "The pet tag")
	@OneToMany
	private List<Tag> tags = new ArrayList<Tag>();

	/**
	 * pet status in the store
	 */
	public enum StatusEnum {
		AVAILABLE("available"),
		PENDING("pending"),
		SOLD("sold");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@ApiModelProperty(notes = "pet status in the store")
	private StatusEnum status;

	public Pet id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(example = "1", value = "integer")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get category
	 * @return category
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Pet name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(example = "doggie", required = true, value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet photoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
		return this;
	}

	public Pet addPhotoUrlsItem(String photoUrlsItem) {
		this.photoUrls.add(photoUrlsItem);
		return this;
	}

	/**
	 * Get photoUrls
	 * @return photoUrls
	 **/
	@ApiModelProperty(example = "null", required = true, value = "")
	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Pet tags(List<Tag> tags) {
		this.tags = tags;
		return this;
	}

	public Pet addTagsItem(Tag tagsItem) {
		this.tags.add(tagsItem);
		return this;
	}

	/**
	 * Get tags
	 * @return tags
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Pet status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * pet status in the store
	 * @return status
	 **/
	@ApiModelProperty(example = "null", value = "pet status in the store")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Pet pet = (Pet) o;
		return Objects.equals(this.id, pet.id) &&
				Objects.equals(this.category, pet.category) &&
				Objects.equals(this.name, pet.name) &&
				Objects.equals(this.photoUrls, pet.photoUrls) &&
				Objects.equals(this.tags, pet.tags) &&
				Objects.equals(this.status, pet.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, category, name, photoUrls, tags, status);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Pet {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
		sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

