package com.blog_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog_app.helper.FileUploadhelper;


@RestController
public class FileUploadController {

@Autowired
private FileUploadhelper uploader;

@PostMapping("/upload")
public ResponseEntity< String> UploadFileMth(@RequestParam("file") MultipartFile file) {
    
    try {
        
        boolean b = uploader.UploadFile(file);

        if(b){
           // return ResponseEntity.ok("file is uploaded Successfully");
             return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("there is something wrong");
}
}
