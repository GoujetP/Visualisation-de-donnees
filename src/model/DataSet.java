package model;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.graalvm.compiler.code.DataSection.Data;

import com.opencsv.bean.CsvToBeanBuilder;

import pokemon.Pokemon;

public class DataSet implements IDataset {
	private String title;
	private List<IPoint> datas;
	private List<IColumn> columns;
	
	public DataSet(String title, List<IPoint> datas, List<IColumn> columns) {
		super();
		this.title = title;
		this.datas = datas;
		this.columns = columns;
	}

	@Override
	public Iterator<IPoint> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return this.datas.size();
	}

	@Override
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub
		this.datas=lines;
	}

	@Override
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub
		this.datas.add(element);
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		for (IPoint p : element) {
			this.datas.add(p);
		}
		
	}

<<<<<<< HEAD
	public void chargerReader(Reader reader,  Class<IPoint> d) {
		this.datas = new CsvToBeanBuilder<IPoint>(reader)
		        .withSeparator(',')
		        .withType(d)
		        .build().parse();
	}
	
	@Override
	public void charger(String fileName, Class<IPoint> d) {
		
		try {
			chargerReader(Files.newBufferedReader(Paths.get("data/" + fileName)), d);
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
=======

	public List<IColumn> getColumns() {
		return columns;
	}
	
	
	
	

	@Override
	public List<IPoint> getList() {
		return datas;
	}

>>>>>>> 530180ad12a0b3f146cd49a368a0e94170a19380
}
