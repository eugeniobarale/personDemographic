package com.persondemographic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import com.persondemographic.controller.PersonDemographicController;
import com.persondemographic.model.User;
import com.persondemographic.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonDemographicApplicationTests {
  


    @Autowired
    PersonDemographicController personDemographicController;
    @Autowired
    UserRepository userRepository;
    
    
    User user;
    Date creationDate;
    
    @Before
    public void setupData() throws ParseException{
        user=new User();
        user.setName("test");
        user.setPpsNumber("123");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        user.setDateOfBirth(sdf.parse("01/01/1970"));
        user.setCreationDate(new Date());
        personDemographicController.doCreateUser(user);
    }

    @Test
    public void testListUsers() {
        ModelAndView mav=
this.personDemographicController.listUsers(); 
        assertNotNull(mav.getModel().get("users"));
        assertEquals(mav.getViewName(),"listUsers");
        assertEquals(((List<User>) mav.getModel().get("users")).size(), 1);
        assertEquals(((List<User>) mav.getModel().get("users")).get(0).getPpsNumber(), user.getPpsNumber());
    }
    
    @Test
    public void testDuplicatePpsNumber() throws ParseException {
        user=new User();
        user.setName("test");
        user.setPpsNumber("123");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        user.setDateOfBirth(sdf.parse("01/01/1970"));
        user.setCreationDate(new Date());

    	ModelAndView mav= this.personDemographicController.doCreateUser(user);
        String error= (String) mav.getModel().get("userAlreadyRegistered");
        assertEquals(error,"PPS number is already registered");
        
    }
    
    @After
    public void cleanData() {
        userRepository.delete(user);
    }
}
    

