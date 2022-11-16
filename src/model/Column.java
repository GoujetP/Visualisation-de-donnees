package model;

import java.util.ArrayList;

import model.IValueNormalizer.NormalizerTypes;

public class Column implements IColumn {
	private String nomCol;
	private IValueNormalizer valueNormalizer;
	private IDataset dataSet;
	private NormalizerTypes type ;
	// Mohamed
	private ArrayList<Integer> list;

	public Column(String nomCol, IValueNormalizer valueNormalizer, IDataset dataSet , NormalizerTypes type) {
		super();
		this.nomCol = nomCol;
		this.valueNormalizer = valueNormalizer;
		this.dataSet = dataSet;
		this.type = type;
		// Mohamed
		for(IPoint point : dataSet.getList()) {
			list.add((int) point.getValue(nomCol));
		}
	}
	

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		this.valueNormalizer=valueNormalizer;
	}
	
	@Override
	public double getNormalizedValue(IPoint point) {
		// TODO Auto-generated method stub
		return valueNormalizer.normalize(point.getValue(getNomCol()),this);
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return valueNormalizer.denormalize(value);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nomCol;
	}

	@Override
	public IDataset getDataset() {
		// TODO Auto-generated method stub
		return dataSet;
	}

	@Override
	public boolean isNormalizable() {
		// TODO Auto-generated method stub
		return !this.type.equals(NormalizerTypes.NO_NORMALIZER);
	}

	// Mohamed
	public int getMax() {
		return list.stream().max(Integer::max).get();
	}
	
	public int getMin() {
		return list.stream().min(Integer::min).get();
	}


	public String getNomCol() {
		return nomCol;
	}


	public IValueNormalizer getValueNormalizer() {
		return valueNormalizer;
	}


	public IDataset getDataSet() {
		return dataSet;
	}


	public NormalizerTypes getType() {
		return type;
	}


	public ArrayList<Integer> getList() {
		return list;
	}
	
	
	
}
