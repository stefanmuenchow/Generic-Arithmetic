package com.stefanmuenchow.arithmetic.operation;

import java.math.BigDecimal;

import com.stefanmuenchow.arithmetic.Operations;

public class BigDecimalOperations implements Operations<BigDecimal> {

	@Override
	public BigDecimal add(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	@Override
	public BigDecimal sub(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

	@Override
	public BigDecimal mul(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

	@Override
	public BigDecimal div(BigDecimal a, BigDecimal b) {
		return a.divide(b);
	}

	@Override
	public BigDecimal max(BigDecimal a, BigDecimal b) {
		return a.max(b);
	}

	@Override
	public BigDecimal min(BigDecimal a, BigDecimal b) {
		return a.min(b);
	}

	@Override
	public BigDecimal abs(BigDecimal a) {
		return a.abs();
	}

	@Override
	public BigDecimal neg(BigDecimal a) {
		return a.negate();
	}
}
