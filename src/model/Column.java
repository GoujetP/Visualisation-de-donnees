package model;

import model.IValueNormalizer.NormalizerTypes;

public class Column implements IColumn {
	private String nomCol;
	private IValueNormalizer valueNormalizer;
	private IDataset dataSet;
	private NormalizerTypes type;

	public Column(String nomCol, IValueNormalizer valueNormalizer, IDataset dataSet , NormalizerTypes type) {
		super();
		this.nomCol = nomCol;
		this.valueNormalizer = valueNormalizer;
		this.dataSet = dataSet;
		this.type = type;
	}

	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		this.valueNormalizer=valueNormalizer;
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		// TODO Auto-generated method stub
		return valueNormalizer.normalize(point);
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

}
