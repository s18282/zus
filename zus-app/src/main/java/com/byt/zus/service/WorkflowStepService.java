package com.byt.zus.service;

import com.balaur.zus.dao.tables.pojos.WorkflowStep;
import com.byt.zus.dao.FileStatus;
import com.byt.zus.repository.WorkflowStepRepository;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WorkflowStepService {

  private final WorkflowStepRepository workflowStepRepository;

  public void updateWorkflowStatus(final long fileId, final FileStatus fileStatus) {

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
