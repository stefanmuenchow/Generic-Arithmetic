/**
 * Copyright (c) Stefan Münchow. All rights reserved.
 * 
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.arithmetic;

import java.math.BigInteger;

/**
 * Provides operations for a specified numerical data type.
 * 
 * @author Stefan Münchow
 * @author Matthias Stevens
 * @param <X>	Operand and result type
 */
public interface Operations<X extends Number & Comparable<X>> {
	
	/**
	 * Add b to a.
	 * 
	 * @param a a
	 * @param b b
	 * @return 	result
	 */
	X add(X a, X b);
	
	/**
	 * Subtract b from a.
	 * 
	 * @param a	a
	 * @param b b
	 * @return 	result
	 */
	X sub(X a, X b);
	
	/**
	 * Multiplies a with b.
	 * 
	 * @param a a
	 * @param b b
	 * @return	result
	 */
	X mul(X a, X b);
	
	/**
	 * Divides a by b.
	 * 
	 * @param a a
	 * @param b b
	 * @return	result
	 */
	X div(X a, X b);
	
	/**
	 * Returns the the remainder of integer division of a by b (i.e. the result of {@code a % b}).
	 * 
	 * @param a a
	 * @param b b
	 * @return	result
	 */
	X rem(X a, X b);
	
	/**
	 * Returns the maximum value of a and b.
	 * 
	 * @param a a
	 * @param b b
	 * @return 	a if greater than or equal to b, otherwise b
	 */
	X max(X a, X b);
	
	/**
	 * Returns the minimum value of a and b.
	 * 
	 * @param a a
	 * @param b b
	 * @return 	a if smaller than or equal to b, otherwise b
	 */
	X min(X a, X b);
	
	/**
	 * Returns the absolute of a.
	 * 
	 * @param a	a
	 * @return	Absolute value
	 */
	X abs(X a);
	
	/**
	 * Changes the sign of a.
	 * 
	 * @param a a
	 * @return	-a
	 */
	X neg(X a);
	
	/**
	 * Bitwise left shift (<<).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X shiftLeft(X a, X b);
	
	/**
	 * Bitwise right shift (>>).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X shiftRight(X a, X b);
	
	/**
	 * Bitwise unsigned right shift (>>>).<br/>
	 * Only supported for integer types, except {@link BigInteger}.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X shiftUnsignedRight(X a, X b);
	
	/**
	 * Bitwise AND (&).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X and(X a, X b);
	
	/**
	 * Bitwise inclusive OR (|).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X or(X a, X b);
	
	/**
	 * Bitwise exclusive OR (^).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	X xor(X a, X b);
	
	/**
	 * Unary bitwise complement (~).<br/>
	 * Only supported for integer types.
	 * 
	 * @param a
	 * @return
	 */
	X complement(X a);
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	int compare(X a, X b);
	
}
