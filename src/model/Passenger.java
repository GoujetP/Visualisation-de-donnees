package model;

import com.opencsv.bean.CsvBindByName;

public class Passenger implements IPoint{

	@CsvBindByName(column = "PassengerId")
	private double passengerId;
	@CsvBindByName(column = "Survived")
	private double survived;
	@CsvBindByName(column = "Pclass")
	private double pClass;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Sex")
	private String sex;
	@CsvBindByName(column = "Age")
	private double age;
	@CsvBindByName(column = "SibSp")
	private double sibSp;
	@CsvBindByName(column = "Parch")
	private double parch;
	@CsvBindByName(column = "Ticket")
	private String ticket;
	@CsvBindByName(column = "Fare")
	private double fare;
	@CsvBindByName(column = "Cabin")
	private String cabin;
	@CsvBindByName(column = "Embarked")
	private char embarked;

	public Passenger() {}
	public Passenger(int passengerId, int survived, int pclass, String name, String sex, int age, int sibSp, int parch,
			String ticket, double fare, String cabin, char embarked) {
		super();
		this.passengerId = passengerId;
		this.survived = survived;
		this.pClass = pclass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}


	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", survived=" + survived + ", pClass=" + pClass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}
	
	
	@Override
	public Object getValue(String line) {
		switch (line) {
		case "passengerId" : 			
			return passengerId;
		case "survived" : 
			return survived;
		case "pClass" : 
			return pClass;
		case "name" :
			return name;
		case "sex" : 
			return sex;
		case "age" : 
			return age;
		case "sibSp" : 
			return sibSp;
		case "parch" : 
			return parch;
		case "ticket" :
			return ticket;
		case "fare" : 
			return fare;
		case "cabin" : 
			return cabin;
		case "embarked" : 
			return embarked;
		default : 
			return null;
		}
		
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}

}
