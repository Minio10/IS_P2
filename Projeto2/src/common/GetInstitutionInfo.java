package common;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GetInstitutionInfo
{
private static List<Institution> list;
public static List<Institution> get()
{
	list = new ArrayList<Institution>();
	boolean done = false;
	Scanner sc = new Scanner(System.in);
	while (!done)
	{
		System.out.println("Institution's name (empty to finish): ");
		String name = sc.nextLine();
		done = name.equals("");
		if (!done)
			{
				System.out.println("Institution location: ");
				String location = sc.nextLine();
				System.out.println("Institution department : ");
				String department = sc.nextLine();
				list.add(new Institution(name,location,department));
			}
	}
	sc.close();
	return list;
	}
}