package com.example.wondugallery.service.file;

import com.example.wondugallery.service.file.dto.FileDTO;

import java.util.List;

public interface FileService {

    List<FileDTO> selectFiles();
}
