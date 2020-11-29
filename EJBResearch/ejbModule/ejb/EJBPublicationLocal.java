package ejb;

import javax.ejb.Local;

@Local
public interface EJBPublicationLocal {
	
	public void getAllPub() ;
	public void titlePubInfo(String title);
	 public void resNamePubs(String name) ;

}
