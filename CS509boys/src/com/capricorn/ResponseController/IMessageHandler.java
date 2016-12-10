package com.capricorn.ResponseController;

import xml.Message;
/** Interface is designed to handle the message from the server.
 */
public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}