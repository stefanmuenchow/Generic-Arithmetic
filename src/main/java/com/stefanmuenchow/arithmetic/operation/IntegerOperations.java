package com.stefanmuenchow.arithmetic.operation;

public class IntegerOperations implements Operations<Integer> {

	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer sub(Integer a, Integer b) {
		return a - b;
	}

	@Override
	public Integer mul(Integer a, Integer b) {
		return a * b;
	}

	@Override
	public Integer div(Integer a, Integer b) {
		return a / b;
	}

	@Override
	public Integer max(Integer a, Integer b) {
		return Math.max(a, b);
	}

	@Override
	public Integer min(Integer a, Integer b) {
		return Math.min(a, b);
	}

	@Override
	public Integer abs(Integer a) {
		return Math.abs(a);
	}

	@Override
	public Integer neg(Integer a) {
		return a * (-1);
	}
}
