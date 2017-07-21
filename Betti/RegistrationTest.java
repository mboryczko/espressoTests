package betti.ready4s.betti;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import betti.ready4s.betti.Models.Activity.SplashActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by mjbor on 19.07.2017.
 */


public class RegistrationTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);


    @Test
    public void registrationPositive(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());

        em.WaitMiliSeconds(3000);
        em.ButtonClickById("bt_signup");

        em.TextFieldInput("et_name", "nameSample");
        em.TextFieldInput("et_surname", "surnameSample");
        em.ButtonClickById("et_birth_date");
        em.WaitMiliSeconds(40);
        //em.setDate("et_birth_date", 1990, 5, 13);
        em.ButtonClickByName("Gotowe");
        em.WaitMiliSeconds(50);
        em.TextFieldInput("et_email", "sampleEmail@gmail.com");
        em.TextFieldInput("et_password", "password1");
        em.TextFieldInput("et_password_repeat", "password1");
        em.ButtonClickById("bt_signup_signup");
        em.WaitMiliSeconds(1000);

        //em.TextChecking("Please input necessary fields");
        em.TextChecking("User successfully registered!");
    }



    @Test
    @Ignore
    public void registrationNotOldEnough(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());

        em.WaitMiliSeconds(3000);
        em.ButtonClickById("bt_signup");

        em.TextFieldInput("et_name", "nameSample");
        em.TextFieldInput("et_surname", "surnameSample");
        em.ButtonClickById("et_birth_date");
        em.WaitMiliSeconds(40);
        em.ButtonClickById("done");
        em.WaitMiliSeconds(50);
        em.TextFieldInput("et_email", "sampleEmail@gmail.com");
        em.TextFieldInput("et_password", "password1");
        em.TextFieldInput("et_password_repeat", "password1");
        em.ButtonClickById("bt_signup_signup");
        em.WaitMiliSeconds(1000);
        em.TextChecking("You must be at least 18 years old to register");
    }




}
