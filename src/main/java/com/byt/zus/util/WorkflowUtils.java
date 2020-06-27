package com.byt.zus.util;

import com.byt.zus.domain.FileStatus;
import com.byt.zus.workflow.StepType;

public class WorkflowUtils {

    public static FileStatus translateWorkflowStepToFileStatus(StepType stepType) {
        return switch (stepType) {
            case ADD -> FileStatus.NEW;
            case SUBMIT -> FileStatus.SUBMITTED;
            case APPROVE -> FileStatus.APPROVED;
            case DENY -> FileStatus.DENIED;
            case EDIT -> FileStatus.IN_EDIT;
            case PUBLISH -> FileStatus.PUBLISHED;
        };
    }

}
