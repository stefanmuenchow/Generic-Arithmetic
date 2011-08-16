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
 * Interface defining operations for unary functions. Each implementation
 * defines one actual operation (like strategy pattern by the gang of four).
 * 
 * @author Stefan Münchow
 */
public interface UnaryOperation {
	
	Integer apply(Integer a);
	
	Long apply(Long a);
	
	Short apply(Short a);
	
	Byte apply(Byte a);
	
	Double apply(Double a);
	
	Float apply(Float a);

	BigInteger apply(BigInteger a);

	BigDecimal apply(BigDecimal a);
}
