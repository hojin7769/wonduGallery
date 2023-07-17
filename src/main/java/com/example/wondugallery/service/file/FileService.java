package com.example.wondugallery.service.file;

import com.amazonaws.services.s3.AmazonS3Client;
import com.example.wondugallery.service.CrudService;
import com.example.wondugallery.service.S3.dto.S3FileDto;
import com.example.wondugallery.service.file.dto.request.FileRequest;
import com.example.wondugallery.service.file.dto.response.FileResponse;
import com.example.wondugallery.service.file.entity.FileEntity;
import com.example.wondugallery.service.file.repository.FileRepositotry;
import com.example.wondugallery.utils.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService implements CrudService<FileResponse, FileRequest> {

    private final FileRepositotry fileRepositotry;
    private final FileUploader fileUploader;

    @Autowired
    public FileService(FileRepositotry fileRepositotry, FileUploader fileUploader) {
        this.fileRepositotry = fileRepositotry;
        this.fileUploader = fileUploader;
    }

    @Transactional(readOnly = true)
    @Override
    public List<FileResponse> findAll(FileRequest fileRequest, Pageable pageable) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public FileResponse findById(Long id) {
        FileEntity fileEntity = fileRepositotry.findById(id).get();
        return FileResponse.from(fileEntity);
    }

    @Override
    public FileResponse insert(FileRequest fileRequest) {

        if(fileRequest.fileName().isBlank()){
            throw new RuntimeException("저장 할 데이터가 없습니다.");
        }
        FileEntity save = fileRepositotry.save(fileRequest.toEntitiy(null));
        return FileResponse.from(save);
    }

    @Override
    public FileResponse update(FileRequest fileRequest) {
        if (fileRequest.fileSeq() == null){
            throw new RuntimeException("업로드할 수 없습니다.");
        }
        FileEntity save = fileRepositotry.save(fileRequest.toEntitiy(null));
        return FileResponse.from(save);
    }

    @Override
    public void delete(FileRequest fileRequest) {
        if (fileRequest.fileSeq() == null){
            throw new RuntimeException("삭제할 수 없습니다.");
        }
        fileRepositotry.delete(fileRequest.toEntitiy(null));
    }

    public List<FileResponse> uploadListFile(String fileType,List<MultipartFile> multipartFileList){

        List<S3FileDto> jpg = fileUploader.uploadFiles(fileType, multipartFileList);
        return null;
    }
}
