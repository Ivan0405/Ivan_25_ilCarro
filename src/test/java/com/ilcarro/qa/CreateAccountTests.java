package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //precondition: user shod be logged out
    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){ //sing Up not present
            click(By.xpath("//a[contains(., 'logOut')]"));
        }
              //click on logout button
    }
    @Test
    public void testSingUp(){
        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));


        //fill registration form
        type(By.cssSelector("#first_name"), "AS");
        type(By.cssSelector("#second_name"),"FV");
        type(By.cssSelector("#email"),"aa@bb109.com");
        type(By.cssSelector("#password"),"1Aaaaaaaa");



        click(By.cssSelector("#check_policy"));

        //click submit button
        click(By.cssSelector("[type='submit']"));

        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());
    }


}
