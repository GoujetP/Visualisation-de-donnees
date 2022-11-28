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
		return "Passenger [Name=" + name + ", Embarked=" + embarked + "]";
	}

	@Override
	public Object getValue(String line) {
		switch (line) {
		case "passengerId" : 
			System.out.println("la");
			return passengerId;
		case "survived" : 
			System.out.println("la");
			return survived;
		case "pClass" : 
			System.out.println("la");
			return pClass;
		case "name" :
			System.out.println("la");
			return name;
		case "sex" : 
			System.out.println("la");
			return sex;
		case "age" : 
			System.out.println("la");
			return age;
		case "sibSp" : 
			System.out.println("la");
			return sibSp;
		case "parch" : 
			System.out.println("la");
			return parch;
		case "ticket" :
			System.out.println("la");
			return ticket;
		case "fare" : 
			System.out.println("la");
			return fare;
		case "cabin" : 
			System.out.println("la");
			return cabin;
		case "embarked" : 
			System.out.println("la");
			return embarked;
		default : 
			System.out.println(this.passengerId + " : " + line);
			return null;
		}
		
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}


	//--------------------------------------- Test Mohamed --------------------------------------//

}
