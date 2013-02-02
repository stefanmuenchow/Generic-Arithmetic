# Generic-Arithmetic
Generic-Arithmetic ist eine Java-Bibliothek, die generische Arithmetik mit beliebigen numerischen Datentypen erlaubt. Notwendige Typkonversionen werden intern automatisch durchgeführt. Datentypen können auch miteinander gemischt werden, d.h. es könnten z.B. ein double- und ein BigInt-Wert miteinander verrechnet werden.

## Motivation
Um in Java mit Zahlen zu rechnen, dessen Datentyp im Voraus nicht bekannt ist, muss hoher Aufwand betrieben werden. Standardmäßig gibt es einige Klassen für numerische Werte, die auch die gemeinsame Oberklasse java.lang.Number haben. Jedoch sind die Operationen, also + – * und /, nicht in Number, sondern in den Unterklassen definiert. Im Falle der Klassen BigInteger und BigDecimal existieren entsprechende Methoden. Dies widerspricht dem objektorientierten Ansatz allgemeine Operationen auf einer möglichst hohen Ebene der Klassenhierarchie zu definieren und erschwert so die Implementierung von Funktionen, die generische Berechnungen ausführen. Sucht man nach dem Problem im Internet findet man nur eine einzige Bibliothek namens generic-java-math. Sie ermöglicht immerhin die Ausführung von Operationen auf zwei Elementen gleichen Typs. Allerdings erscheint mir die Benutzung nicht so intuitiv, wie ich sie mir vorstellen würde. Außerdem wäre es interessant, auch verschiedene numerische Datentypen miteinander verrechnen zu können.
Also habe ich eine Bibliothek implementiert, die generische Arithmetik auf allen bestehenden Unterklassen von java.lang.Number ermöglicht. Dabei wird der Zieldatentyp einer Berechnung angegeben. Anschließend können beliebige numerische Datentypen miteinander verrechnet werden. Intern finden alle notwendigen Umwandlungen statt. Die zentrale Klasse ist dabei die Klasse Arithmetic. Sie bietet alle notwendigen Methoden für Berechnungen an.

## Benutzung
Beispiele sagen mehr als tausend Worte. Daher gibt es gleich etwas Code zu sehen, in dem der Durchschnitt eines Arrays mit Zahlen verschiedenen Typs berechnet werden soll:

```java
Number[] numbers = new Number[] { (short) 3, (byte) -5, 7, -9l, 11f, -13d, new BigInteger("15"), new BigDecimal(-17d) };
Arithmetic<Double> doubleArithmetic = new Arithmetic<Double>(0d);

for(Number a : numbers) {
    doubleArithmetic.add(a);
}
Double result = doubleArithmetic.div(numbers.length).value();
```

Bei der Erzeugung eines Arithmetic-Objekts wird der Zieltyp der Berechnung als Typvariable übergeben. Außerdem muss ein Initialwert der angegebenen Typs übergeben werden, hier ist dies ein Double-Wert. Achtung: Das Arithmetic-Objekt ist veränderlich und enthält immer das Ergebnis der letzten Berechnung. Daher reicht es hier, in der for-Schleife die add-Methode mit dem aktuellen Element des Arrays als Parameter aufzurufen. Der Rückgabewert einer Operation ist immer das Arithmetic-Objekt selbst, sodass bei Bedarf mehrere Aufrufe hintereinander geschrieben werden können (hier nicht verwendet – siehe Beispiele weiter unten auf dieser Seite). Der aktuelle Wert der Berechnung kann jederzeit über die value-Methode der Arithmetik-Klasse ermittelt werden. Diese gibt das Ergebnis mit dem Datentyp zurück, der bei der Erzeugung als Typvariable angegeben wurde. Im obigen Beispiel ist das Ergebnis übrigens -1.0.
Damit ist der wichtigste Teil schon erklärt. Standardmäßig sind die Grundoperationen add, sub, mul und div vorhanden. Zusätzlich gibt es eine Minimum und eine Maximumfunktion, sowie den Betrag (abs) und eine Umkehrung des Vorzeichens (neg). Die Berechnung funktioniert für alle Subklassen von Number, die in der normalen Java-Bibliothek mitgeliefert werden. Wie weitere (eigene) Subklassen von Number ebenfalls verwendet werden können, wird ganz am Ende dieser Seite erklärt.
Zur Funktionsweise: Die Arithmetic-Klasse wandelt jeden Operanden in den Zieldatentyp, bevor er mit dem aktuellen Wert der Arithmetic-Instanz verrechnet wird. Wird der Wert eines Datentyps mit einem größeren Wertebereich oder größerer Genauigkeit als Operand übergeben, so wird auch dieser in den Zieldatentyp konvertiert. Es findet keine automatische Typerweiterung des Arithmetic-Objekts statt. Dies hat den Grund, dass der Benutzer der Klasse dadurch immer sicher weiß, welchen Datentyp das Arithmetik-Objekt beim Aufruf der value-Methode zurückliefern wird.

## Beispiel: Generischer LookupTable
Als Beispiel werde ich hier einen generischen LookupTable implementieren. Dieser ist im Grunde genommen eine Wertetabelle für eine mathematische Funktion. Wird ein Wert zwischen zwei bekannten Werten abgefragt, so wird dieser durch lineare Interpolation berechnet. Der LookupTable wird wie eine Map mit zwei Typvariablen parametrisiert. Beide Typen können beliebige Subklassen von Number sein. Im folgenden der Code der Klasse LookupTable:

```java
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

        // f0 + ((f1 - f0) / (x1 - x0)) * (x - x0)
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
}
```

