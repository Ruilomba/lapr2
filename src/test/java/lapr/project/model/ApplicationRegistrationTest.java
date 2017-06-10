/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.Asserts;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author RuiSL
 */
public class ApplicationRegistrationTest {
    @Test
    public void newApplicationTest(){
        List<FAERating> faeRatings= new ArrayList<>();
        List<Keyword> keywords= new ArrayList<>();
        String description="Loja de torrados da sarinha";
        String adress= "Torrados";
        String companyName="LojaDaSarinha"; 
        int intendedBoothArea=100;
        int inviatation=50;
        String phone="915100586";
        Application expectedA= new Application(faeRatings,description, 
                keywords, adress, companyName, 
                intendedBoothArea, inviatation,phone);
        ApplicationRegistration apRegister= new ApplicationRegistration();
        Application a=apRegister.newApplication(faeRatings, description, keywords, adress, companyName, intendedBoothArea, inviatation, phone);
        assertEquals(expectedA, a);
    }
    
    @Test
    public void addAplicationTest(){
        Application a=new Application();
        a.setDescription("eventoNulo");
        ApplicationRegistration register= new ApplicationRegistration();
        register.addApplication(a);
        boolean test=false;
        for(Application ap:register.getApplicationListElements()){
            if(Objects.equal(a, ap)){
                test=true;
            }
        }
        assertEquals(true,test);
    }
    @Test
    public void isEmptyTest(){
        ApplicationRegistration register= new ApplicationRegistration();
        boolean answer=register.isEmpty();
        assertEquals(true, answer);
    }
    @Test
    public void hasApplicationTest(){
        Application a=new Application();
        a.setDescription("eventoNulo");
        ApplicationRegistration register= new ApplicationRegistration();
        register.addApplication(a);
        boolean answer=register.hasApplication(a);
        assertEquals(true, answer);
    }
    @Test
    public void validatesApplicationTest(){
        Application a=new Application();
        a.setDescription("eventoNulo");
        ApplicationRegistration register= new ApplicationRegistration();
        register.addApplication(a);
        boolean answer=register.validateApplication(a);
        assertEquals(false, answer);
    }
}
