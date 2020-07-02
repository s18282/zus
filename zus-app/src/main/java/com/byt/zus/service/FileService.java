package com.byt.zus.service;

import com.byt.zus.dao.tables.pojos.File;
import com.byt.zus.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

  private final FileRepository fileRepository;

  public Long insertIntoReturningId(final String url) {

    return fileRepository.insertIntoReturningId(new File(null, url));
  }

  public List<String> getAllFilesUri(){

    return fileRepository.getAllFilesUri();
  }

  public boolean updateFile(final Long id, final String newUrl){

    return fileRepository.updateFile(id, newUrl);
  }

  public File getFileById(final Long id) {
    return fileRepository.fetchOneById(id);
  }
}
