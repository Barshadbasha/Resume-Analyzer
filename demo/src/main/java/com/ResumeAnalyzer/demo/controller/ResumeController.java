package com.ResumeAnalyzer.demo.controller;
import com.ResumeAnalyzer.demo.model.ResumeResponse;
import com.ResumeAnalyzer.demo.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public ResumeResponse uploadResume(@RequestParam("file") MultipartFile file) {
        return resumeService.processResume(file);
    }



}