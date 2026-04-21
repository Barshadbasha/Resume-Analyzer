import requests
import os
import json
from dotenv import load_dotenv

load_dotenv()

CLAUDE_API_KEY = os.getenv("CLAUDE_API_KEY")

def analyze_resume(text):

    url = "https://api.anthropic.com/v1/messages"

    headers = {
        "x-api-key": CLAUDE_API_KEY,
        "anthropic-version": "2023-06-01",
        "content-type": "application/json"
    }

    prompt = f"""
You are an AI resume analyzer.

Extract the following from the resume:
- Skills (as a list)
- Years of experience (number)
- Give a score out of 100 based on relevance for software developer role

Return ONLY valid JSON in this format:
{{
  "skills": [],
  "experience": number,
  "score": number
}}

Resume:
{text}
"""

    data = {
        "model": "claude-3",
        "max_tokens": 500,
        "messages": [
            {"role": "user", "content": prompt}
        ]
    }

    response = requests.post(url, headers=headers, json=data)
    result = response.json()

    try:
        content = result["content"][0]["text"]
        parsed = json.loads(content)

        return parsed

    except Exception as e:
        return {
            "skills": [],
            "experience": 0,
            "score": 0,
            "error": str(e),
            "raw": result
        }