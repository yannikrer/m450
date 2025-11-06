# 📘 Projektdokumentation – ToDo-Verwaltung

## 1. Kurze Planung

Ziel des Projekts war es, eine einfache **To-Do-Anwendung** zu entwickeln, mit der Aufgaben erstellt, verwaltet und gespeichert werden können.
Der Fokus lag auf einer klaren Trennung der Logik (Service-Schicht), Datenhaltung (Repository-Schicht) und Datenstruktur (Model-Schicht).

**Ziele der Planung:**

* Aufgabenobjekte (`TodoItem`) definieren
* Logik für Verwaltung und Speicherung implementieren (`TodoService`, `TodoRepository`)
* Automatisierte Tests erstellen
* Einfache Architektur, erweiterbar für zukünftige GUI oder API

**Geplante Iterationen:**

1. Erstellung der Klassenstruktur
2. Implementierung der Repository-Logik
3. Implementierung der Service-Methoden
4. Schreiben der Unit-Tests
5. Code-Review und Reflektion

---

## 2. Grobe Architektur

Das Projekt folgt einem **mehrschichtigen Aufbau** nach dem MVC-Prinzip (vereinfacht ohne Controller-Schicht).

```text
+------------------+
|   TodoService    |
|------------------|
| + addTodo()      |
| + removeTodo()   |
| + listTodos()    |
+--------+---------+
         |
         v
+------------------+
|  TodoRepository  |
|------------------|
| + save()         |
| + delete()       |
| + findAll()      |
+--------+---------+
         |
         v
+------------------+
|   TodoItem       |
|------------------|
| - title          |
| - description    |
| - done           |
+------------------+
```

**Beschreibung der Komponenten:**

* **TodoItem:** Datenmodell für eine Aufgabe (Titel, Beschreibung, Status).
* **TodoRepository:** Verwaltet die Datenspeicherung (z. B. in einer Liste).
* **TodoService:** Enthält die Geschäftslogik, validiert Eingaben und delegiert an das Repository.
* **Tests:** Überprüfen Funktionen der Repository- und Service-Schicht.

---

## 3. Testkonzept

Das Projekt enthält Unit-Tests, die mit **JUnit** umgesetzt wurden.
Die Tests prüfen die wichtigsten Methoden der Klassen `TodoRepository` und `TodoService`.

**Testarten:**

* **Unit-Tests:** Prüfen einzelne Methoden auf korrektes Verhalten.
* **Integrationstests:** (optional) könnten prüfen, ob Repository und Service korrekt zusammenarbeiten.

**Beispielhafte Testfälle:**

| Komponente     | Testfallbeschreibung                    | Erwartetes Ergebnis                  |
| -------------- | --------------------------------------- | ------------------------------------ |
| TodoRepository | Speichern und Abrufen eines Items       | Item wird korrekt zurückgegeben      |
| TodoService    | Hinzufügen eines neuen Todos ohne Titel | Fehler oder Exception                |
| TodoService    | Auflisten aller Todos                   | Gibt alle gespeicherten Todos zurück |

**Teststrategie:**

* Alle Tests laufen automatisch beim Build-Prozess.
* Fehler in der Logik werden früh erkannt.
* TDD wurde teilweise eingesetzt: Tests wurden parallel mit der Implementierung erstellt.

---

## 4. Reflexion – TDD & Code Review

**TDD (Test Driven Development):**
Die Arbeit mit TDD hat geholfen, sich früh auf die Anforderungen zu fokussieren.
Tests wurden teils vor, teils nach der Implementierung geschrieben.
Dadurch wurde die Codequalität besser, da der Code modularer und testbarer aufgebaut wurde.

**Erkenntnisse:**

* Kleine, klar abgegrenzte Methoden sind einfacher zu testen.
* Frühzeitiges Schreiben der Tests verhindert unklare Logik.

**Code Review:**
Das Code-Review diente der Qualitätskontrolle und der Einhaltung von Konventionen.
Fehler wie ungenutzte Methoden, doppelte Logik oder fehlende Tests wurden erkannt.
Ein gemeinsames Durchsehen des Codes verbesserte Lesbarkeit und Struktur erheblich.

---

## 5. Fazit

Das Projekt demonstriert eine saubere Schichtung, einfache Testbarkeit und nachvollziehbare Logik.
TDD und Code Review führten zu stabilerem und wartbarerem Code.
Eine mögliche Weiterentwicklung wäre die Integration einer Benutzeroberfläche oder einer REST-API.

---

Möchtest du, dass ich diese Dokumentation **als PDF oder Word-Datei** exportiere (z. B. für eine Abgabe oder Präsentation)?
