package com.byt.zus.domain;

import com.byt.zus.util.WorkflowUtils;
import com.byt.zus.workflow.WorkflowStep;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.net.URI;
import java.util.Collection;

@Getter
@Setter
public class ZusFile extends File {

    private Collection<WorkflowStep> workflowSteps;
    private FileStatus fileStatus;

    public ZusFile(String pathname) {
        super(pathname);
    }

    public ZusFile(String parent, String child) {
        super(parent, child);
    }

    public ZusFile(File parent, String child) {
        super(parent, child);
    }

    public ZusFile(URI uri) {
        super(uri);
    }

    public void addWorkflowStep(WorkflowStep workflowStep) {
        workflowSteps.add(workflowStep);
        fileStatus = WorkflowUtils.translateWorkflowStepToFileStatus(workflowStep.getStepType());
    }
}
