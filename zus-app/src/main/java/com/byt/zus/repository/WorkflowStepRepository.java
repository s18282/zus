package com.byt.zus.repository;

import com.balaur.zus.dao.tables.daos.WorkflowStepDao;
import com.balaur.zus.dao.tables.pojos.WorkflowStep;
import io.vavr.collection.List;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.zus.dao.tables.WorkflowStep.WORKFLOW_STEP;

public class WorkflowStepRepository extends WorkflowStepDao {

  private final DefaultDSLContext dsl;

  public WorkflowStepRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public List<WorkflowStep> findAllByFileId(final long fileId) {

    return List.ofAll(dsl.select()
                         .from(WORKFLOW_STEP)
                         .where(WORKFLOW_STEP.FILE_ID.eq(fileId))
                         .orderBy(WORKFLOW_STEP.DATE)
                         .fetchInto(WorkflowStep.class));
  }
}
