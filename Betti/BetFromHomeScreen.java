package betti.ready4s.betti;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import betti.ready4s.betti.Models.Activity.SplashActivity;


/**
 * Created by mjbor on 21.07.2017.
 */



public class BetFromHomeScreen {

    private String emailConstant = "michal.boryczko@ready4s.pl";
    private String passwordConstant = "testtest1";

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void makeBetFromHomeScreen(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());
        em.WaitMiliSeconds(3000);
        em.TextFieldInput("et_email", emailConstant);
        em.TextFieldInput("et_password", passwordConstant);
        em.ButtonClickByName("Sign in");
        em.WaitMiliSeconds(5000);
        //user is logged in

        em.ButtonClickById("price");
        em.ButtonClickById("noButton");
        em.scrollToAndClick("price");
        em.ButtonClickById("buttonok");
        em.scrollToAndClick("btnBid");
    }

    @Test
    public void makeBetFromAddPublicBet(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());
        em.WaitMiliSeconds(3000);
        em.TextFieldInput("et_email", emailConstant);
        em.TextFieldInput("et_password", passwordConstant);
        em.ButtonClickByName("Sign in");
        em.WaitMiliSeconds(5000);
        //user is logged in

        //zakladka add public bet
        em.ButtonClickById("add_public");
        em.WaitMiliSeconds(3000);
        em.ClickOnChild("listview", 0);
        em.WaitMiliSeconds(3000);
        em.ClickOnChild("listview", 0);
        em.WaitMiliSeconds(3000);
        em.checkTextOnElement("navbar_title", "Bet Details");

        em.ButtonClickById("noButton");
        em.scrollToAndClick("price");
        em.ButtonClickById("buttonok");
        em.scrollToAndClick("btnBid");
    }

    @Test
    public void makeBetFromAddPrivateBet(){
        EspressoMethods em = new EspressoMethods(mActivityTestRule.getActivity());
        em.WaitMiliSeconds(3000);
        em.TextFieldInput("et_email", emailConstant);
        em.TextFieldInput("et_password", passwordConstant);
        em.ButtonClickByName("Sign in");
        em.WaitMiliSeconds(5000);
        //user is logged in

        //zakladka add public bet
        em.ButtonClickById("add_private");
        em.WaitMiliSeconds(3000);

        em.TextFieldInput("txt_bet_title", "bet title sample");
        em.TextFieldInput("txt_bet_desc", "bet description sample");
        em.TextFieldInput("txt_bet_amount", "10");
        em.scrollToElement("txt_bet_amount");
        em.ButtonClickById("bt_no");
        em.ButtonClickById("txt_bet_date");
        em.WaitMiliSeconds(50);
        em.ButtonClickById("done");
        em.ButtonClickById("bt_create_bet");


    }


}
