package com.team200.moviecatalog.service.uploads;

import static com.team200.moviecatalog.constants.Paths.AVATARS_DIR;
import static com.team200.moviecatalog.constants.Paths.AVATARS_URL_PREFIX;
import static org.apache.commons.io.FilenameUtils.getExtension;

import com.team200.moviecatalog.exception.FileStorageException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    public static final String INIT_ERROR = "Could not initialize folder for upload";
    public static final String SAVE_ERROR = "Could not save avatar";
    private static final String INVALID_IMAGE_FORMAT =
            "Invalid image format. Allowed: png, jpg, jpeg";
    private static final String EMPTY_FILE_ERROR = "File is empty";
    private static final String IMAGE_PNG = "image/png";
    private static final String IMAGE_JPEG = "image/jpeg";

    private final Path root;

    public FileStorageService() {
        this.root = Paths.get(AVATARS_DIR).toAbsolutePath().normalize();
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new FileStorageException(INIT_ERROR, e);
        }
    }

    public String saveUserAvatar(Long userId, MultipartFile file) {
        try {
            validateFile(file);

            String extension = getExtension(file.getOriginalFilename()).toLowerCase(Locale.ROOT);
            String filename = userId + "." + extension;

            Path filePath = root.resolve(filename).normalize();
            if (!filePath.startsWith(root)) {
                throw new FileStorageException(INVALID_IMAGE_FORMAT);
            }

            Files.write(
                    filePath,
                    file.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            return AVATARS_URL_PREFIX + filename;

        } catch (IOException e) {
            throw new FileStorageException(SAVE_ERROR, e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new FileStorageException(EMPTY_FILE_ERROR);
        }

        String extension = getExtension(file.getOriginalFilename());
        boolean pngExtension = extension != null && extension.equalsIgnoreCase("png");
        boolean jpegExtension = extension != null
                && (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg"));

        if (!StringUtils.hasText(extension) || !(pngExtension || jpegExtension)) {
            throw new FileStorageException(INVALID_IMAGE_FORMAT);
        }

        String contentType = file.getContentType();
        if (contentType == null
                || !(contentType.equals(IMAGE_PNG)
                || contentType.equals(IMAGE_JPEG))) {

            throw new FileStorageException(INVALID_IMAGE_FORMAT);
        }

        if ((pngExtension && !IMAGE_PNG.equals(contentType))
                || (jpegExtension && !IMAGE_JPEG.equals(contentType))) {
            throw new FileStorageException(INVALID_IMAGE_FORMAT);
        }
    }
}
