package com.enflick.android.TextNow.uiautomator;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.enflick.android.TextNow.uiautomator.pages.ConversationViewPageObject;
import com.enflick.android.TextNow.uiautomator.pages.MessageViewPageObject;

public class MessageTests extends TNUiAutomatorTestCase {	
	private static final String TEXTNOW_ACCOUNT = "adrianchung2@textnow.me";
	
	private UiDevice mDevice;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mDevice = getDevice();
	}
	
	public void testSendNewMessage() throws UiObjectNotFoundException {
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openNewChat();
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendNewMessage(TEXTNOW_ACCOUNT, "testSendMessage");
	} 
	
	public void testSendExistingMessage() throws UiObjectNotFoundException {
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openExistingChat(TEXTNOW_ACCOUNT);
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendMessage("testSendExistingMessage");
	}
	
	public void testSendNewMessageLandscape() throws RemoteException, UiObjectNotFoundException {
		mDevice.setOrientationRight();
		
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openNewChat();
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendNewMessage("adrianchung2@textnow.me", "testSendMessageLandscape");
	}
}