Die wirklich interessante Methode ist hier interpolate. Alle anderen Methoden werden lediglich zur Erzeugung eines LookupTables, dem Hinzufügen von Werten und der Ausgabe als String benötigt. Innerhalb der interpolate-Methode wird durch lineare Interpolation ein Zwischenwert zwischen zwei bekannten Werten berechnet. Da die Typen der Zahlenpaare unterschiedlich sein können, können hier die Vorteile der generischen Arithmetic-Klasse voll ausgenutzt werden. Man beachte, dass die tatsächlichen Datentypen zu diesem Zeitpunkt unbekannt sind. Es können beliebige numerische Typen für den LookupTable verwendet werden. Der Rückgabewert der Methode muss dem Typen Y entsprechen, da die Funktionswerte f(x) diesen Typ haben.
Etwas Vorsicht ist bei der Ausführungsreihenfolge der Operationen geboten: So etwas wie eine Operatoren-Priorität gibt es bei den Methodenaufrufen der Arithmetic-Klasse nicht (wäre bei einfachen Methodenaufrufen in Java auch gar nicht möglich). Nehmen wir an, die letzte Zeile der interpolate-Methode würde folgendermaßen aussehen:

```java
return new Arithmetic<Y>(f0).add(slope).mul(x).sub(x0).value();
```

Syntaktisch und logisch wäre das möglich, es bedeutet aber nicht das, was ausgdrückt werden soll. Die Auswertung findet von links nach rechts statt, wodurch die mathematisch korrekte Auswertungsreihenfolge verloren geht. Um dies zu verhindern, wird im Beispiel oben für jede “Klammer” ein neues Arithmetic-Objekt verwendet. Dadurch werden die ineinander geschachtelten Arithmetic-Objekte von innen nach außen ausgewertet, das innerste zuerst.
Die LookupTable-Klasse kann nun mit beliebigen numerischen Typen verwendet werden. Ein kleiner Test:

```java
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
}
```

## Verwendung weiterer numerischer Datentypen
Es kann vorkommen, dass man neben den numerischen Datentypen, die Java mitbringt, weitere spezielle numerische Typen verwenden möchte. Dies können mit Generic-Arithmetic einfach genutzt werden. Dazu sind folgende Schritte nötig:
Der Datentyp muss eine Subklasse von Number sein und die Methoden shortValue, byteValue, intValue, longValue, floatValue und doubleValue implementieren
Es muss eine Implementierung der Schnittstelle TypeConverter für den Datentyp erstellt werden
Es muss eine Implementierung der Schnittstelle Operations für den Datentyp erstellt werden
Der Datentyp muss der Arithmetic-Klasse zusammen mit dem Konverter und dem Operations-Objekt bekannt gemacht werden
Dies klingt zunächst aufwendig, ist jedoch im Endeffekt sehr einfach. Ich werde das Vorgehen anhand eines Beispiels zeigen. Die neue numerische Klasse heißt HexLong und stellt einen hexadezimalen Long-Wert dar (ob diese Klasse sinnvoll ist, sei hier dahingestellt. Zu Demonstrationszwecken reicht sie aus.). Sie sieht folgendermaßen aus:

```java
<pre>public class HexLong extends Number {
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
```

Die Klasse ist sehr einfach: Sie erweitert Number und implementiert die entsprechenden Konvertierungsmethoden zu den primitiven Datentypen von Java. Außerdem stellt sie die grundsätzlichen Operationen bereit, um zwei HexLong-Objekte miteinander zu verrechnen. Die Klasse HexUtils soll hier nicht gezeigt werden. Sie beinhaltet lediglich eine Methoden zur Konvertierung eines Long-Wertes in einen Hexadezimal-String und eine Methode für die umgekehrte Richtung. Diese entsprechen in etwa den Methoden aus diesem Blogartikel aus dem Snippet IT Blog.
Als nächstes implementieren wir den TypeConverter. Dieser wird benötigt, um beliebige Zahlen zu einem HexLong zu konvertieren. Er ist ebenfalls sehr simpel:

```java

public class HexLongConverter implements TypeConverter<HexLong> {

	@Override
	public HexLong convertNumber(Number n) {
		return HexLong.valueOf(n.longValue());
	}
}
```

Nun ist die wichtigste Voraussetzung bereits gegeben: Ein HexLong kann durch die Methoden in der HexLong-Klasse in ein Objekt eines anderen vorhandenen Number-Typs und ein Objekt eines vorhandenen Number-Typs zu einem HexLong konvertiert werden. Nun muss noch definiert werden, wie zwei HexLong-Werte miteinander verrechnet werden. Dies geschieht durch die Implementierung der Schnittstelle Operations:

```java
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
```

Damit ist es fast geschafft. Der neue Zieltyp HexLong muss der Arithmetic-Klasse noch, zusammen mit den beiden zusätzlichen Klassen HexLongConverter und HexLongOperations, bekanntgegeben werden. Anschließend kann er wie alle anderen Number-Typen zusammen mit der Klasse Arithmetic verwendet werden. Die Bekanntgabe geschieht durch folgenden Aufruf:

```java
Arithmetic.addTargetType(HexLong.class, new HexLongConverter(), new HexLongOperations());
```

Anschließend kann HexLong genauso wie die vorhandenen Typen verwendet werden. Hier als Beispiel ein LookupTable mit HexLong:

```java
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
```

Viel Spaß beim Rechnen!

## Lizenz
Copyright (c) Stefan Münchow. All rights reserved.

The use and distribution terms for this software are covered by the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at the root of this distribution. By using this software in any fashion, you are agreeing to be bound by the terms of this license. You must not remove this notice, or any other, from this software.