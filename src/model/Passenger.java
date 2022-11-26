package model;

import com.opencsv.bean.CsvBindByName;

public class Passenger implements IPoint{

	@CsvBindByName(column = "PassengerId")
	private int passengerId;
	@CsvBindByName(column = "Survived")
	private int survived;
	@CsvBindByName(column = "Pclass")
	private int pClass;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Sex")
	private String sex;
	@CsvBindByName(column = "Age")
	private int age;
	@CsvBindByName(column = "SibSp")
	private int sibSp;
	@CsvBindByName(column = "Parch")
	private int parch;
	@CsvBindByName(column = "Ticket")
	private String ticket;
	@CsvBindByName(column = "Fare")
	private double fare;
	@CsvBindByName(column = "Cabin")
	private String cabin;
	@CsvBindByName(column = "Embarked")
	private char embarked;


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
		return "Passenger [Name=" + name + ", Embarked=" + embarked + "]";
	}

	@Override
	public Object getValue(String line) {
		switch (line) {
		case "PassengerId" : 
			return passengerId;
		case "Survived" : 
			return survived;
		case "Pclass" : 
			return pClass;
		case "Name" :
			return name;
		case "Sex" : 
			return sex;
		case "Age" : 
			return age;
		case "SibSp" : 
			return sibSp;
		case "Parch" : 
			return parch;
		case "Ticket" :
			return ticket;
		case "Fare" : 
			return fare;
		case "Cabin" : 
			return cabin;
		case "Embarked" : 
			return embarked;
		}
		return null;
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}


	//--------------------------------------- Test Mohamed --------------------------------------//

}
