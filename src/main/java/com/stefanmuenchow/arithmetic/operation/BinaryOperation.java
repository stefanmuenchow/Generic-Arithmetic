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


/**
 * Interface defining operations for binary functions. Each implementation
 * defines one actual operation (like strategy pattern by the gang of four).
 * 
 * @author Stefan Münchow
 */
public interface BinaryOperation {
	
	Integer apply(Integer a, Integer b);
	
	Long apply(Long a, Long b);
	
	Short apply(Short a, Short b);
	
	Byte apply(Byte a, Byte b);
	
	Double apply(Double a, Double b);
	
	Float apply(Float a, Float b);

	BigInteger apply(BigInteger a, BigInteger b);

	BigDecimal apply(BigDecimal a, BigDecimal b);
}
