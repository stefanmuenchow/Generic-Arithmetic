package com.stefanmuenchow.arithmetic;

public interface TypeConverter {
	<X extends Number> X convertNumber(Number n, Class<? extends Number> targetClass);
}
