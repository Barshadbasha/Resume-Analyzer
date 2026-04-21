package com.ResumeAnalyzer.demo.service;

import com.ResumeAnalyzer.demo.model.ResumeResponse;
import com.sun.net.httpserver.Headers;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerRequest;

@Service
public class ResumeService {

    private final RestTemplate restTemplate = new RestTemplate();
    public ResumeResponse processResume(MultipartFile file)
    {
        try{
            String url= "http://localhost:8000/analyze";

            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body=new LinkedMultiValueMap<>();
            body.add("file", file.getResource());

            HttpEntity<MultiValueMap<String, Object>>requestEntity=new HttpEntity<>(body, headers);

            ResponseEntity<ResumeResponse> response= restTemplate.postForEntity(url, requestEntity, ResumeResponse.class);
            return response.getBody();


        }
        catch (Exception e){
            throw new RuntimeException("Error in upload resume",e);
        }
    }


}
