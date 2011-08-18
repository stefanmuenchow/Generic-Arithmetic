package com.stefanmuenchow.arithmetic.converter;

import java.math.BigDecimal;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class BigDecimalConverter implements TypeConverter<BigDecimal> {

	@Override
	public BigDecimal convertNumber(Number n) {
		return new BigDecimal(n.doubleValue());
	}
}
