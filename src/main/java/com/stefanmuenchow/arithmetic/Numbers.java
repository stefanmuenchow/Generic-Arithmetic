/**
 * Copyright (c) Stefan Münchow & Matthias Stevens. All rights reserved.
 * 
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Provides arithmetic operations that can be applied to any combination of 1 or 2 instances of {@link Number} subclasses.
 * 
 * @author Matthias Stevens
 */
public class Numbers
{

	/**
	 * @param n a {@link Number} instance
	 * @return an {@link Arithmetic} instance, encapsulating the value of {@code a}, and with the type of {@code n} as the target type
	 */
	static public Arithmetic<? extends Number> getArithmetic(Number n)
	{
		return getArithmetic(n, null);
	}
	
	/**
	 * @param a a {@link Number} instance
	 * @param b a {@link Number} instance
	 * @return an {@link Arithmetic} instance, encapsulating the value of {@code a}, and with the most appropriate target type with respect to the types of {@code a} and {@code b}
	 */
	static public Arithmetic<? extends Number> getArithmetic(Number a, Number b)
	{
		if(a instanceof BigDecimal)
			return new Arithmetic<BigDecimal>((BigDecimal) a);
		if(b instanceof BigDecimal)
			return new Arithmetic<BigDecimal>(BigDecimal.valueOf(a.doubleValue())); 
		if(a instanceof Double)
			return new Arithmetic<Double>((Double) a);
		if(b instanceof Double)
			return new Arithmetic<Double>(Double.valueOf(a.doubleValue()));
		if(a instanceof Float)
			return new Arithmetic<Float>((Float) a);
		if(b instanceof Float)
			return new Arithmetic<Float>(Float.valueOf(a.floatValue()));
		if(a instanceof BigInteger)
			return new Arithmetic<BigInteger>((BigInteger) a);
		if(b instanceof BigInteger)
			return new Arithmetic<BigInteger>(BigInteger.valueOf(a.longValue()));
		if(a instanceof Long)
			return new Arithmetic<Long>((Long) a);
		if(b instanceof Long)
			return new Arithmetic<Long>(Long.valueOf(a.longValue()));
		if(a instanceof Integer)
			return new Arithmetic<Integer>((Integer) a);
		if(b instanceof Integer)
			return new Arithmetic<Integer>(Integer.valueOf(a.intValue()));
		if(a instanceof Short)
			return new Arithmetic<Short>((Short) a);
		if(b instanceof Short)
			return new Arithmetic<Short>(Short.valueOf(a.shortValue()));
		if(a instanceof Byte)
			return new Arithmetic<Byte>((Byte) a);
		if(b instanceof Byte)
			return new Arithmetic<Byte>(Byte.valueOf(a.byteValue()));
		else
			throw new IllegalArgumentException("Unsupported Number type" + (b != null ? "(s)" : "") + " [" + a.getClass().getName() + (b != null ? "; " + b.getClass().getName() : "") + "]");
	}
	
	/**
	 * @see Operations#add(Number, Number)
	 */
	static public Number add(Number a, Number b)
	{
		return getArithmetic(a, b).add(b).value();
	}

	/**
	 * @see Operations#sub(Number, Number)
	 */
	static public Number sub(Number a, Number b)
	{
		return getArithmetic(a, b).sub(b).value();
	}

	/**
	 * @see Operations#mul(Number, Number)
	 */
	static public Number mul(Number a, Number b)
	{
		return getArithmetic(a, b).mul(b).value();
	}

	/**
	 * @see Operations#div(Number, Number)
	 */
	static public Number div(Number a, Number b)
	{
		return getArithmetic(a, b).div(b).value();
	}

	/**
	 * @see Operations#rem(Number, Number)
	 */
	static public Number rem(Number a, Number b)
	{
		return getArithmetic(a, b).rem(b).value();
	}
	
	/**
	 * @see Operations#max(Number, Number)
	 */
	static public Number max(Number a, Number b)
	{
		return getArithmetic(a, b).max(b).value();
	}

	/**
	 * @see Operations#min(Number, Number)
	 */
	static public Number min(Number a, Number b)
	{
		return getArithmetic(a, b).min(b).value();
	}

	/**
	 * @see Operations#abs(Number)
	 */
	static public Number abs(Number n)
	{
		return getArithmetic(n).abs().value();
	}

	/**
	 * @see Operations#neg(Number)
	 */
	static public Number neg(Number n)
	{
		return getArithmetic(n).neg().value();
	}

	/**
	 * @see Operations#shiftLeft(Number, Number)
	 */
	static public Number shiftLeft(Number a, Number b)
	{
		return getArithmetic(a, b).shiftLeft(b).value();
	}

	/**
	 * @see Operations#shiftRight(Number, Number)
	 */
	static public Number shiftRight(Number a, Number b)
	{
		return getArithmetic(a, b).shiftRight(b).value();
	}

	/**
	 * @see Operations#shiftUnsignedRight(Number, Number)
	 */
	static public Number shiftUnsignedRight(Number a, Number b)
	{
		return getArithmetic(a, b).shiftUnsignedRight(b).value();
	}

	/**
	 * @see Operations#and(Number, Number)
	 */
	static public Number and(Number a, Number b)
	{
		return getArithmetic(a, b).and(b).value();
	}

	/**
	 * @see Operations#or(Number, Number)
	 */
	static public Number or(Number a, Number b)
	{
		return getArithmetic(a, b).or(b).value();
	}

	/**
	 * @see Operations#xor(Number, Number)
	 */
	static public Number xor(Number a, Number b)
	{
		return getArithmetic(a, b).xor(b).value();
	}

	/**
	 * @see Operations#complement(Number)
	 */
	static public Number complement(Number n)
	{
		return getArithmetic(n).complement().value();
	}

	/**
	 * @see Operations#compare(Number, Number)
	 */
	static public <N extends Number & Comparable<N>, M extends Number & Comparable<M>> int compare(N a, M b)
	{
		return getArithmetic(a, b).compareTo(b);
	}

}
