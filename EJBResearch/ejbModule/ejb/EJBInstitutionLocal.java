package ejb;

import javax.ejb.Local;

@Local
public interface EJBInstitutionLocal {
	
	public String getAllInfo();
	public String InstiResName(String name);
	public String InstiName(String name);
}
