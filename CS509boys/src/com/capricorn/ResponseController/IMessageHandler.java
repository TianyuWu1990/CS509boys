package com.capricorn.ResponseController;

import xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}