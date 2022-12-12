package rzk.beans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

import model.Card;

/**
 * Session Bean implementation class CardsBean
 */
@Stateless
@LocalBean
public class CardsBean implements CardsBeanRemote {
	
	@Resource(mappedName = "java:/jms/queue/KL")
    private Destination destinationQueue;
	
	@Inject
    private JMSContext context;
	
    public CardsBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean sendMessage(String type, String from, String to, String email) {
		System.out.println("Cards bean send message function...");
		
		System.out.println("type: " + type);
		System.out.println("from: " + from);
		System.out.println("to: " + to);
		System.out.println("email" + email);
		
		if(type == null || type.trim().isEmpty()
				|| from == null || from.trim().isEmpty()
				|| to == null || to.trim().isEmpty()
				|| email == null || email.trim().isEmpty()
			) {
			return false;
		}
		
		System.out.println("Cards bean making a new card");
		Card card = new Card();
		card.setType(type);
		card.setCardFrom(from);
		card.setCardTo(to);
		card.setEmail(email);
		
		context.createProducer().send(destinationQueue, card);
		
		return true;
	}

}
