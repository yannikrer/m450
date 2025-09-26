# Übung 1 – Backend-API-Tests (Postman/Newman)

## Run (CLI)
```bash
# einmalig installieren
npm i -g newman

# Standard (localhost:8080, /actuator/health, /api/users)
newman run backend-tests.postman_collection.json

# Variablen überschreiben
newman run backend-tests.postman_collection.json \
  --env-var baseUrl=http://localhost:8081 \
  --env-var healthPath=/ \
  --env-var listPath=/api/whatever
