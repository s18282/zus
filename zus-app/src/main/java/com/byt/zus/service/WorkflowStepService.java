package com.byt.zus.service;

import com.balaur.zus.dao.tables.pojos.WorkflowStep;
import com.byt.zus.dao.FileStatus;
import com.byt.zus.repository.WorkflowStepRepository;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WorkflowStepService {

  private final WorkflowStepRepository workflowStepRepository;

  public WorkflowStepService(final WorkflowStepRepository workflowStepRepository) {

    this.workflowStepRepository = workflowStepRepository;
  }

  public void insertWorkflow(final long fileId, final FileStatus fileStatus) {

    final Long userId = 0L;
    workflowStepRepository.insert(new WorkflowStep(null, LocalDateTime.now(), fileStatus, fileId, userId));
  }

  public List<WorkflowStep> findAll() {

    return List.ofAll(workflowStepRepository.findAll());
  }

  public List<WorkflowStep> findAllByFileId(final Long fileId) {

    return workflowStepRepository.findAllByFileId(fileId);
  }
}
