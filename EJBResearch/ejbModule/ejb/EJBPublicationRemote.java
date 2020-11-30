package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBPublicationRemote {
	public String getAllPub() ;
	public String titlePubInfo(String title);
	public String resNamePubs(String name) ;
}
