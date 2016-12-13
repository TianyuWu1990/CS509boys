package xml;

import java.io.*;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import javax.xml.validation.*;
import org.w3c.dom.*;
import org.xml.sax.*;

// TODO: Auto-generated Javadoc
/** Support class for XML parsing of requests and responses. 
 */
public class Message {
	
	/** The builder. */
	static DocumentBuilder builder = null;              
	
	/** The error handler. */
	static XMLHandler errorHandler = new XMLHandler();  
	
	/** The transformer. */
	static Transformer transformer;                     
	
	/** The contents. */
	public final Node contents;                        

	/**
	 *  Configure builder at first use.
	 *
	 * @param schema the schema
	 * @return true, if successful
	 */
	public static boolean configure (String schema) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try { 
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			factory.setSchema(sf.newSchema(new Source[] {new StreamSource(schema)}));
			builder = factory.newDocumentBuilder();
			builder.setErrorHandler(errorHandler);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			transformer = tf.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 *  Parse XML and construct Message object only if it succeeds.
	 *
	 * @param xmlSource the xml source
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public Message (String xmlSource) throws IllegalArgumentException {
		if (builder == null) {
			throw new RuntimeException ("XML Protocol not configured.");
		}

		try {
			InputSource is = new InputSource (new StringReader (xmlSource));

			
			Document d = null;
			synchronized (builder) {
				d = builder.parse(is);
				errorHandler.failFast();
			}

			
			NodeList children = d.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					contents = n;
					return;
				}
			}
			throw new IllegalArgumentException ("XML document has no child node");
		} catch (Exception e) { 
			errorHandler.failFast();
			throw new IllegalArgumentException (e.getMessage());
		} 
	}

	/**
	 *  Represent message as a string.
	 *
	 * @return the string
	 */
	public String toString() {
		DOMSource domSource = new DOMSource(contents);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		try {
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (Exception e) {
			return "";
		}
	}  


	/**
	 *  Determine the success of the given message.
	 *
	 * @return true, if successful
	 */
	public boolean success() {
		return Boolean.valueOf(contents.getAttributes().getNamedItem(Parser.success).getNodeValue());
	}

	/**
	 *  Determine the reason for failure of the message.
	 *
	 * @return the string
	 */
	public String reason() {
		Node r = contents.getAttributes().getNamedItem(Parser.reason);
		if (r == null) { return ""; }
		return r.getNodeValue();
	}

	/**
	 *  Determine the id for the message.
	 *
	 * @return the string
	 */
	public String id() {
		Node r = contents.getAttributes().getNamedItem(Parser.id);
		if (r == null) { return ""; }
		return r.getNodeValue();
	}
	
	/**
	 *  Create standard request XML header string with built-in (statistically) unique id.
	 *
	 * @return the string
	 */
	public static String requestHeader() {
		String id = UUID.randomUUID().toString();
		return "<request id='" + id + "'>";
	}
	
	/**
	 *  Create standard response XML header string for a successful response.
	 *
	 * @param id the id
	 * @return the string
	 */
	public static String responseHeader(String id) {
		return "<response id = '" + id + "' success='true'>";
	}
	
	/**
	 *  Create standard response XML header string for a failed response.
	 *
	 * @param id the id
	 * @param reason the reason
	 * @return the string
	 */
	public static String responseHeader(String id, String reason) {
		return "<response id='" + id + "' success='false' reason='" + reason + "'>";
	}
	
}
