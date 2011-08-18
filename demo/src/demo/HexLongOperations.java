package demo;

import com.stefanmuenchow.arithmetic.operation.Operations;


public class HexLongOperations implements Operations<HexLong> {

	@Override
	public HexLong abs(HexLong a) {
		return a.absolute();
	}

	@Override
	public HexLong add(HexLong a, HexLong b) {
		return a.add(b);
	}

	@Override
	public HexLong div(HexLong a, HexLong b) {
		return a.divide(b);
	}

	@Override
	public HexLong max(HexLong a, HexLong b) {
		return a.longValue() >= b.longValue() ? a : b;
	}

	@Override
	public HexLong min(HexLong a, HexLong b) {
		return a.longValue() <= b.longValue() ? a : b;
	}

	@Override
	public HexLong mul(HexLong a, HexLong b) {
		return a.multiply(b);
	}

	@Override
	public HexLong neg(HexLong a) {
		return HexLong.valueOf(a.longValue() * (-1));
	}

	@Override
	public HexLong sub(HexLong a, HexLong b) {
		return a.subtract(b);
	}
}
