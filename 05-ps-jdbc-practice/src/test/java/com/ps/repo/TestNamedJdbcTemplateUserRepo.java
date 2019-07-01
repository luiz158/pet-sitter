package com.ps.repo;

import com.ps.config.AppConfig;
import com.ps.config.TestDataConfig;
import com.ps.ents.User;
import com.ps.repos.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by iuliana.cosmina on 6/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataConfig.class, AppConfig.class})
@ActiveProfiles("dev")
public class TestNamedJdbcTemplateUserRepo {

    @Autowired
    @Qualifier("userNamedTemplateRepo")
    UserRepo userRepo;

    @Before
    public void setUp() {
        assertNotNull(userRepo);
    }

    @Test
    public void testFindById() {
        User user = userRepo.findById(1L);
        assertEquals("John", user.getUsername());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testNoFindById() {
        User user = userRepo.findById(99L);
        assertEquals("John", user.getUsername());
    }

    @Test
    public void testFindAll() {
        final Set<User> all = userRepo.findAll();
        final int count = userRepo.countUsers();
        assertFalse(all.isEmpty());
        assertEquals(4, all.size());
        assertEquals(4, count);
    }

    @Test
    public void testCreateUser() {
        int result  = userRepo.createUser(999L, "Dima", "mypass", "d@opympus.com");
        assertEquals(1, result);
    }

    @Test
    public void testUpdate(){
        int result  = userRepo.updatePassword(1009L, "newp8989ass");
        assertEquals(0, result);
    }

    @Test
    public void testDelete(){
        int result  = userRepo.deleteById(1L);
        assertEquals(1, result);
    }

    @Test
    @Sql(statements = {"drop table NEW_P_USER if exists;"})
    public void testCreateTable(){
        int result  = userRepo.createTable("new_p_user");
        // table exists but is empty
        assertEquals(0, result);
    }


}
