package com.enflick.android.TextNow.uiautomator;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.enflick.android.TextNow.uiautomator.pages.MenuViewPageObject;

public abstract class TNUiAutomatorTestCase extends UiAutomatorTestCase {
	private UiDevice mDevice;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mDevice = getUiDevice();
		
		MenuViewPageObject menuView = new MenuViewPageObject(mDevice);
		menuView.openHome();
	}
	
	// Ensure that we are back to the initial state in the conversation view
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		
		// Reset orientation back to normal
		mDevice.setOrientationNatural();
		mDevice.unfreezeRotation();
		
		MenuViewPageObject menuView = new MenuViewPageObject(mDevice);
		menuView.openHome();
	}
	
	public UiDevice getDevice() {
		return mDevice;
	}
}
