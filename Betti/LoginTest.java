package betti.ready4s.betti;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import betti.ready4s.betti.Models.Activity.SplashActivity;

/**
 * Created by mjbor on 20.07.2017.
 */



public class LoginTest {
    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    private String emailConstant = "michal.boryczko@ready4s.pl";
    private String passwordConstant = "testtest1";

    @Test
    public void LoginPositive(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());
        em.WaitMiliSeconds(3000);
        em.TextFieldInput("et_email", emailConstant);
        em.TextFieldInput("et_password", passwordConstant);
        em.ButtonClickByName("Sign in");
    }

    @Test
    public void LoginNegative(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());
        em.WaitMiliSeconds(3000);
        em.TextFieldInput("et_email", emailConstant);
        em.TextFieldInput("et_password", passwordConstant+"abcde");
        em.ButtonClickByName("Sign in");
        em.WaitMiliSeconds(3000);
        em.TextChecking("Invalid credentials");
    }


}
