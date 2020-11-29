package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBPublicationRemote {
	public void getAllPub() ;
	public void titlePubInfo(String title);
	 public void resNamePubs(String name) ;

}
