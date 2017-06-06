package lapr.project.model;

import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Candidatura class.
 *
 * @author by Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class Application implements Importable<Application>, Exportable, Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ROOT_ELEMENT_NAME = "application";
    private static final String DESCRIPTION_ELEMENT_NAME = "description";
    private static final String KEYWORDS_ELEMENT_NAME = "keywords";
    private final List<Keyword> keywordList = new ArrayList<Keyword>();
    private List<FAERating> ratings;
    private String description = "";
    private String companyName;
    private String address;
    private String phone;
    private User companyRepresentative;
    private int intendedBoothArea;
    private int invitation;

    /**
     * Constructor for Submission
     *
     * @param description Candidatura Description
     * @param keywordList Keyword List
     */
    public Application(List<FAERating> ratings, String description, List<Keyword> keywordList) {
        this.description = description;
        this.keywordList.addAll(keywordList);
        this.ratings = ratings;
        this.companyName = companyName;
        this.phone = phone;
        this.intendedBoothArea = area;
        this.invitation = invitation;
    }
    public Application(){
        
    }

    /**
     * Get Rating
     *
     * @return FAERating
     */
    public List<FAERating> getRatings() {
        return ratings;
    }

    /**
     * Obtain Application description.
     *
     * @return Application description
     */
    String getDescription() {
        return description;
    }

    /**
     * @return the CompanyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param CompanyName the CompanyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public boolean hasRepresentative(User u){
        return this.companyRepresentative.getUsername().equals(u.getUsername());
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    /**
     * @return the intendedBoothArea
     */
    public int getIntendedBoothArea() {
        return intendedBoothArea;
    }

    /**
     * @param intendedBoothArea the intendedBoothArea to set
     */
    public void setIntendedBoothArea(int intendedBoothArea) {
        this.intendedBoothArea = intendedBoothArea;
    }

    /**
     * @return the invitation
     */
    public int getInvitation() {
        return invitation;
    }

    /**
     * @param invitation the invitation to set
     */
    public void setInvitation(int invitation) {
        this.invitation = invitation;
    }

    /**
     * Add a keyword to Application.
     *
     * @param keyword Keyword to be added.
     */
    public void addKeyword(Keyword keyword) {
        getKeywordList().add(keyword);
    }

    /**
     * Obtain the list of existing keywords.
     *
     * @return A list of existing keywords.
     */
    public List<Keyword> getKeywordList() {
        return keywordList;

    }

    public Node exportContentToXMLNode() throws ParserConfigurationException {
        Node rootNode = null;

        DocumentBuilderFactory factory
                = DocumentBuilderFactory.newInstance();
        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();

        //Create root element
        Element elementCandidatura = document.createElement(ROOT_ELEMENT_NAME);

        //Create a sub-element
        Element elementDescription = document.createElement(DESCRIPTION_ELEMENT_NAME);

        //Set the sub-element value
        elementDescription.setTextContent(getDescription());

        //Add sub-element to root element
        elementCandidatura.appendChild(elementDescription);

        //Create a sub-element
        Element elementKeywords = document.createElement(KEYWORDS_ELEMENT_NAME);
        elementCandidatura.appendChild(elementKeywords);

        //iterate over keywords
        for (Keyword keyword : getKeywordList()) {
            Node keywordNode = keyword.exportContentToXMLNode();
            elementKeywords.appendChild(document.importNode(keywordNode, true));
        }

        //Add root element to document
        document.appendChild(elementCandidatura);

        //It exports only the element representation to XMÇ, ommiting the XML header
        rootNode = elementCandidatura;

        return rootNode;
    }

    public Application importContentFromXMLNode(Node node) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();
        document.appendChild(document.importNode(node, true));

        NodeList elementsCandidatura = document.getElementsByTagName(ROOT_ELEMENT_NAME);

        Node elementCandidatura = elementsCandidatura.item(0);

        //Get description
        this.description = elementCandidatura.getFirstChild().getFirstChild().getNodeValue();

        NodeList elementsKeywords = document.getElementsByTagName(KEYWORDS_ELEMENT_NAME);

        NodeList keywords = elementsKeywords.item(0).getChildNodes();
        for (int position = 0; position < keywords.getLength(); position++) {
            Node keyword = keywords.item(position);
            Keyword keywordExample = new Keyword();

            keywordExample = keywordExample.importContentFromXMLNode(keyword);
            addKeyword(keywordExample);
        }

        return this;
    }

    @Override
    public int hashCode() {
        int result = getDescription().hashCode();
        result = 31 * result + getKeywordList().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Application)) {
            return false;
        }

        Application that = (Application) o;

        if (!getDescription().equals(that.getDescription())) {
            return false;
        }
        return getKeywordList().equals(that.getKeywordList());

    }
}
