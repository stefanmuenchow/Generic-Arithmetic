# Generic-Arithmetic
**Generic-Arithmetic** is a framework for generic arithmetic in Java. It works with any subclass of java.lang.Number.

For further information see http://www.stefanmuenchow.com/projekte/generic-arithmetic/. There
you will find a tutorial (in german) and the Javadocs.

Generic-Arithmetic will be available in Maven Central repository soon!

```java
Number[] numbers = new Number[] {
    (short) 3, (byte) -5, 7, -9l, 11f, -13d, new BigInteger("15"), new BigDecimal(-17d) };

Arithmetic<Double> doubleArithmetic = new Arithmetic<Double>(0d);

for(Number a : numbers) {
    doubleArithmetic.add(a);
}

Double result = doubleArithmetic.div(numbers.length).value();
´´´

## Licensing
Copyright (c) Stefan Münchow. All rights reserved.

The use and distribution terms for this software are covered by the Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) which can be found in the file epl-v10.html at the root of this distribution. By using this software in any fashion, you are agreeing to be bound by the terms of this license. You must not remove this notice, or any other, from this software.