package demo;

import com.stefanmuenchow.arithmetic.converter.TypeConverter;

public class HexLongConverter implements TypeConverter<HexLong> {

	@Override
	public HexLong convertNumber(Number n) {
		return HexLong.valueOf(n.longValue());
	}
}
