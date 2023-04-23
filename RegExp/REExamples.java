package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REExamples {

	public static void main(String[] args) {
		{
		Pattern p=Pattern.compile("([+-]?)([0-9]+)");
		Matcher m = p.matcher("-4560");
		if(m.matches()){
			System.out.println("Group 1, sign  : " + m.group(1) +
							 "\nGroup 2, digits: " + m.group(2) );
		}

		m = p.matcher("+42 ... -3, 0");
		while(m.find()){
			System.out.println("Group 1, sign  : " + m.group(1) +
					 "\nGroup 2, digits: " + m.group(2) );
		}
		}
		
		{
			String htmlCode = "<html><body><h1>Title</h1>"+
                    "&gt; text</body></html>";
			Pattern p = Pattern.compile( 
					"(<[^>]+>)|(&\\w+;)|([^<&]+)");
			Matcher m = p.matcher(htmlCode);
			final String[] types= {"ELEMENT","ENTITY","Text"};
			while(m.find()){
				int type = 0;
				for(int i=1; i<=m.groupCount();++i) 
					if(m.group(i)!=null) type = i; 
				System.out.println(types[type-1] + " : '" +
										    m.group(type) + "'");
			}
		}
		{
			System.out.println("Named groups");
			String htmlCode = "<html><body><h1>Title</h1>"+
                    "&gt; text</body></html>";
			Pattern p = Pattern.compile( 
					"(?<ELEMENT><[^>]+>)|(?<ENTITY>&\\w+;)|(?<Text>[^<&]+)");
			Matcher m = p.matcher(htmlCode);
			final String[] groups= {"ELEMENT","ENTITY","Text"};
			while(m.find()){
				for(String type : groups) 
					if(m.group(type)!=null) 
						System.out.println(type + " : '" +
										    m.group(type) + "'");
			}
		}
		{ // CSV
			Pattern csv  = Pattern.compile(
					"(?<sep>,|^|\n|\r\n?)" +// G1 : prec sep
					"[ \t]*" +              // -  : lead spaces
					"(?:(?<c>[^\",\n\r]*)" +// G2 : normal cell
					"|\"(?<dc>(?:[^\"]*|\"\")*)\")"+//G3: delim
					"[ \t]*"				       // - : trail spaces
					);
			String csvContent = "Last,First\n" + 
					"Snow,Jon\n" + 
					"Lannister,Tyrion\n" + 
					"Targaryen,Daenerys,Stormborn...\n" + 
					"Stark,Arya";
			Matcher m = csv.matcher(csvContent);
			while(m.find()){
			  if(!m.group("sep").equals(",")) //new row
				  System.out.println("Row:");
			  String c = m.group("c");
			  if(c==null)
			   c=m.group("dc").replaceAll("\"\"","\"");
			  System.out.println("\tCell:" + c);
			}
		}

}

}
