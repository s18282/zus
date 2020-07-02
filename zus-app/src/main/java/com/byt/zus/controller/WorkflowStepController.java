package com.byt.zus.controller;

import com.byt.zus.dao.FileStatus;
import com.byt.zus.service.WorkflowStepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "rest/workflow")
@RequiredArgsConstructor
public class WorkflowStepController {

  private final WorkflowStepService workflowStepService;

  @PostMapping("/createNew")
  public ResponseEntity<?> createWorkflow(@RequestParam long fileId) {

    workflowStepService.createWorkflow(fileId);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/updateStatus")
  public ResponseEntity<?> updateWorkflowStatus(@RequestParam long userId,
                                                @RequestParam long fileId,
                                                @RequestParam String fileStatus) {

    workflowStepService.updateWorkflowStatus(userId, fileId, FileStatus.valueOf(fileStatus));
    return ResponseEntity.ok().build();
  }
}
