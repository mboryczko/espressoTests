package betti.ready4s.betti.Models.Activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import betti.ready4s.betti.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class alotof {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void alotof() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction bettiEditText = onView(
                allOf(withId(R.id.et_email), isDisplayed()));
        bettiEditText.perform(click());

        ViewInteraction bettiEditText2 = onView(
                allOf(withId(R.id.et_email), isDisplayed()));
        bettiEditText2.perform(replaceText("michal.boryczko@ready4s.pl"), closeSoftKeyboard());

        ViewInteraction bettiEditText3 = onView(
                allOf(withId(R.id.et_password), isDisplayed()));
        bettiEditText3.perform(replaceText("testtest1"), closeSoftKeyboard());

        ViewInteraction bettiButton = onView(
                allOf(withId(R.id.bt_signin), withText("Sign in"), isDisplayed()));
        bettiButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.price), withText("£50"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView.check(matches(withText("£50")));

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        withId(R.id.listview),
                        0),
                        isDisplayed()));
        relativeLayout.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.noButton),
                        withParent(withId(R.id.linearno))));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.price), withText("£0")));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonok), withText("Ok"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnBid), withText("Bet")));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("Ok")));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.add_private),
                        withParent(withId(R.id.private_parent)),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction relativeLayout2 = onView(
                withId(R.id.camera_layout));
        relativeLayout2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.txt_bet_title));
        appCompatEditText.perform(scrollTo(), click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.txt_bet_title));
        appCompatEditText2.perform(scrollTo(), replaceText("hhh"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.txt_bet_title), withText("hhh")));
        appCompatEditText3.perform(scrollTo(), replaceText("hhhhh"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.txt_bet_desc));
        appCompatEditText4.perform(scrollTo(), replaceText("gff"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.txt_bet_desc), withText("gff")));
        appCompatEditText5.perform(scrollTo(), replaceText("gfffff"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                withId(R.id.txt_bet_amount));
        appCompatEditText6.perform(scrollTo(), replaceText("5"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.bt_no), isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                withId(R.id.txt_bet_date));
        appCompatEditText7.perform(scrollTo(), click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.done), withText("Gotowe"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.bt_create_bet), withText("Create bet")));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(android.R.id.button1), withText("Ok")));
        appCompatButton6.perform(scrollTo(), click());





        /*
        PUBLIC BET ZAKLADKA
         */


        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.add_public),
                        withParent(withId(R.id.public_parent)),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction relativeLayout3 = onView(
                allOf(childAtPosition(
                        withId(R.id.listview),
                        0),
                        isDisplayed()));
        relativeLayout3.perform(click());

        ViewInteraction relativeLayout4 = onView(
                allOf(childAtPosition(
                        withId(R.id.listview),
                        0),
                        isDisplayed()));
        relativeLayout4.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.navbar_title), withText("Bet Details"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.app_bar),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Bet Details")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
