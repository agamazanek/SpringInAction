package com.smalaca.project;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectControlerTest {

    @Test
    public void shouldReturnTrueIfTeamHasGotAProject(){
        TeamStorage andrzeje = new TeamStorage();
        ProjectControler projectControler = new ProjectControler(andrzeje);

        assertTrue(andrzeje.isTeamExist());
    }


}