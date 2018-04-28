package pl.sda.jira.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProjectControlerTest {

    @Autowired private ProjectControler projectControler;
    @Autowired private TeamStorage andrzeje;

    @Test
    
    public void shouldReturnTrueIfTeamHasGotAProject(){

        String teamId = "";

        projectControler.existsFor(teamId);

        assertTrue(andrzeje.isTeamExist());

    }

    @Test
    public void shouldReturnFalseIfProjectHasNoTeam()  {

        projectControler.existsFor(null);

        assertFalse(andrzeje.isTeamExist());
    }
}