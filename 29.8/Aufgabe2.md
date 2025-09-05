# Übungen

## Übung 1 – Rabattlogik: Testfallerhebung

**Regeln (aus der Beschreibung abgeleitet, präzisiert mit Grenzwerten):**

- p < 15’000 ⇒ **0 %**  
- 15’000 ≤ p ≤ 20’000 ⇒ **5 %**  
- 20’000 < p < 25’000 ⇒ **7 %**  
- p ≥ 25’000 ⇒ **8.5 %**

### 1.1 Abstrakte Testfälle (logische Operatoren)

| ID | Eingabe-Bedingung (Preis p)         | Erwarteter Rabatt |
|----|-------------------------------------|-------------------|
| A1 | p < 15’000                          | 0 %               |
| A2 | 15’000 ≤ p ≤ 20’000                 | 5 %               |
| A3 | 20’000 < p < 25’000                 | 7 %               |
| A4 | p ≥ 25’000                          | 8.5 %             |
| A5 | **Grenze unten**: p = 15’000        | 5 %               |
| A6 | **Grenze Mitte**: p = 20’000        | 5 %               |
| A7 | **Grenze Mitte+**: p = 20’000.01    | 7 %               |
| A8 | **Grenze oben**: p = 25’000         | 8.5 %             |

### 1.2 Konkrete Testfälle (mit Beispielwerten)

| ID | Preis (CHF) | Erwartetes Resultat | Effektives Resultat | Status | Mögliche Ursache bei Abweichung |
|----|-------------|---------------------|---------------------|--------|---------------------------------|
| K1 | 14’999      | 0 %                 | —                   | —      | Rundung/Datentyp                |
| K2 | 15’000      | 5 %                 | —                   | —      | Vergleich „≤“ falsch implementiert |
| K3 | 15’001      | 5 %                 | —                   | —      | Schwellenwert verfehlt          |
| K4 | 20’000      | 5 %                 | —                   | —      | Off-by-one bei Obergrenze       |
| K5 | 20’001      | 7 %                 | —                   | —      | Bereichszuordnung               |
| K6 | 24’999      | 7 %                 | —                   | —      |                                 |
| K7 | 25’000      | 8.5 %               | —                   | —      | Vergleich „≥“ fehlerhaft        |
| K8 | 26’000      | 8.5 %               | —                   | —      |                                 |
| K9 | 100’000     | 8.5 %               | —                   | —      | Überlauf/Formatierung           |

---

## Übung 2 – Autovermietung: Funktionale Black-Box-Tests

Beispielplattform: **Autovermietung (z. B. sixt.ch)**.  
Ziel: Die 5 wichtigsten funktionalen Black-Box-Testfälle identifizieren und tabellarisch festhalten.

| ID | Beschreibung | Erwartetes Resultat | Effektives Resultat | Status | Mögliche Ursache bei Abweichung |
|----|--------------|---------------------|---------------------|--------|---------------------------------|
| T1 | **Fahrzeugsuche** mit gültigen Eingaben (Abholort, Datum/Zeit, Alter, Zahlungsland) | Liste verfügbarer Fahrzeuge inkl. korrekter Preise/Konditionen | — | — | Verfügbarkeitsschnittstelle down; falsche Standort-ID |
| T2 | **Buchungsabschluss** eines ausgewählten Fahrzeugs (mit Registrierung/Adresse/Zahlung) | Buchung wird bestätigt; Bestätigungsseite + E-Mail | — | — | PSP-Fehler, Validierungsfehler |
| T3 | **Validierung** bei ungültigen Eingaben (Rückgabe vor Abholung, Alter < Mindestalter, ungültige Karte) | Fehlermeldungen, kein Abschluss möglich | — | — | Client-/Server-Validierung inkonsistent |
| T4 | **Preis-/Konditionsanzeige** (Tarife, Selbstbehalt, Zusatzfahrer, Jungfahrergebühr) | Preise/Konditionen stimmen mit Auswahl/AGB | — | — | Falscher Tarif/Steuerberechnung |
| T5 | **Stornierung** einer bestehenden Buchung (mit Referenz) | Storno bestätigt; Storno-E-Mail; ggf. Gebühr korrekt | — | — | Storno-Policy falsch abgebildet |

