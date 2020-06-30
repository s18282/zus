package com.byt.zus.service;

import com.balaur.zus.dao.tables.pojos.File;
import com.byt.zus.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

  private final FileRepository fileRepository;

  public Long insertIntoReturningId(final String url) {

    return fileRepository.insertIntoReturningId(new File(null, url));
  }
}
