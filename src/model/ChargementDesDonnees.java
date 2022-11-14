package model;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDesDonnees {
	
	// Class Attributes
	

	// Constructor

	// Methods
	
	public List<IPoint> chargerReader(Reader reader,  Class<? extends IPoint> d) {
		return new CsvToBeanBuilder<IPoint>(reader)
		        .withSeparator(',')
		        .withType(d)
		        .build().parse();
	}
	
	public void charger(String fileName, Class<IPoint> d) {
		
		try {
			chargerReader(Files.newBufferedReader(Paths.get("data/" + fileName)), d);
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
