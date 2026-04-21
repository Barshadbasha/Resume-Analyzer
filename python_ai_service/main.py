from fastapi import FastAPI, UploadFile, File
from fastapi.middleware.cors import CORSMiddleware
from service.resume_service import process_resume

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
def home():
    return {"message": "Resume Analyzer API is running"}

@app.post("/analyze")
async def analyze_resume(file: UploadFile = File(...)):
    result = process_resume(file.file)
    return result