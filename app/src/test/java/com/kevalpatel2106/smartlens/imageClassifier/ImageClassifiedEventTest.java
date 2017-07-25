/*
 * Copyright 2017 Keval Patel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kevalpatel2106.smartlens.imageClassifier;

import com.kevalpatel2106.tensorflow.Classifier;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Keval Patel on 25/07/17.
 *
 * @author 'https://github.com/kevalpatel2106'
 */
public class ImageClassifiedEventTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void canInitialize() throws Exception {
        try {
            new ImageClassifiedEvent(null);
            fail();
        } catch (IllegalArgumentException e) {
            //Success
        }
    }

    @Test
    public void getTimeStamp() throws Exception {
        Classifier.Recognition mockRecognition = new Classifier.Recognition("1",
                "mock", 1.0f, null);
        ArrayList<Classifier.Recognition> mockList = new ArrayList<>(1);
        mockList.add(mockRecognition);
        ImageClassifiedEvent classifiedEvent = new ImageClassifiedEvent(mockList);
        assertTrue(System.currentTimeMillis() - classifiedEvent.getTimeStamp() < 100);
    }

}