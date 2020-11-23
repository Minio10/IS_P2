package common;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GetResearcherInfo
{
private static List<Researcher> list;
public static List<Researcher> get()
{
	list = new ArrayList<Researcher>();
	boolean done = false;
	Scanner sc = new Scanner(System.in);
	while (!done)
	{
		System.out.println("Researcher's name (empty to finish): ");
		String name = sc.nextLine();
		done = name.equals("");
		if (!done)
			{
				System.out.println("Researcher number of publications: ");
				int publications = sc.nextInt();
				System.out.println("Researcher number of reads: ");
				int reads = sc.nextInt();
				System.out.println("Researcher number of citations: ");
				int citations = sc.nextInt();
				list.add(new Researcher(name,publications,reads,citations));
			}
	}
	sc.close();
	return list;
	}
}