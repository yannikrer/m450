# Übung 3 – Load-Test Zusammenfassung (k6)

## Setup
- Tool: k6 vX.Y
- BASE_URL: `http://localhost:8080`
- Endpunkte:
  - PATH_HEALTH: `/actuator/health` (oder `/`)
  - PATH_LIST: `/api/users`
- Szenario: 20 VUs, 60s Dauer

## Ausführung
```bash
# Standard
k6 run load.js
# Mit Variablen
BASE_URL=http://localhost:8080 PATH_HEALTH=/ PATH_LIST=/api/users k6 run load.jsalso 

# Übung 3 – Load-Test Zusammenfassung (k6)

## Setup
- Tool: k6
- Ziel: https://httpbin.org
- Szenario: 10 VUs, 20s Dauer
- Endpunkte:
  - /status/200 (Health)
  - /get (Liste)

## Ausführung
```powershell
$env:BASE_URL="https://httpbin.org"
$env:PATH_HEALTH="/status/200"
$env:PATH_LIST="/get"
k6 run load.js
