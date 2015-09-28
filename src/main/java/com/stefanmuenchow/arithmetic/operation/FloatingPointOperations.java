package com.stefanmuenchow.arithmetic.operation;

import com.stefanmuenchow.arithmetic.Operations;

/**
 * @author mstevens
 *
 */
public abstract class FloatingPointOperations<FP extends Number & Comparable<FP>> implements Operations<FP> {

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#shiftLeft(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP shiftLeft(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The << operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#shiftRight(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP shiftRight(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The >> operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#shiftUnsignedRight(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP shiftUnsignedRight(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The >>> operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#and(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP and(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The & operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#or(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP or(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The | operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#xor(java.lang.Number, java.lang.Number)
	 */
	@Override
	public final FP xor(FP a, FP b) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The ^ operator is undefined for floating-point Numbers");
	}

	/* (non-Javadoc)
	 * @see com.stefanmuenchow.arithmetic.Operations#complement(java.lang.Number)
	 */
	@Override
	public final FP complement(FP a) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("The ~ operator is undefined for floating-point Numbers");
	}

}
