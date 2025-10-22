# Testkonzept – Ultimate Music
## 1. Zusammenfassung

Dieses Testkonzept beschreibt die Teststrategie für das Projekt **Ultimate Music**, das im Rahmen der agilen Softwareentwicklung mit **Test-Driven Development (TDD)** umgesetzt wird. Ziel ist es, eine hohe Codequalität sicherzustellen, frühzeitig Fehler zu erkennen und die langfristige Wartbarkeit des Systems zu garantieren.

## 2. Big Picture – Systemarchitektur & Test Items

Das Projekt basiert auf einer typischen **3-Schichten-Architektur**:

- **Frontend**: React Webapplikation (Benutzerschnittstelle)
- **Backend**: Node.js API mit Express
- **Datenbank**: MongoDB

**Test Items**:
- API-Endpunkte (z. B. Login, CRUD-Operationen)
- Geschäftslogik (z. B. Validierungen, Berechnungen)
- Frontend-Komponenten (z. B. Formulare, Buttons, Zustand)

## 3. Test Features

Die folgenden Features werden getestet:

- **Unit-Tests**: für alle Funktionen der Geschäftslogik
- **Integrationstests**: API-Endpunkte in Kombination mit Datenbank
- **Komponententests**: React-Komponenten mit verschiedenen Benutzerinteraktionen
- **Fehlerszenarien**: Ungültige Eingaben, fehlende Daten, Serverfehler

## 4. Features not to be tested

Die folgenden Bereiche werden im Rahmen dieses Projekts nicht getestet:

- Visuelles Design (Layout, Farben, Styles)
- Performance-Tests (z. B. Lasttests)
- Sicherheitstests (z. B. Penetration Testing)
- Datenbankoptimierung

## 5. Testvorgehen (TDD)

Das Projekt wird konsequent nach dem Prinzip **Test-Driven Development (TDD)** umgesetzt:

1. **Red**: Ein fehlender Test wird geschrieben und schlägt fehl.
2. **Green**: Der minimal notwendige Code wird geschrieben, um den Test bestehen zu lassen.
3. **Refactor**: Der Code wird optimiert, ohne dass der Test fehlschlägt.

Jede neue Funktionalität beginnt mit einem Testfall.

## 6. Kriterien für erfolgreiche / nicht-erfolgreiche Tests (optional)

- **Erfolgreich**: Alle automatisierten Tests werden ohne Fehler abgeschlossen.
- **Nicht erfolgreich**: Mindestens ein Test schlägt fehl oder es kommt zu unerwarteten Laufzeitfehlern.

## 7. Testumgebung

**Verwendete Tools:**

- **Jest**: Unit-Tests für Backend und Frontend
- **Supertest**: Integrationstests der API-Endpunkte
- **React Testing Library**: Komponententests im Frontend
- **MongoDB Memory Server**: Für Tests mit einer temporären Datenbank
- **CI/CD Pipeline**: Automatischer Testlauf bei jedem Commit (z. B. via GitHub Actions)

## 8. Planung

| Woche | Meilenstein    | Aktivität                                        |
|-------|----------------|--------------------------------------------------|
| 1     | Setup          | Projektsetup, CI/CD, Teststruktur erstellen     |
| 2–4   | Entwicklung    | TDD-Zyklus für jede neue Funktion               |
| 5     | Stabilisierung | Alle Tests müssen grün sein, Refactoring        |
| 6     | Abschluss      | Testabdeckung prüfen, ggf. Tests ergänzen       |
