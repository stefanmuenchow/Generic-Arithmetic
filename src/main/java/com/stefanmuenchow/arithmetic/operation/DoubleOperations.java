package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

public class DoubleOperations implements Operations<Double> {

	@Override
	public Double add(Double a, Double b) {
		return a + b;
	}

	@Override
	public Double sub(Double a, Double b) {
		return a - b;
	}

	@Override
	public Double mul(Double a, Double b) {
		return a * b;
	}

	@Override
	public Double div(Double a, Double b) {
		return a / b;
	}

	@Override
	public Double rem(Double a, Double b) {
		return a % b;
	}
	
	@Override
	public Double max(Double a, Double b) {
		return Math.max(a, b);
	}

	@Override
	public Double min(Double a, Double b) {
		return Math.min(a, b);	
	}
	
	@Override
	public Double abs(Double a) {
		return Math.abs(a);
	}

	@Override
	public Double neg(Double a) {
		return a * (-1);
	}

}
