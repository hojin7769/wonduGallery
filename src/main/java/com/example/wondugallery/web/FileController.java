package com.example.wondugallery.web;

import com.example.wondugallery.response.BasicResponse;
import com.example.wondugallery.service.file.FileService;
import com.example.wondugallery.service.file.dto.response.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/file")
@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @GetMapping("/files/{fileId}")
    public ResponseEntity<?> selectFile(@PathVariable(name = "fileId") Integer fileId){
        return new ResponseEntity<>("NASDAQ",HttpStatus.OK);
    }

    @GetMapping("/files")
    public ResponseEntity<?> selectFiles(){
        return new ResponseEntity<>("test",HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<?> errorTest(){
        throw new RuntimeException("test");
//        return new ResponseEntity<>("test",HttpStatus.OK);
    }


    @PostMapping("/uploadFile")
    public ResponseEntity<BasicResponse> uploadFile(
            @RequestParam("/file") List<MultipartFile> multipartFileList,
            @RequestParam("/fileType") String fileType
    ){

        List<FileResponse> fileResponses = fileService.uploadListFile(fileType, multipartFileList);

        BasicResponse basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .result(fileResponses)
                .message("성공")
                .httpStatus(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(basicResponse,HttpStatus.OK);
    }

}
