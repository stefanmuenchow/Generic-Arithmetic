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

import org.junit.Test;

public class ArithmeticTest {
	private final Number[] numbers = 
		new Number[] { (short) 3, (byte) -5, 7, -9l, 11f, -13d, new BigInteger("15"), new BigDecimal(-17d) };
	
	@Test
	public void testShortArithmetic() {
		Arithmetic<Short> shortArith = new Arithmetic<Short>(numbers[0].shortValue());
		
		for(Number a : numbers) {
			assertEquals(Short.valueOf((short) (shortArith.value() + a.shortValue())), shortArith.add(a).value());
		}
	}
	
	@Test
	public void testByteArithmetic() {
		Arithmetic<Byte> byteArith = new Arithmetic<Byte>(numbers[1].byteValue());
		
		for(Number a : numbers) {
			assertEquals(Byte.valueOf((byte) (byteArith.value() + a.byteValue())), byteArith.add(a).value());
		}
	}
	
	@Test
	public void testIntArithmetic() {
		Arithmetic<Integer> intArith = new Arithmetic<Integer>(numbers[2].intValue());
		
		for(Number a : numbers) {
			assertEquals(Integer.valueOf(intArith.value() + a.intValue()), intArith.add(a).value());
		}
	}
	
	@Test
	public void testLongArithmetic() {
		Arithmetic<Long> longArith = new Arithmetic<Long>(numbers[3].longValue());
		
		for(Number a : numbers) {
			assertEquals(Long.valueOf(longArith.value() + a.longValue()), longArith.add(a).value());
		}
	}
	
	@Test
	public void testFloatArithmetic() {
		Arithmetic<Float> floatArith = new Arithmetic<Float>(numbers[4].floatValue());
		
		for(Number a : numbers) {
			assertEquals(Float.valueOf(floatArith.value() + a.floatValue()), floatArith.add(a).value());
		}
	}
	
	@Test
	public void testDoubleArithmetic() {
		Arithmetic<Double> doubleArith = new Arithmetic<Double>(numbers[5].doubleValue());
		
		for(Number a : numbers) {
			assertEquals(Double.valueOf(doubleArith.value() + a.doubleValue()), doubleArith.add(a).value());
		}
	}
	
	@Test
	public void testBigIntArithmetic() {
		Arithmetic<BigInteger> bigIntArith = new Arithmetic<BigInteger>((BigInteger) numbers[6]);
		
		for(Number a : numbers) {
			assertEquals(new BigInteger(Long.valueOf(bigIntArith.value().longValue() + a.longValue()).toString()), 
						 bigIntArith.add(a).value());
		}
	}
	
	@Test
	public void testBigDecimalArithmetic() {
		Arithmetic<BigDecimal> bigDecimalArith = new Arithmetic<BigDecimal>((BigDecimal) numbers[7]);
		
		for(Number a : numbers) {
			assertEquals(new BigDecimal(bigDecimalArith.value().doubleValue() + a.doubleValue()), 
						 bigDecimalArith.add(a).value());
		}
	}
	
	@Test
	public void testCalculateAverage() {
		Arithmetic<Double> doubleArithmetic = new Arithmetic<Double>(0d);
		
		for(Number a : numbers) {
			doubleArithmetic.add(a);
		}
		
		Double result = doubleArithmetic.div(numbers.length).value();
		
		assertEquals(Double.valueOf(-1), result);
	}
}
