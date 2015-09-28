package com.stefanmuenchow.arithmetic.operation;

public class DoubleOperations extends FloatingPointOperations<Double> {

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

	@Override
	public int compare(Double a, Double b)
	{
		return a.compareTo(b);
	}

}
