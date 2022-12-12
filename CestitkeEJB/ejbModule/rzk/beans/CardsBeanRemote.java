package rzk.beans;

import javax.ejb.Remote;

@Remote
public interface CardsBeanRemote {

	public boolean sendMessage(String type, String from, String to, String email);
}
