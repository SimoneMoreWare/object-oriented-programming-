package regexp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternExamples {

	public static void main(String[] args) {
		Pattern re  = Pattern.compile(
				"[^,]+"
				);
		String csvContent = "Last,First\n" + 
				"Snow,Jon\n" + 
				"Lannister,Tyrion\n" + 
				"Targaryen,Daenerys,Stormborn...\n" + 
				"Nemo,\n" +
				",Voldemort\n" +
				"Stark,Arya";
		try(Scanner fs = new Scanner(csvContent)){
			while(true){
				String c;
				while((c=fs.findInLine(re))!=null){
					System.out.println(c);
				}
				System.out.println("--");
				if(!fs.hasNextLine()) break;
				fs.nextLine();
			}
		}

	}

}
