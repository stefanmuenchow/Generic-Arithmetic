package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

public class ShortOperations implements Operations<Short> {

	@Override
	public Short add(Short a, Short b) {
		return (short) (a + b);
	}

	@Override
	public Short sub(Short a, Short b) {
		return (short) (a - b);
	}

	@Override
	public Short mul(Short a, Short b) {
		return (short) (a * b);
	}

	@Override
	public Short div(Short a, Short b) {
		return (short) (a / b);
	}

	@Override
	public Short rem(Short a, Short b) {
		return (short) (a % b);
	}
	
	@Override
	public Short max(Short a, Short b) {
		return (short) Math.max(a, b);
	}

	@Override
	public Short min(Short a, Short b) {
		return (short) Math.min(a, b);
	}

	@Override
	public Short abs(Short a) {
		return (short) Math.abs(a);
	}

	@Override
	public Short neg(Short a) {
		return (short) (a * (-1));
	}

	@Override
	public Short shiftLeft(Short a, Short b)
	{
		return (short) (a << b);
	}

	@Override
	public Short shiftRight(Short a, Short b)
	{
		return (short) (a >> b);
	}

	@Override
	public Short shiftUnsignedRight(Short a, Short b)
	{
		return (short) (a >>> b);
	}

	@Override
	public Short and(Short a, Short b)
	{
		return (short) (a & b);
	}

	@Override
	public Short or(Short a, Short b)
	{
		return (short) (a | b);
	}

	@Override
	public Short xor(Short a, Short b)
	{
		return (short) (a ^ b);
	}

	@Override
	public Short complement(Short a)
	{
		return (short) (~a);
	}

	@Override
	public int compare(Short a, Short b)
	{
		return a.compareTo(b);
	}

}
