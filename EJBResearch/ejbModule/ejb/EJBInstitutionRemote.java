package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBInstitutionRemote {
	
	public String getAllInfo();
	public String InstiResName(String name);
	 public String InstiName(String name);
}
