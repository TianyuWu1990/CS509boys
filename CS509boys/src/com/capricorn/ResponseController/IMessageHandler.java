package com.capricorn.ResponseController;

import xml.Message;
/** Interface is designed to handle the message from the server.
 *  @author Chen Li, Tianyu Wu, Bowen Sun
 */
public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}