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

  public void testInsert(final String url){

    fileRepository.testInsert(new File(null, url));
  }

  public Long insertIntoReturningId(final String url) {

    return fileRepository.insertIntoReturningId(new File(null, url));
  }

  public List<String> getAllFiles(){

    return fileRepository.getAll();
  }

  public boolean changeUrl(final String oldUrl, final String newUrl){

    return fileRepository.changeUrl(oldUrl, newUrl);
  }

  public String getUrlFromId(final Long l) {

    return fileRepository.getUrlFromId(l);
  }
}
