package swagger.training.swaggerDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Person Info Model")
public class Person {

	/**
	 * first name
	 */
	@ApiModelProperty(value="Person first name")
	private String firstName;
	
	/**
	 * last name
	 */
	@ApiModelProperty(value="Person last name")
	private String lastName;
	
	/**
	 * age
	 */
	@ApiModelProperty(value="Person age", required = false)
	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}	
}