---

## Übung 3 – Bank-Software: Testideen & Verbesserungen

Vorgehen: Source-ZIP bzw. Maven-Projekt lokal einrichten (GSON/OKHTTP vorhanden), Code sichten und Testfälle ableiten.

### 3.1 Black-Box-Testfälle (Benutzersicht)

| ID | Testfall | Eingabe/Prämisse | Erwartetes Verhalten | Effektiv | Status | Mögliche Ursache bei Abweichung |
|----|----------|------------------|----------------------|----------|--------|---------------------------------|
| B1 | Konto eröffnen | Gültige Kundendaten | Konto wird erstellt, ID zurückgegeben | — | — | Persistenz/Validierung |
| B2 | Einzahlung | Konto vorhanden, Betrag > 0 | Kontostand erhöht sich um Betrag | — | — | Rundung/Datentyp (double) |
| B3 | Abhebung (ausreichend) | Guthaben ≥ Betrag | Betrag abgebucht, Stand korrekt | — | — | Race-Condition, Fees |
| B4 | Abhebung (unzureichend) | Guthaben < Betrag | Fehlermeldung, kein Abzug | — | — | Negativsaldo erlaubt |
| B5 | Überweisung intern | Zwei Konten, Betrag > 0 | Sender −Betrag, Empfänger +Betrag, atomar | — | — | Nicht-Atomarität, Teilbuchung |
| B6 | Wechselkursabfrage | Gültiger Währungscode | Kurswert geliefert/zwischengespeichert | — | — | API-Timeout/Mapping |
| B7 | Ungültige Eingaben | Betrag ≤ 0 / unbekanntes Konto | Fehler/Validierung greift | — | — | Fehlende Validierung |
| B8 | Grenzwerte/Rundung | Cent-Beträge, viele Dezimalen | Korrekte Rundung (Banker’s Rounding) | — | — | Float-Inpräzision |
| B9 | Konkurrierende Vorgänge | Parallel Ein-/Auszahlungen | Konsistenter Endstand | — | — | Locking/Isolation |

### 3.2 White-Box-Kandidaten (Methoden/Komponenten)

- `addAccount(customer)` – Erzeugung/Validierung/Persistenz  
- `deposit(accountId, amount)` – Guards (amount>0), Rundung, Logging  
- `withdraw(accountId, amount)` – Limits, Fehlerpfade, keine Negativsalden  
- `transfer(fromId, toId, amount)` – Transaktionalität/Atomarität/Idempotenz  
- `getBalance(accountId)` – Korrekte Aggregation  
- `getRate(from, to)` – HTTP-Call (OKHTTP), Fehlerbehandlung/Timeouts, Caching  
- Repositories/DAOs – Datenkonsistenz, Exceptions  
- Serializer (GSON) – (De-)Serialisierung fehlerhafter Payloads  

### 3.3 Verbesserungen / Best Practices

- **Datentypen für Geld**: BigDecimal (Skalierung, RoundingMode) statt double  
- **Transaktionen**: Atomare Überweisungen (ACID), keine Teilzustände  
- **Validierung**: Zentrale Guards (Betrag > 0, Konto existent, Währungscode ISO-4217)  
- **Fehlerbehandlung**: Eindeutige Domänen-Exceptions, klare Fehlermeldungen  
- **Logging/Tracing**: Audit-Log für Geldbewegungen, Korrelation bei HTTP-Calls  
- **Konfiguration**: API-Keys/URLs per Config, Timeout/Retry-Policy  
- **Thread-Safety**: Sperrkonzept/Isolation bei parallelen Buchungen  
- **Testabdeckung**: Unit-, Integrations-, API- und E2E-Tests inkl. Grenzwerte  
- **Namensgebung/Kommentare**: Sprechende Methodennamen, Javadoc/KDoc  
- **Security**: Input-Sanitization, Secret-Handling, Least Privilege für DB  
