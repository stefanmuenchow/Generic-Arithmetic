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


public class Negation implements UnaryOperation {
	
	@Override
	public Integer apply(Integer a) {
		return Integer.valueOf(a * (-1));
	}

	@Override
	public Long apply(Long a) {
		return Long.valueOf(a * (-1));
	}

	@Override
	public Short apply(Short a) {
		return Short.valueOf((short) (a * (-1)));
	}

	@Override
	public Byte apply(Byte a) {
		return Byte.valueOf((byte) (a * (-1)));
	}

	@Override
	public Double apply(Double a) {
		return Double.valueOf(a * (-1));
	}

	@Override
	public Float apply(Float a) {
		return Float.valueOf(a * (-1));
	}

	@Override
	public BigInteger apply(BigInteger a) {
		return a.negate();
	}

	@Override
	public BigDecimal apply(BigDecimal a) {
		return a.negate();
	}
}
