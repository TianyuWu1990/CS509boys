package com.capricorn.client;

import xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}