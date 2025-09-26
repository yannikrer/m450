import http from "k6/http";
import { sleep, check } from "k6";

// Defaults (können via Env überschrieben werden)
const BASE = __ENV.BASE_URL || "http://localhost:8080";
const PATH_HEALTH = __ENV.PATH_HEALTH || "/";
const PATH_LIST   = __ENV.PATH_LIST   || "/students";

export const options = {
  vus: 5,              // gleichzeitige Nutzer
  duration: "20s",     // Testdauer
  thresholds: {
    http_req_duration: ["p(95)<1000"], // 95% der Requests <1s
    http_req_failed: ["rate<0.01"]     // <1% Fehler
  }
};

export default function () {
  // Health Check
  let res1 = http.get(`${BASE}${PATH_HEALTH}`);
  check(res1, { "health ok": (r) => [200,301,302,404].includes(r.status) });

  // Studentenliste abrufen
  let res2 = http.get(`${BASE}${PATH_LIST}`);
  check(res2, { "list ok": (r) => r.status === 200 });

  sleep(1); // kleine Pause pro Iteration
}
