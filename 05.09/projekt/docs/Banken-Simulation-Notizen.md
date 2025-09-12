# Banken-Simulation – Funktionsweise (Stichworte)

## Klassen
- **Account**
  - Felder: `id`, `owner`, `balanceCents` (long, Werte in Rappen/Cents)
  - Methoden: `deposit()`, `withdraw()`, `getBalanceCents()`
  - Regeln: keine negativen Beträge; nicht mehr abheben, als vorhanden.

- **Bank**
  - Verwaltet Accounts (`Map<String, Account>`).
  - `createAccount(id, owner, initialCents)` – legt Konto an, keine Duplikate.
  - `find(id)` – sucht Konto.
  - `transfer(fromId, toId, cents)` – bewegt Geld zwischen Konten.
  - Liefert *Fehler* bei ungültigen IDs/Beträgen.

## Abläufe
1. Konto anlegen (Startguthaben optional).
2. Ein-/Auszahlungen ändern Kontostand.
3. Transfer: `withdraw()` am Sender, danach `deposit()` am Empfänger.
4. Fehlerszenarien durch **Exceptions** abgesichert.

## Tests (Ziele)
- Happy Paths: Ein-/Auszahlung, Transfer.
- Edge Cases: 0/negativer Betrag, ungenügendes Guthaben, doppelte Konten, unbekannte IDs.
- Coverage prüfen mit **JaCoCo** (HTML-Report unter `target/site/jacoco/index.html`).

## Erweiterungsideen
- Währung/Decimal statt Cents als `long`.
- Transaktionshistorie.
- Thread-Safety (synchronisierte Transaktionen).
