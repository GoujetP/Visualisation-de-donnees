package model;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDesDonnees {
	
	// Class Attributes
	

	// Constructor

	// Methods
	
	public List<IPoint> chargerReader(Reader reader,  Class<? extends IPoint> d) {
		
		CsvToBean<IPoint> ctb = new CsvToBean<>();
		
		CsvToBeanBuilder<IPoint> ctbb = new CsvToBeanBuilder<IPoint>(reader);
	       ctb = ctbb.withSeparator(',')
	        .withType(d)
	        .build();
	       
	    ctb.setOrderedResults(true);
	    ctb.setThrowExceptions(false);
	    
	    return ctb.parse();
	}
	
//	public List<IPoint> chargerReader(Reader reader,  Class<? extends IPoint> d) {
//		
//		try {
//			CsvToBeanBuilder<IPoint> ctbb = new CsvToBeanBuilder<IPoint>(reader);
//		       ctb = ctbb.withSeparator(',')
//		        .withType(d)
//		        .build();
//		    ctb.setOrderedResults(true);
//		    ctb.setThrowExceptions(false);
//			return ctb.parse();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return new ArrayList<IPoint>();
//		}
//	}


	public List<IPoint> charger(String fileName, Class<? extends IPoint> d) {
		
		try {
			return chargerReader(Files.newBufferedReader(Paths.get("data" + System.getProperty("file.separator") + fileName)), d);
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}
