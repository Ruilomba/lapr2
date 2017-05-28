package lapr.project.model;

import lapr.project.utils.StringUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class to demonstrate a Candidatura simple example.
 *
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class ApplicationTest {

	/**
	 * StringUtil variable to access utils for Strings.
	 */
	private StringUtil stringUtil = new StringUtil();

	/**
	 * Get OS independent line break.
	 *
	 * @return OS independent line break "%n".
	 */
	private String getLineBreak() {
		if (stringUtil == null) {
			stringUtil = new StringUtil();
		}
		return stringUtil.getLineBreak();
	}

	@Test
	public void ensureAddKeywordIsWorking() throws Exception {
		List<Keyword> expectedKeywordList = new ArrayList<>();
		expectedKeywordList.add(new Keyword("Doors"));

		Application candidatura = new Application("MyCandidatura", new ArrayList<>());
		candidatura.addKeyword(new Keyword("Doors"));

		List<Keyword> resultList = candidatura.getKeywordList();

		assertArrayEquals(expectedKeywordList.toArray(), resultList.toArray());

	}

	@Test
	public void ensureXMLElementExportToStringIsValid() throws Exception {
		String expected = "<application>" + getLineBreak() +
				"<description>MyApplication</description>" + getLineBreak() +
				"<keywords>" + getLineBreak() +
				"<keyword>" + getLineBreak() +
				"<value>Doors</value>" + getLineBreak() +
				"</keyword>" + getLineBreak() +
				"<keyword>" + getLineBreak() +
				"<value>Windows</value>" + getLineBreak() +
				"</keyword>" + getLineBreak() +
				"</keywords>" + getLineBreak() +
				"</application>" + getLineBreak();

		List<Keyword> keywordList = new ArrayList<>();
		keywordList.add(new Keyword("Doors"));
		keywordList.add(new Keyword("Windows"));
		Application application = new Application("MyApplication", keywordList);
		String result = application.exportContentToString();
		assertEquals(expected, result);
	}

	@Test
	public void ensureImportFromXMLElementNodeIsValid() throws Exception {
		List<Keyword> keywordList = new ArrayList<>();
		keywordList.add(new Keyword("Doors"));
		keywordList.add(new Keyword("Windows"));

		Application expected = new Application("MyApplication", keywordList);

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		//Create document builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Obtain a new document
		Document document = builder.newDocument();

		//Create root element
		Element elementCandidatura = document.createElement("application");

		//Create a sub-element
		Element elementDescription = document.createElement("description");

		//Set the sub-element value
		elementDescription.setTextContent("MyApplication");

		//Add sub-element to root element
		elementCandidatura.appendChild(elementDescription);

		//Create a sub-element
		Element elementKeywords = document.createElement("keywords");

		//iterate over keywords
		for (Keyword keyword : keywordList) {
			Node keywordNode = keyword.exportContentToXMLNode();
			elementKeywords.appendChild(document.importNode(keywordNode, true));
		}

		elementCandidatura.appendChild(elementKeywords);

		//Add root element to document
		document.appendChild(elementCandidatura);

		Application result = new Application();
		result = result.importContentFromXMLNode(elementCandidatura);

		assertEquals(expected, result);
	}

	@Test
	public void ensureSameContentObjectsAreEqual() {
		String description = "MyCandidatura";

		List<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Doors"));
		keywords.add(new Keyword("Windows"));

		Application expected = new Application(description, keywords);
		Application result = new Application(description, keywords);

		assertEquals(expected, result);
	}

	@Test
	public void ensureSameObjectIsEqual() {
		String description = "MyCandidatura";

		List<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Doors"));
		keywords.add(new Keyword("Windows"));

		Application expected = new Application(description, keywords);

		assertEquals(expected, expected);
	}

	@Test
	public void ensureDifferentObjectsAreNotEqual() {
		String description = "MyCandidatura";

		List<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Doors"));
		keywords.add(new Keyword("Windows"));

		Application expected = new Application(description, keywords);

		Object result = new Object();
		assertNotEquals(expected, result);
	}

	@Test
	public void ensureDifferentDescriptionMakeObjectsNotEqual() {
		String description1 = "MyCandidatura1";
		String description2 = "MyCandidatura2";

		List<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Doors"));
		keywords.add(new Keyword("Windows"));

		Application expected = new Application(description1, keywords);
		Application result = new Application(description2, keywords);

		assertNotEquals(expected, result);
	}

	@Test
	public void ensureHashCodeIsCorrect() {
		String description = "MyCandidatura";

		List<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("Doors"));
		keywords.add(new Keyword("Windows"));

		Application application = new Application(description, keywords);

		int expected = 461375881;
		int result = application.hashCode();
		assertEquals(expected, result);

	}


}