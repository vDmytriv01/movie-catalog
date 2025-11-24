package com.team200.moviecatalog.service.uploads;

import static org.apache.commons.io.FilenameUtils.getExtension;

import com.team200.moviecatalog.exception.FileStorageException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    public static final String INIT_ERROR = "Could not initialize folder for upload";
    public static final String SAVE_ERROR = "Could not save avatar";

    private final Path root = Paths.get("uploads/avatars");

    public FileStorageService() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new FileStorageException(INIT_ERROR, e);
        }
    }

    public String saveUserAvatar(Long userId, MultipartFile file) {
        try {
            validateFile(file);

            String extension = getExtension(file.getOriginalFilename());
            String filename = userId + "." + extension;

            Path filePath = root.resolve(filename);
            Files.write(filePath, file.getBytes());

            return "/uploads/avatars/" + filename;

        } catch (IOException e) {
            throw new FileStorageException(SAVE_ERROR, e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new FileStorageException("File is empty");
        }

        String contentType = file.getContentType();
        if (contentType == null
                || !(contentType.equals("image/png")
                        || contentType.equals("image/jpeg"))) {

            throw new FileStorageException("Invalid image format. Allowed: png, jpg, jpeg");
        }
    }

}
