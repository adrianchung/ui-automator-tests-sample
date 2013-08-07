ui-automator-tests-sample
=========================

This is are some sample tests I wrote for the TextNow application using Android's UI
Automator framework. It will only run on Android 4.3+, as http://developer.android.com/tools/help/uiautomator/UiSelector.html#resourceId(java.lang.String) makes it really handy to locate items to click a lot easier.

To run:
* ant build
* ./deploy.sh

Note the handiness of the page object pattern used. What it allows us to do is allow us to 
perform actions based on views in the Android application rather than have all the logic mixed
into the tests. 

MessageTests.java illustrates how we can write UI automation tests in both portrait and landscape
mode so that all of our bases are covered. In order to figure out the resourceIds in the 
UISelectors, we need to boot up uiautomatorviewer, provided as part of the Android SDK tools. 

Have a look at http://www.youtube.com/watch?v=_SlBHUW0ybM for a brief introduction to UI Automator
and how you can use it to make your life easier!
