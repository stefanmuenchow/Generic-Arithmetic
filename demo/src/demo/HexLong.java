package demo;

import demo.util.HexUtils;

public class HexLong extends Number {
	private static final long serialVersionUID = 2865037043162511506L;
	private final Long value;
	
	public HexLong(long i) {
		this.value = i;
	}
	
	public HexLong(String s) {
		this.value = HexUtils.toLong(s);
	}
	
	public static HexLong valueOf(long i) {
		return new HexLong(i);
	}
	
	public static HexLong valueOf(String s) {
		return new HexLong(s);
	}
	
	@Override
	public short shortValue() {
		return value.shortValue();
	}
	
	@Override
	public byte byteValue() {
		return value.byteValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value;
	}
	
	public HexLong add(HexLong hex) {
		return new HexLong(value + hex.longValue());
	}
	
	public HexLong subtract(HexLong hex) {
		return new HexLong(value - hex.longValue());
	}
	
	public HexLong multiply(HexLong hex) {
		return new HexLong(value * hex.longValue());
	}
	
	public HexLong divide(HexLong hex) {
		return new HexLong(value / hex.longValue());
	}
	
	public HexLong absolute() {
		return new HexLong(Math.abs(value));
	}
	
	@Override
	public String toString() {
		return HexUtils.fromLong(value) + " (decimal: " + longValue() + ")";
	}
}
