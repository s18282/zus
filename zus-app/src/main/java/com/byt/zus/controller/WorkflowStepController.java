package com.byt.zus.controller;

import com.byt.zus.dao.FileStatus;
import com.byt.zus.service.WorkflowStepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "rest/workflow")
public class WorkflowStepController {

  private final WorkflowStepService workflowStepService;

  public WorkflowStepController(final WorkflowStepService workflowStepService) {

    this.workflowStepService = workflowStepService;
  }

  @PostMapping("/changeWorkflow")
  public ResponseEntity<?> findById(@RequestParam long fileId,
                                    @RequestParam String fileStatus) {

    workflowStepService.insertWorkflow(fileId, FileStatus.valueOf(fileStatus));
    return ResponseEntity.ok().build();
  }
}
