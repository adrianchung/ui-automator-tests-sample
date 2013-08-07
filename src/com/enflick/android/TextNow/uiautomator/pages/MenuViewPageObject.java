package com.enflick.android.TextNow.uiautomator.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.enflick.android.TextNow.uiautomator.Constants;

/**
 * A page object representing all the actions we can do with the menu
 */
public class MenuViewPageObject extends PageObjectBase {

	private UiObject mMenuHomeButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/menu_btn"));
	private UiObject mHomeButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/home_button"));
	private UiObject mProfileButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/profile_button"));
	private UiObject mStoreButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/store_button"));
	private UiObject mSettingsButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/settings_button"));
	
	public MenuViewPageObject(UiDevice device) {
		super(device);
	}

	public void openHome() throws UiObjectNotFoundException {
		navigateBackToParent();
		
		mMenuHomeButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
		mHomeButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	public void openProfile() throws UiObjectNotFoundException {
		navigateBackToParent();
		
		mMenuHomeButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
		mProfileButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	public void openSettings() throws UiObjectNotFoundException {
		navigateBackToParent();
		
		mMenuHomeButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
		mSettingsButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	public void openStore() throws UiObjectNotFoundException {
		navigateBackToParent();
		
		mMenuHomeButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
		mStoreButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	private void navigateBackToParent() throws UiObjectNotFoundException {
		// Reset back to a parent screen where the menu button is available
		while (!mMenuHomeButton.exists()) {
			UiObject backButton = new UiObject(new UiSelector().resourceId("android:id/home"));
			backButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
		}
	}
}
