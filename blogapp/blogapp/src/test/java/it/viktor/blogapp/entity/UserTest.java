/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.viktor.blogapp.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tss
 */
/*
public class UserTest {
    
 private Validator validator;
    Set<ConstraintViolation<User>> constraintViolations;
    
    @BeforeEach
    public void init(){
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void testNotValid() {

        User u = new User();
        
        //name
        u.setName("Name");

        constraintViolations
                = validator.validate(u);

        
        boolean anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("Name"));
        
        Assertions.assertTrue(anyMatch);
        
        //surname
        u.setSurname("Surname");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("Surname"));
                
        Assertions.assertTrue(anyMatch);
        

        //email
        u.setEmail("xx.hotmail@.it");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("xx.hotmail@.it"));
                
        Assertions.assertTrue(anyMatch);
        
        //password
        u.setPassword("123456789");
        constraintViolations
                = validator.validate(u);
        
        anyMatch = constraintViolations.stream()
                .anyMatch(v -> v.getPropertyPath().toString()
                        .equals("123456789"));
                
        Assertions.assertTrue(anyMatch);
    }
    
    @Test
    public void testValid(){
        User user = new User();
        user.setName("mario");
        Assertions.assertTrue(user.getName()!= null && user.getName().equals("mario"));
        
        user.setSurname("rossi");
        Assertions.assertTrue(user.getSurname()!= null && user.getSurname().equals("rossi"));
        
        user.setEmail("rossi@hotmail.it");
        Assertions.assertTrue(user.getEmail()!= null && user.getEmail().equals("rossi@hotmail.it"));
        
        user.setPassword("123456789");
        Assertions.assertTrue(user.getPassword()!= null && user.getPassword().equals("123456789"));
        
        constraintViolations = validator.validate(user);
        
        Assertions.assertTrue(constraintViolations.isEmpty());

    }
    
    
}
*/