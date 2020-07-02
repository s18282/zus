package com.byt.zus.controller;

import com.byt.zus.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "rest/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @PostMapping("/new")
  public ResponseEntity<?> insertFileReturningId(@RequestParam String url) {

    return ResponseEntity.ok(fileService.insertIntoReturningId(url));
  }
}
