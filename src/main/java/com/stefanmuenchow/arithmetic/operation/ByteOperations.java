package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

public class ByteOperations implements Operations<Byte> {

	@Override
	public Byte add(Byte a, Byte b) {
		return (byte) (a + b);
	}

	@Override
	public Byte sub(Byte a, Byte b) {
		return (byte) (a - b);
	}

	@Override
	public Byte mul(Byte a, Byte b) {
		return (byte) (a * b);
	}

	@Override
	public Byte div(Byte a, Byte b) {
		return (byte) (a / b);
	}

	@Override
	public Byte rem(Byte a, Byte b) {
		return (byte) (a % b);
	}
	
	@Override
	public Byte max(Byte a, Byte b) {
		return (byte) Math.max(a, b);
	}

	@Override
	public Byte min(Byte a, Byte b) {
		return (byte) Math.min(a, b);
	}

	@Override
	public Byte abs(Byte a) {
		return (byte) Math.abs(a);
	}

	@Override
	public Byte neg(Byte a) {
		return (byte) (a * (-1));
	}

}
