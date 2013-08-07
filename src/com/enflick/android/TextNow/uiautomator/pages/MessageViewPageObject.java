package com.enflick.android.TextNow.uiautomator.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.enflick.android.TextNow.uiautomator.Constants;

/**
 * A page object handling interactions with the message view fragment
 */
public class MessageViewPageObject extends PageObjectBase {
	private UiObject toTextField = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/to_view"));
	private UiObject messageEditTextField = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/edit_text_out"));
	private UiObject sendButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/button_send"));
	
	public MessageViewPageObject(UiDevice device) {
		super(device);
	}
	
	/**
	 * Send a new message to a recipient
	 * 
	 * @param to
	 * @param message
	 * @throws UiObjectNotFoundException
	 */
	public void sendNewMessage(String to, String message) throws UiObjectNotFoundException {
		enterText(toTextField, to);
		sendMessage(message);
	}
	
	/**
	 * Send a message in an existing conversation
	 * 
	 * @param message
	 * @throws UiObjectNotFoundException
	 */
	public void sendMessage(String message) throws UiObjectNotFoundException {
		enterText(messageEditTextField, message);
		
		sendButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
}
