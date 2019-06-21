package com.ps.services;

import com.ps.base.PetType;
import com.ps.base.UserType;
import com.ps.config.AppConfig;
import com.ps.config.TestDataConfig;
import com.ps.ents.Pet;
import com.ps.ents.User;
import com.ps.repos.UserRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ps.util.RecordBuilder.buildUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by iuliana.cosmina on 7/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataConfig.class, AppConfig.class})
@ActiveProfiles("dev")
@Transactional
public class TestUserService {

    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;


    @Before
    public void setUp() {
        assertNotNull(userService);
        userService.create("john.cusack@pet.com", "test", UserType.OWNER);
    }

    @BeforeTransaction
    public void checkDbInit() {
        long count = userService.countUsers();
        assertEquals(1, count);
    }

    @Test
    public void testFindById() {
        // TODO: 21.06.2019 make it pass
        User user = userService.findById(1L);
        assertNotNull(user);
    }

//    @After
//    public void cleanUp() {
//        List<User> users = userRepo.findAll();
//        for (User u : users) {
//            userRepo.deleteById(u.getId());
//        }
//    }
}
