package com.enflick.android.TextNow.uiautomator;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.enflick.android.TextNow.uiautomator.pages.ConversationViewPageObject;
import com.enflick.android.TextNow.uiautomator.pages.MessageViewPageObject;

/**
 * A test suite used to ensure that we can send messages to a sample recipient.
 * It is assumed that the user is logged into his or her TextNow account. 
 */
public class MessageTests extends TNUiAutomatorTestCase {	
	/**
	 * Sample TextNow account to send messages to
	 */
	private static final String TEXTNOW_ACCOUNT = "adrianchung2@textnow.me";
	
	private UiDevice mDevice;
	
	/**
	 * @see TNUiAutomatorTestCase
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mDevice = getDevice();
	}
	
	/**
	 * Test sending a new message by clicking on the new chat button, entering the contact's
	 * TextNow e-mail address and sending a message.
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testSendNewMessage() throws UiObjectNotFoundException {
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openNewChat();
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendNewMessage(TEXTNOW_ACCOUNT, "testSendMessage");
	} 
	
	/**
	 * Test sending a message to an existing conversation. It is assumed that there is already
	 * a conversation going with TEXTNOW_ACCOUNT.
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void testSendExistingMessage() throws UiObjectNotFoundException {
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openExistingChat(TEXTNOW_ACCOUNT);
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendMessage("testSendExistingMessage");
	}
	
	/**
	 * Test sending a new message in landscape orientation by clicking on the new chat button, 
	 * entering the contact's TextNow e-mail address and sending a message.
	 *  
	 * @throws RemoteException
	 * @throws UiObjectNotFoundException
	 */
	public void testSendNewMessageLandscape() throws RemoteException, UiObjectNotFoundException {
		mDevice.setOrientationRight();
		
		ConversationViewPageObject conversationView = new ConversationViewPageObject(mDevice);
		conversationView.openNewChat();
		
		MessageViewPageObject messageView = new MessageViewPageObject(mDevice);
		messageView.sendNewMessage("adrianchung2@textnow.me", "testSendMessageLandscape");
	}
}
