package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBResearchRemote {
	
	public void InfoResearchers();
	public void InfoSkill(String skill);

}
