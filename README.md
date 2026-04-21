# 📄 Resume Analyzer - AI-Powered Resume Analysis

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=java)
![Python](https://img.shields.io/badge/Python-3.12%2B-blue?style=flat-square&logo=python)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=flat-square&logo=springboot)
![FastAPI](https://img.shields.io/badge/FastAPI-0.100%2B-009688?style=flat-square&logo=fastapi)
![Claude AI](https://img.shields.io/badge/Claude-AI-orange?style=flat-square)

A full-stack AI-powered resume analyzer combining a **Spring Boot** Java backend with a **Python FastAPI** microservice using Claude AI.

---

## 📁 Project Structure
Resume-Analyzer/
├── demo/
│   └── src/main/java/com/ResumeAnalyzer/demo/
│       ├── controller/ResumeController.java   # REST API - /api/resume/upload
│       ├── model/ResumeResponse.java          # Response model
│       ├── service/ResumeService.java         # Calls Python AI service
│       └── DemoApplication.java              # Main entry point
├── python_ai_service/
│   ├── main.py                               # FastAPI app
│   ├── claude_service.py                     # Claude AI integration
│   ├── requirements.txt                      # Python dependencies
│   ├── service/resume_service.py             # Resume processing logic
│   ├── models/response_model.py              # Response schema
│   └── utils/pdf_parser.py                   # PDF parsing utility
└── .gitignore
---

## ✨ Features

- 📤 **Resume Upload** — Upload PDF resumes via REST API
- 🤖 **AI Analysis** — Claude AI analyzes resume content
- 📊 **Structured Response** — Returns formatted analysis results
- 🔗 **Microservice Architecture** — Java backend + Python AI service

---

## 🏗️ Architecture
┌─────────────────────────┐        ┌──────────────────────────┐
│   Spring Boot Backend   │  HTTP  │   Python FastAPI Service  │
│   Java - Port 8080      │ ─────► │   Claude AI - Port 8000   │
│   /api/resume/upload    │        │   /analyze                │
└─────────────────────────┘        └──────────────────────────┘

---

## 🚀 Getting Started

### 1️⃣ Run Java Spring Boot

```bash
cd demo
mvn spring-boot:run
```
Runs at: `http://localhost:8080`

### 2️⃣ Run Python FastAPI Service

```bash
cd python_ai_service
pip install -r requirements.txt
```

Create `.env` file:
```env
ANTHROPIC_API_KEY=your_claude_api_key_here
```

```bash
uvicorn main:app --reload --port 8000
```
Runs at: `http://localhost:8000`

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/resume/upload` | Upload and analyze resume |
| GET | `/` | Health check |

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Spring Boot 3.x | Java backend framework |
| FastAPI | Python AI microservice |
| Claude AI | Resume analysis |
| Apache PDFBox | PDF parsing |
| Maven | Java dependency management |

---

## ⚙️ Environment Variables

Create `.env` inside `python_ai_service/`:
```env
ANTHROPIC_API_KEY=your_api_key_here
```
> ⚠️ Never commit `.env` — already in `.gitignore`

---

## 👤 Author

**Barshad Basha**
GitHub: [@Barshadbasha](https://github.com/Barshadbasha)

---

> ⭐ If you found this useful, give it a star!