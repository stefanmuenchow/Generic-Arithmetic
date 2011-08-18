package com.stefanmuenchow.arithmetic.operation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.stefanmuenchow.arithmetic.Operations;

public class OperationsRepository {
	private static OperationsRepository instance;
	private final Map<Class<?>, Operations<?>> operations;
	
	public static OperationsRepository getInstance() {
		if(instance == null) {
			instance = new OperationsRepository();
		}
		
		return instance;
	}
	
	private OperationsRepository() {
		operations = new HashMap<Class<?>, Operations<?>>();
		operations.put(Short.class, new ShortOperations());
		operations.put(Byte.class, new ByteOperations());
		operations.put(Integer.class, new IntegerOperations());
		operations.put(Long.class, new LongOperations());
		operations.put(Float.class, new FloatOperations());
		operations.put(Double.class, new DoubleOperations());
		operations.put(BigInteger.class, new BigIntegerOperations());
		operations.put(BigDecimal.class, new BigDecimalOperations());
	}
	
	@SuppressWarnings("unchecked")
	public <X extends Number> Operations<X> getOperations(Class<X> targetClass) {
		Operations<X> result = (Operations<X>) operations.get(targetClass);
		
		if (result == null) {
			throw new ArithmeticException("No operations for class " + targetClass + " found!");
		} else {
			return result;
		}
	}
	
	public <X extends Number> void addOperations(Class<X> targetClass, Operations<X> operation) {
		operations.put(targetClass, operation);
	}
}
