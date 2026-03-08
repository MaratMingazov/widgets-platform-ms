# Widgets MS (Sticky Notes Service)

## 🎓 Educational Project

This project is a **simple Spring Boot REST API** built for **educational purposes**.

It is intentionally kept **small, explicit, and straightforward** so that students can:
- Understand how a backend service is structured
- Learn how controllers, services, and repositories interact
- See how an external API (Miro) is integrated
- Use this project as a **reference implementation** when building their own services

This service is designed to be used **together with a custom Load Balancer project**.

---

## 🧩 What This Service Does

`widgets-ms` exposes a REST API to manage **Sticky Notes** on a Miro board:

- Create a sticky note
- Get a sticky note by ID
- Delete a sticky note
- Expose a `/health` endpoint for load balancer health checks

Internally, it forwards requests to the **Miro REST API** using `RestClient`.

---

## 🏗️ Project Structure

```
controller   # REST controllers (API layer)
dto          # Request / Response DTOs
model        # Domain models
service      # Business logic
repository   # External API integration (Miro)
```

---

##  Swagger UI
http://localhost:8090/swagger-ui/index.html#/

##  Miro REST API
https://developers.miro.com/reference/get-sticky-note-item

##  Kafka-UI
http://localhost:8088

## 🔌 API Endpoints

### Health Check
```http
GET /health
```

Response:
```text
OK
```

---

### Get Sticky Note
```http
GET /stickyNote?boardKey={boardKey}&widgetId={widgetId}
```

---

### Create Sticky Note
```http
POST /stickyNote
Content-Type: application/json
```

Request body:
```json
{
  "boardKey": "your_board_key",
  "text": "Hello from Widgets MS",
  "color": "LIGHT_YELLOW",
  "x": 100,
  "y": 200
}
```

```curl
curl -X POST "http://localhost:8090/stickyNote" \
  -H "Content-Type: application/json" \
  -d '{
    "boardKey": "uXjVJ_vkTA4=",
    "text": "<p>Hello from curl</p>",
    "x": 100,
    "y": 100
  }'
```

---

### Delete Sticky Note
```http
DELETE /stickyNote?boardKey={boardKey}&widgetId={widgetId}
```

---

## 🔐 Configuration

Required properties:
```bash
MIRO_TOKEN=your_miro_api_token
DEFAULT_COLOR=LIGHT_YELLOW
```

Run example:
```bash
java -jar widgets-ms.jar --server.port=8090
```

You can generate a personal access token by following this [guide](https://developers.miro.com/docs/miro-rest-api-introduction#authorization).

### Running in IntelliJ IDEA

1. Open **Run > Edit Configurations...**
2. Select your Spring Boot run configuration
3. In the **CLI Arguments** field, add:
```
--MIRO_TOKEN=your-token --DEFAULT_COLOR=RED
```
4. Apply and run

---

## 🚦 Load Balancer Friendly

This service:
- Exposes `/health`
- Is stateless
- Can run multiple instances
- Is ideal for experimenting with custom load balancers

---

