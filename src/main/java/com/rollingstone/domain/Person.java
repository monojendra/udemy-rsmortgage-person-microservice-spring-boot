package com.rollingstone.domain;

import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
* a simple domain entity doubling as a DTO
*/
@Entity
@Table(name = "rsmortgage_person")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

/*
 * TODO This is a sample JPA Pojo and we need to add / change field / column names / setter / getter 
 * constructors hashCode and equals methods here
 */
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name", unique=false, nullable = false)
	private String firstName;
	
	@Column(name="last_name", unique=false, nullable = false)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dob", unique = false, nullable = false, length = 10)
	private Date dob;
	
	@Column(nullable = false)
	private int age;
	
	@Column(name="social_security_number", unique=false, nullable = false)
	private int socialSecurityNumber;
	
	
	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(int social_security_number) {
		this.socialSecurityNumber = social_security_number;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String taskName) {
		this.firstName = taskName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String taskDescription) {
		this.lastName = taskDescription;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dateOfTask) {
		this.dob = dateOfTask;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Person(long id, String taskName, String taskDescription, Date dateOfTask, int age, int social_security_number) {
		super();
		this.id = id;
		this.firstName = taskName;
		this.lastName = taskDescription;
		this.dob = dateOfTask;
		this.age = age;
		this.socialSecurityNumber= social_security_number;
	}


	public Person() {
		super();
	}


	@Override
	public String toString(){
		
		return new String("id:"+id+",age:"+age+",firstName:"+firstName);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}
	
}
