package com.example.intranet.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserImageService {

    @Value("${images.storage.path}")
    private String storagePath;

    public String saveAvatar(MultipartFile file) throws IOException {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(storagePath, filename);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return filename;
    }

    public byte[] getAvatar(String filename) throws IOException {
        Path path = Paths.get(storagePath, filename);
        return Files.readAllBytes(path);
    }
}
