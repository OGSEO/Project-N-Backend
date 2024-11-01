package nl.gelton.projectnbackend.service;

import nl.gelton.projectnbackend.model.ProfileImage;
import nl.gelton.projectnbackend.model.User;
import nl.gelton.projectnbackend.repository.FileUploadRepository;
import nl.gelton.projectnbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class AvatarService {
    private final Path fileStoragePath;
    private final String fileStorageLocation;
    private final FileUploadRepository fileUploadRepository;
//    private final UserService userService;
//    private final UserRepository userRepository;

    public AvatarService(@Value("${my.upload_location}") String fileStorageLocation, FileUploadRepository fileUploadRepository) throws IOException{
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.fileStorageLocation = fileStorageLocation;
        this.fileUploadRepository = fileUploadRepository;
//        this.userService = userService;

        Files.createDirectories(fileStoragePath);
//        this.userRepository = userRepository;
    }

    public String storeFile(MultipartFile file) throws IOException{

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path filePath = Paths.get(fileStoragePath + "\\" + fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        fileUploadRepository.save(new ProfileImage(fileName));
//        User user = userService.getLoggedUser();
//        user.setHasProfileImage(true);
//        userRepository.save(user);
        return fileName;
    }

    public Resource downLoadFile(String fileName) {

        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);

        Resource resource;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in reading the file", e);
        }

        if(resource.exists()&& resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }

}
