package com.stefanmuenchow.arithmetic.converter;

public interface TypeConverter<X extends Number> {
	X convertNumber(Number n);
}
