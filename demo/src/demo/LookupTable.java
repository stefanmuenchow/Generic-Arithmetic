package demo;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.stefanmuenchow.arithmetic.Arithmetic;

public class LookupTable<X extends Number, Y extends Number> {
	private final SortedMap<X, Y> values;
	
	public LookupTable() {
		this.values = new TreeMap<X, Y>();
	}
	
	public void addValue(X x, Y y) {
		values.put(x, y);
	}
	
	public Y getValueAt(X x) {
		if(values.containsKey(x)) {
			return values.get(x);
		} else {
			return interpolate(x);
		}
	}
	
	private Y interpolate(X x) {
		X x0 = values.headMap(x).lastKey();
		Y f0 = values.get(x0);
		X x1 = values.tailMap(x).firstKey();
		Y f1 = values.get(x1);
		
		X deltaX = new Arithmetic<X>(x1).sub(x0).value();
		Y deltaY = new Arithmetic<Y>(f1).sub(f0).value(); 
		double slope = new Arithmetic<Double>(deltaY.doubleValue()).div(deltaX).value();
		
		return new Arithmetic<Y>(f0).add(new Arithmetic<Double>(slope).mul(
				new Arithmetic<X>(x).sub(x0).value()).value()).value();
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Lookup table:\n");
		
		for(Map.Entry<X, Y> entry : values.entrySet()) {
			sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
		}
		
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	/**
	 * Werte von http://www.finanznachrichten.de/chart-tool/markt/dax-30.htm
	 */
	public static void main(String[] args) {
		LookupTable<Long, Double> lookupTable = new LookupTable<Long, Double>();
		lookupTable.addValue(    0l, 7170.61d);
		lookupTable.addValue( 5000l, 7204.86d);
		lookupTable.addValue(10000l, 7026.85d);
		lookupTable.addValue(20000l, 7295.49d);
		System.out.println(lookupTable);
		
		System.out.println("\nInterpolated values:");
		long time = 2500l;
		System.out.println(time + " -> " + lookupTable.getValueAt(time));
		time = 10000l;
		System.out.println(time + " -> " + lookupTable.getValueAt(time));		
		time = 17500l;
		System.out.println(time + " -> " + lookupTable.getValueAt(time));
		
		System.out.println();
		Arithmetic.addTargetType(HexLong.class, new HexLongConverter(), new HexLongOperations());
		LookupTable<Double, HexLong> lookupTable2 = new LookupTable<Double, HexLong>();
		lookupTable2.addValue(  1d, HexLong.valueOf("AB"));
		lookupTable2.addValue(2.5d, HexLong.valueOf("CD"));
		lookupTable2.addValue(3.3d, HexLong.valueOf("0"));
		lookupTable2.addValue(4.2d, HexLong.valueOf("A1"));
		System.out.println(lookupTable2);
		
		System.out.println("\nInterpolated values:");
		double x = 1.3;
		System.out.println(x + " -> " + lookupTable2.getValueAt(x).longValue());
		x = 2.7;
		System.out.println(x + " -> " + lookupTable2.getValueAt(x).longValue());		
		x = 3.3;
		System.out.println(x + " -> " + lookupTable2.getValueAt(x).longValue());
	}
}
