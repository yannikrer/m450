# Aufgabe 1
 
## Welche Formen von Tests kennen Sie aus der Informatik?
 
In der Informatik gibt es viele verschiedene Testarten. Drei typische Beispiele aus der Praxis sind:
 
### 1. Unittests (Modultests)
- **Zweck:** Einzelne Programmteile (z. B. Methoden oder Klassen) werden isoliert getestet.  
- **Praxisbeispiel:** In C# oder Java wird mit Frameworks wie *NUnit* oder *JUnit* geprüft, ob eine Methode den erwarteten Rückgabewert liefert.  
- **Durchführung:** Automatisiert, Entwickler schreiben kleine Testmethoden, die beim Build-Prozess ausgeführt werden.
 
### 2. Integrationstests
- **Zweck:** Mehrere Module oder Komponenten werden zusammengesetzt und auf ihr Zusammenspiel getestet.  
- **Praxisbeispiel:** Ein Webserver wird zusammen mit einer Datenbank getestet, ob die Kommunikation korrekt funktioniert.  
- **Durchführung:** Meist automatisiert mit Testdatenbanken, manchmal auch manuell.
 
### 3. Systemtests / End-to-End-Tests
- **Zweck:** Das Gesamtsystem wird aus Sicht des Benutzers überprüft.  
- **Praxisbeispiel:** In einer Webanwendung wird getestet, ob ein Nutzer sich erfolgreich registrieren und anmelden kann.  
- **Durchführung:** Manuell durch Testpersonen oder automatisiert mit Tools wie *Selenium* oder *Cypress*.
 
---
 
## Fazit
- **Unittests**: Testen einzelne Bausteine.  
- **Integrationstests**: Testen das Zusammenspiel mehrerer Komponenten.  
- **Systemtests**: Testen das komplette System aus Anwendersicht.
 
 
# Aufgabe 2
 
## Beispiel für einen Software-Fehler
- **Software-Fehler:** Ein Programmierer vergisst in einer Banking-App, beim Überweisen den Dezimalpunkt korrekt zu behandeln. Statt 10.50 CHF wird 1050 CHF überwiesen.  
- **Erklärung:** Das ist ein **Fehler im Quellcode** (Bug), der zu falschen Berechnungen führt.
 
## Beispiel für einen Software-Mangel
- **Software-Mangel:** Eine Handy-App für den ÖV zeigt zwar die richtigen Fahrpläne an, aber die Suchfunktion ist so kompliziert, dass man mehrere Minuten braucht, um eine Verbindung zu finden.  
- **Erklärung:** Technisch funktioniert alles korrekt, aber die **Bedienbarkeit und Nutzerfreundlichkeit** sind mangelhaft → die Software erfüllt die Nutzerbedürfnisse nicht.
 
## Beispiel für hohen Schaden durch einen Software-Fehler
- **Beispiel:** 1996 explodierte die europäische Trägerrakete **Ariane 5** kurz nach dem Start wegen eines Software-Fehlers in der Flugsteuerung.  
- **Schaden:** Zerstörung der Rakete und der Satelliten an Bord → mehrere hundert Millionen Euro Verlust.

## Aufgabenverteilung
## Luca: Aufgabe 1
## Yannick: Aufgabe 2
## Amir: Aufgabe 3