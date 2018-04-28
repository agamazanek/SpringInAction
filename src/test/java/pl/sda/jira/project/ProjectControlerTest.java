package pl.sda.jira.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jira-sda-app.xml")
public class ProjectControlerTest {
    @Autowired private ProjectControler projectControler;
    @Autowired private TeamStorage andrzeje;

    @Test
    public void shouldReturnTrueIfTeamHasGotAProject(){
//        TeamStorage andrzeje = new TeamStorage();
//        ProjectControler projectControler = new ProjectControler(andrzeje);
        String teamId = "";

        projectControler.existsFor(teamId);

        assertTrue(andrzeje.isTeamExist());
    }


}