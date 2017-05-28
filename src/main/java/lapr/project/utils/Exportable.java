package lapr.project.utils;

import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Interface that allows object's content to be exported.
 * All domains classes should include this interface.
 *
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
@FunctionalInterface
public interface Exportable {

	/**
	 * Exports the object content to a string format.
	 *
	 * @return Structured String containing content.
	 */
	default String exportContentToString() throws TransformerException, ParserConfigurationException {
		String content = "";

		Node node = exportContentToXMLNode();

		XMLParser xmlParser = new XMLParser();

		//It exports only the element representation to XML, ommiting the XML header
		content = xmlParser.convertToString(node);

		return content;
	}

	/**
	 * Exports the object content to a string format.
	 *
	 * @return Structured String containing content.
	 */
	Node exportContentToXMLNode() throws ParserConfigurationException;
}
