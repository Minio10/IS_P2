package common;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Researcher implements Serializable
{
private static final long serialVersionUID = 1L;
// we use this generation type to match that of SQLWriteStudents
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private int publications;
private int reads;
private int citations;
public Researcher(){}
public Researcher(String name, int publications, int reads, int citations)
{
	this.name = name;
	this.publications = publications;
	this.reads =reads;
	this.citations = citations;
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
@Override
public String toString()
{
return "Researcher " + name + "\n " + publications;
}
}