package com.coffeehouse.service;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.specialized.BlockBlobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hibernate.annotations.common.AssertionFailure.log;

@Service
public class ImageService {
    @Autowired
    private BlobServiceClient blobServiceClient;

    public String uploadImage(MultipartFile file, String containerName) {
        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);
        String filename = file.getOriginalFilename();
        String filePath = "";
        BlockBlobClient blockBlobClient = blobContainerClient.getBlobClient(filename).getBlockBlobClient();

        try {
            if (blockBlobClient.exists()) {
                blockBlobClient.delete();
            }

            blockBlobClient.upload(new BufferedInputStream(file.getInputStream()), file.getSize(), true);

            assert filename != null;
            if (filename.endsWith(".jpg")) {
                blockBlobClient.setHttpHeaders(new BlobHttpHeaders().setContentType("image/jpeg"));
            } else if (filename.endsWith(".png")) {
                blockBlobClient.setHttpHeaders(new BlobHttpHeaders().setContentType("image/png"));
            }

            filePath = containerName + "/" + filename;
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return "https://anhtcogn.blob.core.windows.net/" + filePath;
    }

    public void deleteImage(String url, String containerName) {
        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);
        int index = 40 + containerName.length();
        String filename = url.substring(index);
        BlockBlobClient blockBlobClient = blobContainerClient.getBlobClient(filename).getBlockBlobClient();
        blockBlobClient.delete();
    }
}
