/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.viktor.blogapp.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tss
 */
/*
public class UserTest {
    
    private Validator validator;
    
    public UserTest() {
    }
    
    @BeforeEach
    public void init() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void testNotValid(){
        
        User u = new User();
        
        // name 
        u.setName("");
        Set<ConstraintViolation<User>> constraintViolation = validator.validate(u);
        
        
    }
    
    
    
}
*/