# JUnit 5 – Kurz & Bündig

## Wichtigste Annotationen
- `@Test` – markiert einen Testfall.
- `@BeforeEach` / `@AfterEach` – Setup/Teardown vor bzw. nach **jedem** Test.
- `@BeforeAll` / `@AfterAll` – Setup/Teardown **einmalig** pro Testklasse (müssen `static` sein).
- `@DisplayName` – schöner Name für Tests.
- `@Disabled` – Test (vorübergehend) überspringen.
- `@Nested` – Tests logisch gruppieren (innere Klassen).
- `@Tag` – Tests kategorisieren/filtern.
- `@ParameterizedTest` – datengesteuerte Tests.
  - Quellen: `@ValueSource`, `@CsvSource`, `@MethodSource`

## Assertions (Auswahl)
- `assertEquals(expected, actual, delta)` – Zahlen vergleichen.
- `assertTrue/False(condition)` – Wahrheitswerte prüfen.
- `assertThrows(Exception.class, () -> ...)` – Exceptions erwarten.
- `assertAll(() -> ..., () -> ...)` – mehrere Asserts bündeln.
- `assertTimeout(Duration, Executable)` – Laufzeitgrenze.

## Assumptions
- `assumeTrue(...)` – Test nur ausführen, wenn Bedingung erfüllt (z.B. OS abhängig).

## Beispiel (Parameterized)
```java
@ParameterizedTest
@CsvSource({ "2,3,5", "-1,1,0" })
void addiere(double a, double b, double sum) {
    assertEquals(sum, new Calculator().add(a,b), 1e-9);
}
```

## Ausführen
- **IDE:** Rechtsklick auf Klasse/Ordner → *Run Tests*.
- **Maven (CLI):**
  ```bash
  mvn -q -DskipTests=false test
  mvn jacoco:report  # Coverage Report unter target/site/jacoco/index.html
  ```

## Referenzen
- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Assertions-API Javadoc: https://javadoc.io/doc/org.junit.jupiter/junit-jupiter-api/latest/index.html
