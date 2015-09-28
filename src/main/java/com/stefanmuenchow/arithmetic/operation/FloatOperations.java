package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

public class FloatOperations implements Operations<Float> {

	@Override
	public Float add(Float a, Float b) {
		return a + b;
	}

	@Override
	public Float sub(Float a, Float b) {
		return a - b;
	}

	@Override
	public Float mul(Float a, Float b) {
		return a * b;
	}

	@Override
	public Float div(Float a, Float b) {
		return a / b;
	}

	@Override
	public Float rem(Float a, Float b) {
		return a % b;
	}
	
	@Override
	public Float max(Float a, Float b) {
		return Math.max(a, b);
	}

	@Override
	public Float min(Float a, Float b) {
		return Math.min(a, b);
	}

	@Override
	public Float abs(Float a) {
		return Math.abs(a);
	}

	@Override
	public Float neg(Float a) {
		return a * (-1);
	}

	@Override
	public int compare(Float a, Float b)
	{
		return a.compareTo(b);
	}

}
