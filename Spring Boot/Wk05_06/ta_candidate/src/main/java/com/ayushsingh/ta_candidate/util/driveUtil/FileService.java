package com.ayushsingh.ta_candidate.util.driveUtil;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    UploadedFileDto uploadFile(MultipartFile file);
}
