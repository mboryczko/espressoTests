package betti.ready4s.betti;

import android.app.Activity;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import android.app.DatePickerDialog;

import betti.ready4s.betti.Controller.Core.BDatePicker;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by Bartek on 19.04.2017.
 */

public class EspressoMethods {
    private static Activity activity;
    public EspressoMethods (Activity current)
    {
        this.activity = current;
    }

    private static Activity getActivityInstance() {
        Activity currentActivity;
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()) {
                    activity = (Activity) resumedActivities.iterator().next();
                }
            }
        });

        return activity;
    }

    public static void Setup()
    {
        activity = getActivityInstance();
        EspressoMethods em = new EspressoMethods(activity);
    }

    public void TextFieldInput(String fieldName, String input)
    {
        int resID = GetIdResource(fieldName);
        onView(withId(resID)).check(matches(isDisplayed())).perform(typeText(input), closeSoftKeyboard());
    }

    public void TextFieldInputSameId(String fieldName, String realName, String input){
        int resID = GetIdResource(fieldName);
        onView(allOf(withId(resID), hasSibling(withText(realName)))).perform(typeText(input), closeSoftKeyboard());
    }

    public void PressBackButton()
    {
        pressBack();
    }

    public void ClearTextField(String fieldName)
    {
        int resID = GetIdResource(fieldName);
        onView(withId(resID)).check(matches(isDisplayed())).perform(clearText(), closeSoftKeyboard());
    }

    public void ClearTextFieldSameId(String fieldName, String realName){
        int resID = GetIdResource(fieldName);
        onView(allOf(withId(resID), hasSibling(withText(realName)))).perform(clearText(), closeSoftKeyboard());
    }

    public void OpenNavigationBarOverFlowMenu()
    {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
    }

    public void ButtonClickById(String fieldName) {
        int resID = GetIdResource(fieldName);
        ViewInteraction imageView = onView(allOf(withId(resID),isDisplayed()));
        imageView.check(matches(isDisplayed())).perform(click());
    }

    public void ButtonClickBySameId(String fieldName, String realName){
        int resID = GetIdResource(fieldName);
        onView(allOf(withId(resID), hasSibling(withText(realName)))).perform(click());
    }

    public void ButtonClickByName(String fieldName) {
        ViewInteraction imageView = onView(allOf(withText(fieldName),isDisplayed()));
        imageView.check(matches(isDisplayed())).perform(click());
    }

    public void CheckToast (String toast_text)
    {
        onView(withText(toast_text))
                .inRoot(withDecorView(not(is(activity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    public void WaitMiliSeconds(int miliseconds)
    {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private int GetStringResource(String fieldName)
    {
        int resID = activity.getResources().getIdentifier(fieldName, "string",  activity.getPackageName());
        return resID;
    }
    private int GetDrawableResource(String fieldName)
    {
        int resID = activity.getResources().getIdentifier(fieldName, "drawable",  activity.getPackageName());
        return resID;
    }
    private static int GetIdResource(String fieldName)
    {
        int resID = activity.getResources().getIdentifier(fieldName, "id",  activity.getPackageName());
        return resID;
    }

    public static void CheckTextInHint(String fieldName, String fieldString)
    {
        int resID = GetIdResource(fieldName);
        onView(withId(resID)).check(matches(withHint(fieldString)));
    }

    public static void CheckIfTextDisplayed(String fieldString)
    {
        onView(withText(fieldString)).check(matches(isDisplayed()));
    }
    public void ClickOnChild(String parentContainer, Integer childNumber)
    {
        int resID = GetIdResource(parentContainer);
        onView(nthChildOf(withId(resID), childNumber)).check(matches(isDisplayed())).perform(click());
    }


    //---------------------------------------------------------------------------dodane-------------------------------------------------------------------------------

    public void SwipeLeftByName(String fieldName){
        ViewInteraction swipeLeft = onView(allOf(withText(fieldName), isDisplayed()));
        swipeLeft.perform(swipeLeft());
    }

    public void SwipeRightByName(String fieldName){
        ViewInteraction swipeRight = onView(allOf(withText(fieldName), isDisplayed()));
        swipeRight.perform(swipeRight());
    }

    public void SwipeUpByName(String fieldName){
        ViewInteraction swipeUp = onView(allOf(withText(fieldName), isDisplayed()));
        swipeUp.perform(swipeUp());
    }

    public void SwipeDownByName(String fieldName){
        ViewInteraction swipeDown = onView(allOf(withText(fieldName), isDisplayed()));
        swipeDown.perform(swipeDown());
    }

    public void SwipeUpById(String fieldName) {
        int resID = GetIdResource(fieldName);
        ViewInteraction swipeUpById = onView(allOf(withId(resID),isDisplayed()));
        swipeUpById.perform(swipeUp());
    }

    public void SwipeDownById(String fieldName) {
        int resID = GetIdResource(fieldName);
        ViewInteraction swipeDownById = onView(allOf(withId(resID),isDisplayed()));
        swipeDownById.perform(swipeUp());
    }

    public void TextChecking(String fieldName) {
        ViewInteraction imageView = onView(allOf(withText(fieldName),isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

    public void ScrollBar(String fieldName, String number){
        int resID = GetIdResource(fieldName);
        ViewInteraction scroll = onView(allOf(withId(resID), withText(number),isDisplayed()));
        scroll.perform(click());
    }

    public void IsEnable(String fieldName){
        int resID = GetIdResource(fieldName);
        onView(withId(resID)).check(matches(isEnabled()));
    }

    public void IsNotEnable(String fieldName){
        int resID = GetIdResource(fieldName);
        onView(withId(resID)).check(matches(not(isEnabled())));
    }

    //---------------------------------------------------------------------------dodane-------------------------------------------------------------------------------


    //-------------------------------------------------------------------------michal---------------------------------------

    public static void setDate(String fieldName, int year, int monthOfYear, int dayOfMonth) {

        int resID = GetIdResource(fieldName);

        //onView(withId(resID)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
        //onView(withId(android.R.id.button1)).perform(click());
    }

    public void assertTextDoesNotExist(String fieldName) {
        ViewInteraction imageView = onView(withText(fieldName));
        imageView.check(doesNotExist());
    }

    public void scrollToElement(String fieldName){
        int resID = GetIdResource(fieldName);
        onView(allOf(withId(resID))).perform(scrollTo());
    }

    public void scrollToAndClick(String fieldName){
        int resID = GetIdResource(fieldName);
        onView(allOf(withId(resID))).perform(scrollTo(), click());
    }


    public void clickOnChild(String parentFieldName, int childPosition){
        int parentResourceId = GetIdResource(parentFieldName);

        onView(allOf(childAtPosition(withId(parentResourceId), 0))).perform(click());
    }

    public void checkTextOnElement(String fieldName, String expectedText){
        int resID = GetIdResource(fieldName);
        ViewInteraction viewInteraction = onView(allOf(withId(resID)));
        viewInteraction.check(matches(withText(expectedText)));
    }

        //----------------------------------------------------------------------------------------------------------------------



    /*CusomMatchers*/

    public Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with "+childPosition+" child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
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
