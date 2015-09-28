package com.stefanmuenchow.arithmetic.operation;

import java.math.BigInteger;

import com.stefanmuenchow.arithmetic.Operations;

public class BigIntegerOperations implements Operations<BigInteger> {

	@Override
	public BigInteger add(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	@Override
	public BigInteger sub(BigInteger a, BigInteger b) {
		return a.subtract(b);
	}

	@Override
	public BigInteger mul(BigInteger a, BigInteger b) {
		return a.multiply(b);
	}

	@Override
	public BigInteger div(BigInteger a, BigInteger b) {
		return a.divide(b);
	}

	@Override
	public BigInteger rem(BigInteger a, BigInteger b) {
		return a.remainder(b);
	}
	
	@Override
	public BigInteger max(BigInteger a, BigInteger b) {
		return a.max(b);
	}

	@Override
	public BigInteger min(BigInteger a, BigInteger b) {
		return a.min(b);
	}

	@Override
	public BigInteger abs(BigInteger a) {
		return a.abs();
	}

	@Override
	public BigInteger neg(BigInteger a) {
		return a.negate();
	}

	@Override
	public BigInteger shiftLeft(BigInteger a, BigInteger b) {
		return a.shiftLeft(b.intValueExact());
	}

	@Override
	public BigInteger shiftRight(BigInteger a, BigInteger b) {
		return a.shiftRight(b.intValueExact());
	}

	@Override
	public BigInteger shiftUnsignedRight(BigInteger a, BigInteger b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The >>> operator is undefined for " + BigInteger.class.getSimpleName() + "s");
	}
	
	@Override
	public BigInteger and(BigInteger a, BigInteger b) {
		return a.and(b);
	}

	@Override
	public BigInteger or(BigInteger a, BigInteger b) {
		return a.or(b);
	}

	@Override
	public BigInteger xor(BigInteger a, BigInteger b) {
		return a.xor(b);
	}

	@Override
	public BigInteger complement(BigInteger a) {
		return a.not();
	}

	@Override
	public int compare(BigInteger a, BigInteger b)
	{
		return a.compareTo(b);
	}

}
