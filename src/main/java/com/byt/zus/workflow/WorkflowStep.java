package com.byt.zus.workflow;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkflowStep {

    private Date date;
    private String reason;
    private StepType stepType;

}
