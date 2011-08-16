/**
 * Copyright (c) Stefan Münchow. All rights reserved.
 * 
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.arithmetic.operation;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Absolute implements UnaryOperation {
	
	@Override
	public Integer apply(Integer a) {
		return Math.abs(a);
	}

	@Override
	public Long apply(Long a) {
		return Math.abs(a);
	}

	@Override
	public Short apply(Short a) {
		return Integer.valueOf(Math.abs(a)).shortValue();
	}

	@Override
	public Byte apply(Byte a) {
		return Integer.valueOf(Math.abs(a)).byteValue();
	}

	@Override
	public Double apply(Double a) {
		return Math.abs(a);
	}

	@Override
	public Float apply(Float a) {
		return Math.abs(a);
	}

	@Override
	public BigInteger apply(BigInteger a) {
		return a.abs();
	}

	@Override
	public BigDecimal apply(BigDecimal a) {
		return a.abs();
	}
}
