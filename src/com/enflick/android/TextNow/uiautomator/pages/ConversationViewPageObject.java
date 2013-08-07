package com.enflick.android.TextNow.uiautomator.pages;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.enflick.android.TextNow.uiautomator.Constants;

/**
 * A page object representing interactions in the conversation view
 */
public class ConversationViewPageObject extends PageObjectBase {
	private UiObject newChatButton = new UiObject(new UiSelector().resourceId("com.enflick.android.TextNow:id/menu_new_chat"));

	/**
	 * Constructor
	 * 
	 * @param device
	 */
	public ConversationViewPageObject(UiDevice device) {
		super(device);
	}
	
	/**
	 * Open a new conversation by clicking on the new chat button in the conversation view
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void openNewChat() throws UiObjectNotFoundException {
		newChatButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	/**
	 * Open an existing conversation by clicking on the entry in the conversation list
	 * 
	 * @param displayName The display name of the entry to click
	 * @throws UiObjectNotFoundException
	 */
	public void openExistingChat(String displayName) throws UiObjectNotFoundException {
		UiScrollable conversationsList = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject about = conversationsList.getChildByText(new UiSelector().className("android.widget.TextView"), displayName);
		about.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
}
