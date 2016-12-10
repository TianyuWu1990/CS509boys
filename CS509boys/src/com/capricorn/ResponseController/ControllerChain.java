package com.capricorn.ResponseController;

import com.capricorn.ResponseController.ControllerChain;

import xml.Message;
/**Form an abstract class ControllerChain without main method implement the interface IClientController.
 * @author Chen Li, Tianyu Wu
 */
public abstract class ControllerChain implements IClientController{

	/** Next one in the chain. Once null is reached, done. */

	
	/** Next one in the chain. Once null is reached, done. */
	public IClientController next = null;
	
	/** Terminal entry in the chain. */
	protected ControllerChain() {
		
	}
	
//	/** Chain together. */
//	protected ControllerChain(ControllerChain next) {
//		this.next = next;
//	}
	
	/** 
	 * Carry out the processing. 
	 */
	public abstract boolean process(Message response);

}