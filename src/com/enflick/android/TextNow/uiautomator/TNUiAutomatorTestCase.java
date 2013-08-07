package com.enflick.android.TextNow.uiautomator;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.enflick.android.TextNow.uiautomator.pages.MenuViewPageObject;

/**
 * Base test case providing helper methods required for getting the application
 * set up to its root view. In this case, we will assume that the user is signed
 * into the application and the root view is the conversation view.
 * 
 * Default implementations of setUp() and tearDown() will  
 */
public abstract class TNUiAutomatorTestCase extends UiAutomatorTestCase {
	private UiDevice mDevice;
	
	/**
	 * Ensures that the application starts off on the home screen
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mDevice = getUiDevice();
		
		MenuViewPageObject menuView = new MenuViewPageObject(mDevice);
		menuView.openHome();
	}
	
	/**
	 * Ensure that we clean up and are back to the home screen. Also reset 
	 * any orientation changes that may have been set by tests
	 */
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		
		// Reset orientation back to normal
		mDevice.setOrientationNatural();
		mDevice.unfreezeRotation();
		
		MenuViewPageObject menuView = new MenuViewPageObject(mDevice);
		menuView.openHome();
	}
	
	/**
	 * Get the device object
	 * 
	 * @return The device
	 */
	public UiDevice getDevice() {
		return mDevice;
	}
}
