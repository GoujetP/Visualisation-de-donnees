package model;

public class Normalizer implements IValueNormalizer {


	@Override
	public Object denormalize(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double normalize(Object value,IColumn column) {
		// TODO Auto-generated method stub
		if (column.getType().equals(NormalizerTypes.BOOLEAN_NORMALIZER)){
			boolean b = (boolean) value;
			if (b) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else if (column.getType().equals(NormalizerTypes.NUMBER_NORMALIZER)){
			double v = (double) value;
			return (v-column.getMin())/(column.getMax()-column.getMin());
		}
		else {
			return (double) value;
		}
	}

	

	
	

}
