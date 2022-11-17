package model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class DataSet implements IDataset {
	private String title;
	private List<IPoint> datas;
	private List<Column> columns;
	
	public DataSet(String title, List<IPoint> datas, List<Column> columns) {
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

	
	public List<Column> getColumns() {
		return columns;
	}
	
	@Override
	public List<IPoint> getList() {
		return datas;
	}

	@Override
	public void charger(String fileName) {
		try {
			new CsvToBeanBuilder<Iris>(Files.newBufferedReader(Paths.get("data/" + fileName)))
			        .withSeparator(',')
			        .withType(Iris.class)
			        .build().parse();
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
