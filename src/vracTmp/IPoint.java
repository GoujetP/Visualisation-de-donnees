package vracTmp;

/**
 * Décrit un Point (ou donnée, ou ligne) dans un DataSet.
 */
public interface IPoint {
	/**
	 * Retourne la valeur de ce point pour la colonne en paramètre.
	 *
	 * Note, on aurait pu utiliser une interface générique (paramètre avec
	 * un type), mais cela complique significativement d'autres parties
	 * du code.
	 */
	public Object getValue(IColumn col);
	/**
	 * Retourne la valeur de ce point normalisée pour la colonne en paramètre.
	 *import interfaces.IValueNormalizer;
	 * La normalisation se fait avec le <i>normaliseur</i> de la colonne.
	 * Si la colonne n'est pas normalisable, le comportement n'est pas défini.
	 */
	public double getNormalizedValue(IColumn xcol);
}