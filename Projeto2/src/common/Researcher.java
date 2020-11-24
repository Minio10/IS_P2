package common;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Researcher 
{
private static final long serialVersionUID = 1L;
// we use this generation type to match that of SQLWriteStudents

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private int publications;
	private int reads;
	private int citations;
	
	@ManyToMany(targetEntity = Publication.class)
	private List publi;
	
	public Researcher(){}
	public Researcher(String name, int publications, int reads, int citations,List publi)
	{
		this.name = name;
		this.publications = publications;
		this.reads =reads;
		this.citations = citations;
		this.publi = publi;
	}
	
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getPublications()
	{
		return publications;
	}
	
	public void setPublications(int publications)
	{
		this.publications = publications;
	}
	
	public int getReads()
	{
		return reads;
	}
	
	public void setReads(int reads)
	{
		this.reads = reads;
	}
	
	public int getCitations()
	{
		return citations;
	}
	
	public void setCitations(int citations) 
	{
		this.citations=citations;
	}
	
	public List getPubli() {
		return publi;
	}
	
	public void setPubli(List publi) {
		this.publi = publi;
	}
	@Override
	public String toString()
	{
	return "Researcher " + name + "\n " + publications;
	}
}