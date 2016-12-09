package com.capricorn.ResponseController;

import xml.Message;
/**Method of exception handling with condition no response. */
public final class EmptyHandler extends ControllerChain {
/**Override the function about process.*/
	@Override
	public boolean process(Message response) {
		System.err.println("Not Handled:" + response);
		return true;
	}

}
