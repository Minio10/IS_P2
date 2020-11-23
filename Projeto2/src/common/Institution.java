package common;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Institution implements Serializable
{
private static final long serialVersionUID = 1L;
// we use this generation type to match that of SQLWriteStudents
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String location;
private String department;
public Institution(){}
public Institution(String name,String location, String department)
{
	this.name = name;
	this.location = location;
	this.department = department;
}

public String getName()
{
	return name;
}

public void setName(String name)
{
	this.name = name;
}

public String getLocation()
{
	return location;
}

public void setLocation(String location)
{
	this.location = location;
}

public String getDepartment()
{
	return department;
}

public void setDepartment(String department)
{
	this.department = department;
}


@Override
public String toString()
{
return "Institution " + name + "\n " + location;
}
}