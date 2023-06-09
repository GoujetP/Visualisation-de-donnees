package model;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.Subject;

public class DataSet extends Subject implements IDataset  {
	private String title;
	private List<IPoint> datas;
	private List<Column> columns;
	
	public DataSet(String title, List<IPoint> datas) {
		super();
		this.title = title;
		this.datas = datas;
		this.columns = listColumns();
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
	
	public List<Column> listColumns(){
		
		Field[] fields = this.datas.get(0).getClass().getDeclaredFields();
		List<Column> res = new ArrayList<Column>();
		for (Field f : fields) {
			if (f.getType().getName().equals("double")||f.getType().getName().equals("int")){
				res.add(new NumericColumn(f.getName(),this));
			}
			else if (f.getType().getName().equals("java.lang.String") || (f.getType().getName().equals("char"))) {
				res.add(new StringColumn(f.getName(), this));
			}
			else if (f.getType().getName().equals("boolean")) {
				res.add(new BooleanColumn(f.getName(), this));
			}
			
		}
		return res;
	}

	
	public List<Column> getColumns() {
		return columns;
	}
	
	@Override
	public List<IPoint> getList() {
		return datas;
	}

}
