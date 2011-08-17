package com.stefanmuenchow.arithmetic;

public interface TypeConverter {
	<X extends Number> X convertNumber(Number n, Class<X> targetClass);
}
