package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

public class LongOperations implements Operations<Long> {

	@Override
	public Long add(Long a, Long b) {
		return a + b;
	}

	@Override
	public Long sub(Long a, Long b) {
		return a - b;
	}

	@Override
	public Long mul(Long a, Long b) {
		return a * b;
	}

	@Override
	public Long div(Long a, Long b) {
		return a / b;
	}

	@Override
	public Long rem(Long a, Long b) {
		return a % b;
	}
	
	@Override
	public Long max(Long a, Long b) {
		return Math.max(a, b);
	}

	@Override
	public Long min(Long a, Long b) {
		return Math.min(a, b);
	}

	@Override
	public Long abs(Long a) {
		return Math.abs(a);
	}

	@Override
	public Long neg(Long a) {
		return a * (-1);
	}

	@Override
	public Long shiftLeft(Long a, Long b)
	{
		return a << b;
	}

	@Override
	public Long shiftRight(Long a, Long b)
	{
		return a >> b;
	}

	@Override
	public Long shiftUnsignedRight(Long a, Long b)
	{
		return a >>> b;
	}

	@Override
	public Long and(Long a, Long b)
	{
		return a & b;
	}

	@Override
	public Long or(Long a, Long b)
	{
		return a | b;
	}

	@Override
	public Long xor(Long a, Long b)
	{
		return a ^ b;
	}

	@Override
	public Long complement(Long a)
	{
		return ~a;
	}

	@Override
	public int compare(Long a, Long b)
	{
		return a.compareTo(b);
	}

}
