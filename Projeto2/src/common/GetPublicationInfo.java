package common;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GetPublicationInfo
{
private static List<Publication> list;
public static List<Publication> get()
{
	list = new ArrayList<Publication>();
	boolean done = false;
	Scanner sc = new Scanner(System.in);
	while (!done)
	{
		System.out.println("Publication's name (empty to finish): ");
		String name = sc.nextLine();
		done = name.equals("");
		if (!done)
			{
				System.out.println("Publication type: ");
				String type = sc.nextLine();
				System.out.println("Researcher publication date: ");
				String date = sc.nextLine();
				list.add(new Publication(name,type,date));
			}
	}
	sc.close();
	return list;
	}
}