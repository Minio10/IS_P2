package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBInstitutionRemote {
	
	public void getAllInfo();
	 public void InstiResName(String name) ;
	 public void InstiName(String name);

}
