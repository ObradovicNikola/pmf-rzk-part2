package rzk;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService
public interface InformationBeanRemote {
	String getCountryInfo(String s);

}
