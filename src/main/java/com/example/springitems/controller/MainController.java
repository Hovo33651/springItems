package com.example.springitems.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class MainController {

    @Value("${springItems.upload.path}")
    private String imagePath;

    @GetMapping("/")
    public String main() {
        return "main";}


    @GetMapping(value = "/getImage",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get(imagePath + picName));
        return IOUtils.toByteArray(inputStream);
    }
}
