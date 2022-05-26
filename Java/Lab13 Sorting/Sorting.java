import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

	public static List<String> read(String filename)
	{
		List<String> reads = new ArrayList<String>();
		File file = new File(filename);
		String temp = "";
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
					if(!temp.trim().isEmpty() && temp.trim() != null)
					{ 
						String[] line = temp.split(" ");
						reads.addAll(Arrays.asList(line));
					}
			in.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return reads;
	}
	
	public static void print(String[] toPrint)
	{
		System.out.println(Arrays.toString(toPrint));
	}
	
	public static void sort(List<String> sorts)
	{
		String[] a = sorts.toArray(new String[0]);
		System.out.print("Original: ");
		print(a);
		int n = a.length;
		for (int fill = 0; fill < n-1; fill++) 
		{
			System.out.print("Pass "+(fill+1)+": ");
			int posMax = fill;
			for (int nxt = fill+1; nxt < n; nxt++)
			if (a[nxt].compareTo(a[posMax])>0)
			posMax = nxt;
			String tmp = a[fill];
			a[fill] = a[posMax];
			a[posMax] = tmp;
			print(a);
		}
	}
	
	public static void main(String[] args)
	{
		String direc = Paths.get("").toAbsolutePath().toString() 
				+ File.separator + "src" +  File.separator + "unsorted.txt";
		sort(read(direc));
	}
}
