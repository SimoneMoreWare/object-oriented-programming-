package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class EsCSV {

	public static void main(String[] args) throws IOException {
		
		try ( BufferedReader rd = new BufferedReader(new FileReader("esempio.csv")) ){
			
			String header = rd.readLine();
			
			String[] intestazioni = header.split(",");
			
			StringTokenizer st = new StringTokenizer( header, "," );
			while(st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
		}

	}

}
