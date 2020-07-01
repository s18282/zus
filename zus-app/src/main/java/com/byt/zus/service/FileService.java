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

  //Mariusz
  public List<String> getAllFiles(){

    return fileRepository.getAll();
  }

  //Mariusz
  public void changeUrl(final String oldUrl, final String newUrl){


  }
}
