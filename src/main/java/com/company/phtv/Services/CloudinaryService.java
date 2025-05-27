package com.company.phtv.Services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @SuppressWarnings("rawtypes")
    public Map uploadImage(MultipartFile file, String folderName) throws IOException {
        // Upload ảnh, resource_type mặc định là image
        return cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap(
                        "folder", folderName));
    }

    @SuppressWarnings("rawtypes")
    public Map uploadFileImage(File file, String folderName) throws IOException {
        // Upload ảnh từ File, resource_type mặc định image
        return cloudinary.uploader().upload(file,
                ObjectUtils.asMap(
                        "folder", folderName));
    }

    @SuppressWarnings("rawtypes")
    public Map uploadCV(MultipartFile file, String folderName) throws IOException {
        // Upload file CV (pdf, doc...), phải để resource_type=raw mới xem được preview chuẩn
        return cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "raw",
                        "folder", folderName));
    }

    public void deleteImage(String publicId) {
        try {
            cloudinary.uploader().destroy(publicId, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
