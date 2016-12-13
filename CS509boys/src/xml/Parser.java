package xml;

import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Parser.
 */
public class Parser {

	/** Common id across request/responses. */
	public final static String id = "id";
	
	/** Attributes in responses. */
	public final static String success = "success";
	
	/** The Constant reason. */
	public final static String reason = "reason";

	/** Connect initial request. */
	public final static String connectRequest = "connectRequest";
	
	/** The Constant connectResponse. */
	public final static String connectResponse = "connectResponse";

	/**
	 *  Return extracted request.
	 *
	 * @param in the in
	 * @return the message
	 */
	public static Message extractRequest(BufferedReader in) {
		return extractMessage(in, "</request>");
	}

	/**
	 *  Return extracted response.
	 *
	 * @param in the in
	 * @return the message
	 */
	public static Message extractResponse(BufferedReader in) {
		return extractMessage(in, "</response>");
	}

	/**
	 *  
	 * Extract the XML message and construct validated Message object based on
	 * the terminator string (either "</request>" or "</response>"). Returns 
	 * null if communication is interrupted in any way.
	 *
	 * @param in the BufferedReader in
	 * @param terminator the terminator
	 * @return the message
	 */
	static Message extractMessage(BufferedReader in, String terminator) {
		try {
			String line = in.readLine();
			if (line == null) { return null; }
			StringBuilder buf = new StringBuilder(line);
			while (!buf.substring(buf.length()-terminator.length(), buf.length()).equals(terminator)) {
				line = in.readLine();
				if (line == null) { return null; }
				buf.append(line);
			}

			return new Message (buf.toString());
		} catch (IOException ioe) {
			return null;
		}
	}

}

