package com.capricorn.controller;

import xml.Message;

public abstract class ControllerChain {

	/** Next one in the chain. Once null is reached, done. */

	
	/** 
	 * Carry out the processing. 
	 */
	public abstract boolean process(Message response);

}