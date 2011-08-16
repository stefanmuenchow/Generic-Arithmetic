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

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class ArithmeticTest {
	private Number[] numbers;
	private Arithmetic<Short> shortArith;
	private Arithmetic<Byte> byteArith;
	private Arithmetic<Integer> intArith;
	private Arithmetic<Long> longArith;
	private Arithmetic<Float> floatArith;
	private Arithmetic<Double> doubleArith;
	private Arithmetic<BigInteger> bigIntArith;
	private Arithmetic<BigDecimal> bigDecimalArith;
	
	@Before
	public void setUp() {
		numbers = new Number[] { (short) 3, (byte) -5, 7, -9l, 11f, -13d, new BigInteger("15"), new BigDecimal(-17d) };
		
		shortArith = Arithmetic.create(Short.class);
		byteArith = Arithmetic.create(Byte.class);
		intArith = Arithmetic.create(Integer.class);
		longArith = Arithmetic.create(Long.class);
		floatArith = Arithmetic.create(Float.class);
		doubleArith = Arithmetic.create(Double.class);
		bigIntArith = Arithmetic.create(BigInteger.class);
		bigDecimalArith = Arithmetic.create(BigDecimal.class);
	}

	@Test
	public void testAdd() {
		for(Number a : numbers) {
			for(Number b : numbers) {
				assertEquals(Short.valueOf((short) (a.shortValue() + b.shortValue())), shortArith.add(a, b));
				assertEquals(Byte.valueOf((byte) (a.byteValue() + b.byteValue())), byteArith.add(a, b));
				assertEquals(Integer.valueOf((int) (a.intValue() + b.intValue())), intArith.add(a, b));
				assertEquals(Long.valueOf((long) (a.longValue() + b.longValue())), longArith.add(a, b));
				assertEquals(Float.valueOf((float) (a.floatValue() + b.floatValue())), floatArith.add(a, b));
				assertEquals(Double.valueOf((double) (a.doubleValue() + b.doubleValue())), doubleArith.add(a, b));
				assertEquals(new BigInteger(Integer.valueOf(a.intValue() + b.intValue()).toString()), bigIntArith.add(a, b));
				assertEquals(new BigDecimal(Double.valueOf(a.doubleValue() + b.doubleValue())), bigDecimalArith.add(a, b));
			}
		}
	}

	@Test
	public void testAbs() {
		for(Number a : numbers) {
			assertEquals(Short.valueOf(Integer.valueOf(Math.abs(a.intValue())).shortValue()), shortArith.abs(a));
			assertEquals(Byte.valueOf(Integer.valueOf(Math.abs(a.intValue())).byteValue()), byteArith.abs(a));
			assertEquals(Integer.valueOf(Math.abs(a.intValue())), intArith.abs(a));
			assertEquals(Long.valueOf(Math.abs(a.longValue())), longArith.abs(a));
			assertEquals(Float.valueOf(Math.abs(a.floatValue())), floatArith.abs(a));
			assertEquals(Double.valueOf(Math.abs(a.doubleValue())), doubleArith.abs(a));
			assertEquals(new BigInteger(Long.valueOf(a.longValue()).toString()).abs(), bigIntArith.abs(a));
			assertEquals(new BigDecimal(a.doubleValue()).abs(), bigDecimalArith.abs(a));
		}
	}
}
