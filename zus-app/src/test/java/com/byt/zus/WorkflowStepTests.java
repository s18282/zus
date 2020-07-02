package com.byt.zus;

import com.byt.zus.dao.FileStatus;
import com.byt.zus.dao.InMemoryDaoTest;
import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.dao.tables.pojos.WorkflowStep;
import com.byt.zus.service.FileService;
import com.byt.zus.service.UserService;
import com.byt.zus.service.WorkflowStepService;
import io.vavr.collection.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WorkflowStepTests extends InMemoryDaoTest {

  @Autowired
  private FileService fileService;

  @Autowired
  private UserService userService;

  @Autowired
  private WorkflowStepService workflowStepService;

  @Test
  public void shouldCreateWorkflowStep() {

    //given
    final Long file_id = fileService.insertIntoReturningId("example_url");
    userService.insertIntoReturningId(new User(2L, "Janusz", "Krzak", true, UserStatus.USER));

    //when
    workflowStepService.createWorkflow(file_id);

    //then
    List<WorkflowStep> workflowStep = workflowStepService.findAllByFileId(file_id);
    assertEquals(FileStatus.NEW, workflowStep.get().getFileStatus());
  }

  @Test
  public void shouldUpdateWorkflowStatus() {

    //given
    final Long file_id = fileService.insertIntoReturningId("example_url");
    final Long user_id = userService.insertIntoReturningId(new User(2L, "Janusz", "Krzak", true, UserStatus.USER));

    //when
    workflowStepService.createWorkflow(file_id);
    workflowStepService.updateWorkflowStatus(user_id, file_id, FileStatus.PENDING);

    //then
    List<WorkflowStep> workflowStep = workflowStepService.findAllByFileId(file_id);
    assertEquals(FileStatus.NEW, workflowStep.get(0).getFileStatus());
    assertEquals(FileStatus.PENDING, workflowStep.get(1).getFileStatus());
  }
}
