package com.networks.test.esi;


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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.textInputEditTextEmail),
                        childAtPosition(
                                allOf(withId(R.id.container_email_login),
                                        childAtPosition(
                                                withId(R.id.login_constraint1),
                                                0)),
                                0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.textInputEditTextEmail),
                        childAtPosition(
                                allOf(withId(R.id.container_email_login),
                                        childAtPosition(
                                                withId(R.id.login_constraint1),
                                                0)),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("ju@helitoptero.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.textInputEditTextEmail), withText("ju@helitoptero.com"),
                        childAtPosition(
                                allOf(withId(R.id.container_email_login),
                                        childAtPosition(
                                                withId(R.id.login_constraint1),
                                                0)),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(pressImeActionButton());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.textInputEditTextPassword),
                        childAtPosition(
                                allOf(withId(R.id.container_senha_login),
                                        childAtPosition(
                                                withId(R.id.login_constraint1),
                                                1)),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.textInputEditTextPassword), withText("12345"),
                        childAtPosition(
                                allOf(withId(R.id.container_senha_login),
                                        childAtPosition(
                                                withId(R.id.login_constraint1),
                                                1)),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.appCompatButtonLogin), withText("Entrar"),
                        childAtPosition(
                                allOf(withId(R.id.login_constraint1),
                                        childAtPosition(
                                                withId(R.id.nestedScrollView),
                                                1)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.bot_perf_inicio), withText("Perfil"),
                        childAtPosition(
                                allOf(withId(R.id.inicio_container1),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.nome_id), withText("Juscelena"),
                        childAtPosition(
                                allOf(withId(R.id.container_foto_nome),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("Juscelena")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.cargo_id), withText("Gerente"),
                        childAtPosition(
                                allOf(withId(R.id.container_cargo),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Gerente")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.email_id), withText("ju@helitoptero.com"),
                        childAtPosition(
                                allOf(withId(R.id.container_email),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                2)),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("ju@helitoptero.com")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.nascimento_id), withText("09/05/1992"),
                        childAtPosition(
                                allOf(withId(R.id.container_idade),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                3)),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("09/05/1992")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.endereco_id), withText("Rua Um nº 1 - Centro"),
                        childAtPosition(
                                allOf(withId(R.id.container_endereco),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                4)),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Rua Um nº 1 - Centro")));

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
