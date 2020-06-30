package com.byt.zus;

import com.byt.zus.dao.InMemoryDaoTest;
import com.byt.zus.service.FileService;
import com.byt.zus.service.WorkflowStepService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class WorkflowStepTests extends InMemoryDaoTest {

  @Autowired
  private WorkflowStepService workflowStepService;

  @Test
  public void updateWorkflowStatus() {


  }


}
