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

public class Operations {
	private static BinaryOperation addition = new Addition();
	private static BinaryOperation division = new Division();
	private static BinaryOperation maximum = new Maximum();
	private static BinaryOperation minimum = new Minimum();
	private static BinaryOperation multiplication = new Multiplication();
	private static BinaryOperation subtraction = new Subtraction();
	private static UnaryOperation absolute = new Absolute();
	private static UnaryOperation negation = new Negation();
	
	private Operations() {
	}

	public static BinaryOperation getAddition() {
		return addition;
	}

	public static BinaryOperation getDivision() {
		return division;
	}

	public static BinaryOperation getMaximum() {
		return maximum;
	}

	public static BinaryOperation getMinimum() {
		return minimum;
	}

	public static BinaryOperation getMultiplication() {
		return multiplication;
	}

	public static BinaryOperation getSubtraction() {
		return subtraction;
	}

	public static UnaryOperation getAbsolute() {
		return absolute;
	}

	public static UnaryOperation getNegation() {
		return negation;
	}
}
