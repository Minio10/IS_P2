package ejb;

import javax.ejb.Local;

@Local
public interface EJBPublicationLocal {
	
	public String getAllPub();
	
	public String titlePubInfo(String title);
	public String resNamePubs(String name) ;
}
