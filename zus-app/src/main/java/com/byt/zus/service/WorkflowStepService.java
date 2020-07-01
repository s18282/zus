package com.byt.zus.service;

import com.byt.zus.dao.tables.pojos.WorkflowStep;
import com.byt.zus.dao.FileStatus;
import com.byt.zus.repository.WorkflowStepRepository;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WorkflowStepService {

  private final WorkflowStepRepository workflowStepRepository;

  public void createWorkflow(final long fileId) {

    final Long userId = 1L;
    workflowStepRepository.insert(new WorkflowStep(null, LocalDateTime.now(), FileStatus.NEW, fileId, userId));
  }

  public void updateWorkflowStatus(final long fileId, final FileStatus fileStatus) {

    final Long userId = 1L;
    workflowStepRepository.findAllByFileId(fileId)
                          .getOrElseThrow(() -> new NoSuchFieldError("wrong fileId"));

    workflowStepRepository.insert(new WorkflowStep(null, LocalDateTime.now(), fileStatus, fileId, userId));
  }

  public List<WorkflowStep> findAllByFileId(final Long fileId) {

    return workflowStepRepository.findAllByFileId(fileId);
  }
}
