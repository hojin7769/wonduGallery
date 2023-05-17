package com.example.wondugallery.web;

import com.example.wondugallery.response.BasicResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/file")
@RestController
public class FileController {

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

}
