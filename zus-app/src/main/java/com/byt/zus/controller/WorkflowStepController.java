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

  @PostMapping("/updateStatus")
  public ResponseEntity<?> updateWorkflowStatus(@RequestParam long fileId,
                                        @RequestParam String fileStatus) {

    workflowStepService.updateWorkflowStatus(fileId, FileStatus.valueOf(fileStatus));
    return ResponseEntity.ok().build();
  }
}
