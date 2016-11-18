package com.capricorn.RequestController;

import xml.Message;

public final class EmptyHandler extends ControllerChain {

	@Override
	public boolean process(Message response) {
		System.err.println("Not Handled:" + response);
		return true;
	}

}
