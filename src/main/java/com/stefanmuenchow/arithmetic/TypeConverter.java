package com.stefanmuenchow.arithmetic;

/**
 * Converts a {@link Number} to an object of the target class.
 * 
 * @author Stefan Münchow
 * @param <X>	Target class
 */
public interface TypeConverter<X extends Number> {
	
	/**
	 * Converts n to an object of type X.
	 * 
	 * @param n		{@link Number}
	 * @return		Object of type X
	 */
	X convertNumber(Number n);
}
