package com.kevalpatel2106.smartlens.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.kevalpatel2106.smartlens.testUtils.BaseTestClass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Keval on 19-Jul-17.
 */
@RunWith(AndroidJUnit4.class)
public class BaseEditTextTest extends BaseTestClass {
    private BaseEditText mBaseEditText;

    @Before
    public void setUp() throws Exception {
        mBaseEditText = new BaseEditText(InstrumentationRegistry.getTargetContext());
        mBaseEditText.setText("");
    }

    @Test
    public void getTrimmedText() throws Exception {
        String testVal = "123456789 ";

        //Check for the text
        mBaseEditText.setText(testVal);
        assertTrue(mBaseEditText.getTrimmedText().equals(testVal.trim()));

        //Check for the hint.
        mBaseEditText.setText("");
        mBaseEditText.setHint(testVal);
        assertTrue(mBaseEditText.getTrimmedText().length() == 0);
    }

    @SuppressLint("SetTextI18n")
    @Test
    public void isEmpty() throws Exception {
        //Real empty
        mBaseEditText.setText("");
        assertTrue(mBaseEditText.isEmpty());

        //Spaces
        mBaseEditText.setText("     ");
        assertTrue(mBaseEditText.isEmpty());

        //Texts
        mBaseEditText.setText("72354");
        assertFalse(mBaseEditText.isEmpty());
    }

    @Test
    public void clear() throws Exception {
        assertTrue(mBaseEditText.getText().length() == 0);
    }

    @Override
    public Activity getActivity() {
        return null;
    }
}