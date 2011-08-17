package com.stefanmuenchow.arithmetic.converter;

import java.math.BigDecimal;

public class BigDecimalConverter implements TypeConverter<BigDecimal> {

	@Override
	public BigDecimal convertNumber(Number n) {
		return new BigDecimal(n.doubleValue());
	}
}
