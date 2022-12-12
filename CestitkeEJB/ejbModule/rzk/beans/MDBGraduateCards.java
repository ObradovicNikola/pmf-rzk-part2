package rzk.beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import model.Card;

/**
 * Message-Driven Bean implementation class for: MDBGraduateCards
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/topic/generate"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jms/topic/generate")
public class MDBGraduateCards implements MessageListener {

    /**
     * Default constructor. 
     */
    public MDBGraduateCards() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	try {
			Card card = message.getBody(Card.class);
			if (card.getType().equals("diplomska")) {
				System.out.println("Generisana je diplomska cestitka!!");
				System.out.println("From: " + card.getCardFrom());
				System.out.println("To: " + card.getCardTo() + ", email: " + card.getEmail());
			}
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
