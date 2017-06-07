package lapr.project.model;

import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class FAERating implements Importable<FAERating>, Exportable {
    private static final long serialVersionUID = 2L;

    private final FAE ratingFae;

    private final int topicKnowledge;
    private final int applicationsAdequency;
    private final int invitationQuantity;
    private final int overallRecomendation;


    public FAERating(FAE ratingFae, int topicKnowledge, int applicationsAdequency, int invitationQuantity,
                     int overallRecomendation) {
        this.ratingFae = ratingFae;
        this.topicKnowledge = topicKnowledge;
        this.applicationsAdequency = applicationsAdequency;
        this.invitationQuantity = invitationQuantity;
        this.overallRecomendation = overallRecomendation;
    }

    public FAE getRatingFae() {
        return ratingFae;
    }

    public int getTopicKnowledge() {
        return topicKnowledge;
    }

    public int getApplicationsAdequency() {
        return applicationsAdequency;
    }

    public int getInvitationQuantity() {
        return invitationQuantity;
    }

    public int getOverallRecomendation() {
        return overallRecomendation;
    }

    /**
     * Checks if the rating belongs to the FAE
     * @return true if the rating's FAE equals the FAE
     */
    public boolean isFromFAE(FAE fae) {
        return ratingFae.equals(fae);
    }

    /**
     * Gets the average rating value of the parameters for this rating
     * @return average rating
     */
    float getAverageRating(){
        float sum = this.getApplicationsAdequency() + this.getTopicKnowledge() + this.getInvitationQuantity() + this.getOverallRecomendation();
        return sum/4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FAERating)) {
            return false;
        }

        FAERating faeRating = (FAERating) o;

        if (topicKnowledge != faeRating.topicKnowledge) {
            return false;
        }
        if (applicationsAdequency != faeRating.applicationsAdequency) {
            return false;
        }
        if (overallRecomendation != faeRating.overallRecomendation) {
            return false;
        }
        if (applicationsAdequency != faeRating.applicationsAdequency) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicKnowledge;

        result = 31 * result + applicationsAdequency;
        result = 31 * result + invitationQuantity;
        result = 31 * result + overallRecomendation;

        return result;
    }


  /*  @Override
    public KeywordExample importContentFromXMLNode(Node node) throws ParserConfigurationException {

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();

        document.appendChild(document.importNode(node, true));

        NodeList elementsKeyword = document.getElementsByTagName(VALUE_ELEMENT_NAME);

        Node elementKeyword = elementsKeyword.item(0);

        //Get value
        this.value = elementKeyword.getFirstChild().getNodeValue();
        return this;
    }
*/
    @Override
    public FAERating importContentFromXMLNode(Node node) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();

        document.appendChild(document.importNode(node, true));

        //NodeList elementsKeyword = document.getElementsByTagName(VALUE_ELEMENT_NAME);

        //Node elementKeyword = elementsKeyword.item(0);

        //Get value
  /*      private final FAE ratingFae;

        private final int topicKnowledge;
        private final int applicationsAdequency;
        private final int invitationQuantity;
        private final int overallRecomendation;
*/
        return this;
    }

    @Override
    public Node exportContentToXMLNode() throws ParserConfigurationException {
        return null;
    }
}
