package com.enflick.android.TextNow.uiautomator.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;

/**
 * Implementation of page object pattern to make dealing with UI pages easier
 * http://docs.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern
 * 
 * The goal here is to allow us to have a base class for methods that make it easier to interact with 
 * views in the application
 */
abstract class PageObjectBase {
	private UiDevice mDevice;
	
	public PageObjectBase(UiDevice device) {
		mDevice = device;
	}
	
	protected UiDevice getDevice() {
		return mDevice;
	}
	
	protected void enterText(UiObject textField, String text) throws UiObjectNotFoundException {
		textField.click();
		textField.setText(text);
		mDevice.pressBack();
	}
}
