package ejb;

import javax.ejb.Remote;

@Remote
public interface EJBResearchRemote {
	
	public  String InfoResearchers();
	public String InfoSkill(String skill);
	public String InfoNameResearcher(String name);
}
