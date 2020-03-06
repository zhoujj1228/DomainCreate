package design.DomainCreate.example;

import java.sql.Date;

import design.DomainCreate.domain.AutoIncrement;
import design.DomainCreate.domain.Length;
import design.DomainCreate.domain.NotNull;
import design.DomainCreate.domain.PrimaryKey;

public class TestDomain {
	@NotNull
	@AutoIncrement
	@PrimaryKey
	private int id;
	
	@Length("100")
	private String name;
	
	@NotNull
	int age;
	
	Date birthday;
	
	byte[] data;
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
