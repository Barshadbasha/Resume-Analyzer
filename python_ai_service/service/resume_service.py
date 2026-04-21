from utils.pdf_parser import extract_text_from_pdf
from claude_service import analyze_resume

def process_resume(file):
    text = extract_text_from_pdf(file)
    return analyze_resume(text)