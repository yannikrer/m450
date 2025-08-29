# Übung 1 – Rabattregeln Verkaufssoftware

## Aufgabenstellung
Über die Verkaufssoftware kann das Autohaus seinen Verkäufern Rabattregeln vorgeben:  

- Kaufpreis < 15’000 CHF → **kein Rabatt**  
- Kaufpreis ≤ 20’000 CHF → **5 % Rabatt**  
- Kaufpreis < 25’000 CHF (aber > 20’000 CHF) → **7 % Rabatt**  
- Kaufpreis ≥ 25’000 CHF → **8,5 % Rabatt**

---

## Abstrakte Testfälle

| ID  | Bedingung (Kaufpreis `P`) | Erwarteter Rabatt |
|-----|---------------------------|-------------------|
| EC1 | `P < 15'000`              | 0 %              |
| EC2 | `15'000 ≤ P ≤ 20'000`     | 5 %              |
| EC3 | `20'000 < P < 25'000`     | 7 %              |
| EC4 | `P ≥ 25'000`              | 8.5 %            |
| B1  | `P = 14'999.99`           | 0 %              |
| B2  | `P = 15'000`              | 5 %              |
| B3  | `P = 20'000`              | 5 %              |
| B4  | `P = 20'000.01`           | 7 %              |
| B5  | `P = 24'999.99`           | 7 %              |
| B6  | `P = 25'000`              | 8.5 %            |

---

## Konkrete Testfälle

| ID  | Eingabe Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwarteter Rabattbetrag (CHF) | Erwarteter Endpreis (CHF) | Besonderheit |
|-----|--------------------------|-----------------------|-------------------------------|---------------------------|--------------|
| T1  | 14’000.00                | 0.0                   | 0.00                          | 14’000.00                 | Repräsentant EC1 |
| T2  | 14’999.99                | 0.0                   | 0.00                          | 14’999.99                 | Grenze unter 15’000 (B1) |
| T3  | 15’000.00                | 5.0                   | 750.00                        | 14’250.00                 | Untere Grenze EC2 (B2) |
| T4  | 18’000.00                | 5.0                   | 900.00                        | 17’100.00                 | Mitte EC2 |
| T5  | 20’000.00                | 5.0                   | 1’000.00                      | 19’000.00                 | Obere Grenze EC2 (B3) |
| T6  | 20’001.00                | 7.0                   | 1’400.07                      | 18’600.93                 | Direkt über 20’000 (B4) |
| T7  | 24’000.00                | 7.0                   | 1’680.00                      | 22’320.00                 | Mitte EC3 |
| T8  | 24’999.99                | 7.0                   | 1’750.00*                     | 23’249.99*                | Obergrenze EC3 (B5) |
| T9  | 25’000.00                | 8.5                   | 2’125.00                      | 22’875.00                 | Untere Grenze EC4 (B6) |
| T10 | 35’000.00                | 8.5                   | 2’975.00                      | 32’025.00                 | Repräsentant EC4 |

\* Werte sind kaufmännisch auf 2 Nachkommastellen gerundet.  
