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


public interface Operations<X extends Number> {
	
	X add(X value, X x);
	
	X sub(X a, X b);
	
	X mul(X a, X b);
	
	X div(X a, X b);
	
	X max(X a, X b);
	
	X min(X a, X b);
	
	X abs(X a);
	
	X neg(X a);
}
