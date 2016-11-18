package com.capricorn.RequestController;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.RequestController.IClientController;

import xml.Message;

public abstract class ControllerChain implements IClientController{

	/** Next one in the chain. Once null is reached, done. */

	
	/** Next one in the chain. Once null is reached, done. */
	public IClientController next = null;
	
	/** Terminal entry in the chain. */
	protected ControllerChain() {
		
	}
	
	/** Chain together. */
	protected ControllerChain(ControllerChain next) {
		this.next = next;
	}
	
	/** 
	 * Carry out the processing. 
	 */
	public abstract boolean process(Message response);

}