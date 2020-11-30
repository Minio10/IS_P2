package ejb;

import javax.ejb.Local;

@Local
public interface EJBResearchLocal {
	
	public  String InfoResearchers();	
	public String InfoSkill(String skill);
	public String InfoNameResearcher(String name);

}
