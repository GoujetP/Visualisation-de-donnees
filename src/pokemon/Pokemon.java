package pokemon;

import com.opencsv.bean.CsvBindByName;

import model.IColumn;
import model.IPoint;

public class Pokemon implements IPoint {
	
	// Class Attributes
	@CsvBindByName(column = "name")
	private String name;
	
	@CsvBindByName(column = "attack")
	private int attack;
	
	@CsvBindByName(column = "base_egg_steps")
	private int baseEggSteps;
	
	@CsvBindByName(column = "capture_rate")
	private double captureRate;
	

	@CsvBindByName(column = "defense")
	private int defense;
	
	@CsvBindByName(column = "experience_growth")
	private int experienceGrowth;
	
	@CsvBindByName(column = "hp")
	private int hp;
	
	@CsvBindByName(column = "sp_attack")
	private int spAttack;

	@CsvBindByName(column = "sp_defense")
	private int spDefense;
	
	@CsvBindByName(column = "type1")
	private Type type1;
	
	@CsvBindByName(column = "type2")
	private Type type2;
	
	@CsvBindByName(column = "speed")
	private double speed;
	
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;
	
	// Constructor
	public Pokemon() {}
	
	// Methods
	@Override
	public String toString() {
		return "name : " + this.name + "\nisLegendary : " + this.isLegendary; 
	}

	@Override
	public Object getValue(IColumn col) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		switch(col.getName()) {
		case "name" :
			return this.name;
		case "attack" :
			return this.attack;
		case "base_egg_steps" :
			return this.baseEggSteps;
		case "capture_rate" :
			return this.captureRate;
		case "defense" :
			return this.defense;
		case "experience_growth":
			return this.experienceGrowth;
		case "hp" :
			return this.hp;
		case "sp_attack" :
			return this.spAttack;
		case "sp_defense" :
			return this.spDefense;
		case "type1" :
			return this.type1;
		case "type2" :
			return this.type2;
		case "speed" :
			return this.speed;
		case "is_legendary" : 
			return this.isLegendary;
		default :
			return null;
		}
		
>>>>>>> d3a818df1f42420b5eb66778b9129eb06169ff01
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return 0;
=======
		return xcol.getNormalizedValue(this);
>>>>>>> d3a818df1f42420b5eb66778b9129eb06169ff01
	}
}
