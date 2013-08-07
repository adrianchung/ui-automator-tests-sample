#!/bin/bash

TEST_NAME=$1
JAR_NAME=TextNowUiAutomatorTests.jar
adb push bin/$JAR_NAME /data/local/tmp

if [ -z "$TEST_NAME" ] ; then
    adb shell uiautomator runtest $JAR_NAME -c com.enflick.android.TextNow.uiautomator.MessageTests
else
    adb shell uiautomator runtest $JAR_NAME -c com.enflick.android.TextNow.uiautomator.MessageTests#$TEST_NAME
fi
