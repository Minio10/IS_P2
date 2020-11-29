package ejb;

import javax.ejb.Local;

@Local
public interface EJBResearchLocal {
	
	public void InfoResearchers();
	public void InfoSkill(String skill);
	public void InfoNameResearcher(String name);


}
