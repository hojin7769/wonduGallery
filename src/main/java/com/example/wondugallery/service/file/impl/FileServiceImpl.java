package com.example.wondugallery.service.file.impl;

import com.example.wondugallery.service.file.FileService;
import com.example.wondugallery.service.file.dao.FileRepository;
import com.example.wondugallery.service.file.dto.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public FileServiceImpl(@Autowired FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public List<FileDTO> selectFiles() {
        return null;
//        return fileRepository.findAll();
    }
}
