package com.byt.zus.controller;

import com.byt.zus.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @PostMapping("/new")
  public ResponseEntity<?> insertFileReturningId(@RequestParam String url) {

    return ResponseEntity.ok(fileService.insertIntoReturningId(url));
  }

  @GetMapping("/getAll")
  public ResponseEntity<?> getAllFiles(){

    return ResponseEntity.ok(fileService.getAllFiles());
  }

  @PostMapping("/changeUrl")
  public ResponseEntity<?> changeUrl(@RequestParam String oldUrl, @RequestParam String newUrl){

    return ResponseEntity.ok(fileService.changeUrl(oldUrl, newUrl));
  }

}
