package com.dot.s3.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dot.s3.Data;
import com.dot.s3.service.UploadService;


@RestController
@RequestMapping("/data")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @RequestMapping(value = "/upload", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
    public String uploadFile(@RequestPart(value = "data") MultipartFile multiPartFile) throws IOException {
        return uploadService.uploadFile(multiPartFile);
    }

    @RequestMapping
    public List<Data> getData() {
        return uploadService.getdatas();

    }
}