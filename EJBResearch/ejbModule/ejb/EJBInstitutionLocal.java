package ejb;

import javax.ejb.Local;

@Local
public interface EJBInstitutionLocal {
	
	public void getAllInfo();
	 public void InstiResName(String name) ;
	 public void InstiName(String name);

}
