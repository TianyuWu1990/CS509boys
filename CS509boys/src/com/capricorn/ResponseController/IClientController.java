package com.capricorn.ResponseController;

import xml.Message;
/** Form an IClientController interface
 */
public interface IClientController {
	
	/**
	 * Return TRUE if accept the response; false otherwise.
	 * 
	 * If unable to process a valid response, then must thrown a RuntimeException 
	 */
	public boolean process(Message response);
}
