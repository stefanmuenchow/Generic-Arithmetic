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

	@Override
	public Byte shiftLeft(Byte a, Byte b) {
		return (byte) (a << b);
	}

	@Override
	public Byte shiftRight(Byte a, Byte b) {
		return (byte) (a >> b);
	}

	@Override
	public Byte shiftUnsignedRight(Byte a, Byte b) {
		return (byte) (a >>> b);
	}
	
	@Override
	public Byte and(Byte a, Byte b) {
		return (byte) (a & b);
	}

	@Override
	public Byte or(Byte a, Byte b) {
		return (byte) (a | b);
	}

	@Override
	public Byte xor(Byte a, Byte b) {
		return (byte) (a ^ b);
	}

	@Override
	public Byte complement(Byte a) {
		return (byte) (~a);
	}

	@Override
	public int compare(Byte a, Byte b)
	{
		return a.compareTo(b);
	}

}
