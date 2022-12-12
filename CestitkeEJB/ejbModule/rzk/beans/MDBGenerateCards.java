package rzk.beans;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Card;

/**
 * Message-Driven Bean implementation class for: MDBGenerateCards
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/KL"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/KL")
public class MDBGenerateCards implements MessageListener {
	
	@Resource(mappedName = "java:/jms/topic/generate")
	private Destination destinationTopic;
    
	@Inject private
	JMSContext context;
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public MDBGenerateCards() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	System.out.println("MDB generate card received a message from queue KL");
    	try {
			Card card = message.getBody(Card.class);
			em.persist(card);
			context.createProducer().send(destinationTopic, card);
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}
