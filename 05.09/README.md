# Aufgaben – JUnit & Banken-Simulation

## Projekt bauen & Tests ausführen
```bash
# im Projekt-Root (wo die pom.xml liegt):
mvn -q -DskipTests=false test
# Coverage Report erzeugen:
mvn jacoco:report
# Bericht öffnen: target/site/jacoco/index.html
```

## Struktur
- `src/main/java/ch/schule/Calculator.java` – simpler Rechner
- `src/test/java/ch/schule/CalculatorTest.java` – Unit-Tests dafür
- `src/main/java/ch/schule/bank/*` – Banken-Simulation
- `src/test/java/ch/schule/bank/BankSimulationTest.java` – Tests
- `docs/JUnit-Zusammenfassung.md` – Aufgabe 2
- `docs/Banken-Simulation-Notizen.md` – Aufgabe 3
