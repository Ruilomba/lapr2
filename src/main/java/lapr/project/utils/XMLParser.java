package lapr.project.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Class that allows converting XML to String and read/write to files.
 * Created by Nuno Bettencourt [NMB] on 29/05/16.
 */
public class XMLParser {

	/**
	 * This methods renders an XML Node to string ommiting the XML declarion on top.
	 *
	 * @param document The XML Document to render.
	 * @return A structured string for the XML Document.
	 */
	public String convertToString(Document document) throws TransformerException {
		//Set transformer properties
		Properties transformerProperties = new Properties();
		transformerProperties.setProperty(OutputKeys.INDENT, "yes");

		//Render to XML
		return convertNodeToString(transformerProperties, document);
	}

	/**
	 * This methods renders an XML Node to string ommiting the XML declarion on top.
	 *
	 * @param node The XML node to render.
	 * @return A structured string for the XML node.
	 */
	public String convertToString(Node node) throws TransformerException {
		//Set transformer properties
		Properties transformerProperties = new Properties();
		transformerProperties.setProperty(OutputKeys.INDENT, "yes");
		transformerProperties.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

		//Render to XML
		return convertNodeToString(transformerProperties, node);

	}

	/**
	 * Renders an XML node to String.
	 *
	 * @param transformerProperties Transformer Properties to be applied to the node.
	 * @param node                  The XML node to transform to string.
	 * @return A structured string for the XML node.
	 */
	private String convertNodeToString(Properties transformerProperties, Node node) throws TransformerException {
		TransformerFactory tFact = TransformerFactory.newInstance();

		Transformer transformer = tFact.newTransformer();

		transformer.setOutputProperties(transformerProperties);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		DOMSource source = new DOMSource(node);

		transformer.transform(source, result);
		return writer.toString();
	}

	/**
	 * Reads XML from a file and transforms it into an XML element.
	 *
	 * @param filename Filename to be read.
	 * @return XML Node containing the file content
	 * @throws Exception
	 */
	public Node readXMLElementFromFile(String filename) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		FileInputStream fileStream = new FileInputStream(filename);

		Document document = builder.parse(fileStream);
		return document.getDocumentElement();

	}

	/**
	 * Writes an XML node to a file.
	 *
	 * @param node     XML node to be written.
	 * @param filename File to be written.
	 * @throws Exception
	 */
	public void writeXMLElementToFile(Node node, String filename) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(node);

		StreamResult result = new StreamResult(new File(filename));

		transformer.transform(source, result);
	}
}
