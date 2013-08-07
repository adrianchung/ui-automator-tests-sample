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

	public ConversationViewPageObject(UiDevice device) {
		super(device);
	}
	
	public void openNewChat() throws UiObjectNotFoundException {
		newChatButton.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
	
	public void openExistingChat(String displayName) throws UiObjectNotFoundException {
		UiScrollable conversationsList = new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject about = conversationsList.getChildByText(new UiSelector().className("android.widget.TextView"), displayName);
		about.clickAndWaitForNewWindow(Constants.TIMEOUT_IN_MS);
	}
}
