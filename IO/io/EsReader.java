package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class EsReader {

	public static int EOF = -1;
	
	public static void main(String[] args) throws IOException {
		Reader r=null;
		try {
			r = new FileReader("file.txt");  // a partire dalla CWD
	
			int carattere = r.read();
			
			if( carattere == EOF ) {
				System.out.println("Il file è vuoto");
			}else {
				char ch = (char)carattere;
				System.out.println(ch);
			}
		}finally {
			if(r!=null)
				r.close();
		}
		
		// Try-with-resource
		try(Reader rd = new FileReader("file.txt")){
			int carattere;
			
			while( (carattere=rd.read()) != EOF ) {
				char ch = (char)carattere;
				System.out.print(ch);
			}
		}

		try(Reader rd = new FileReader("file.txt");
			Writer wr = new FileWriter("output.txt")){
			
			int carattere;
			
			while( (carattere=rd.read()) != EOF ) {
				wr.write(carattere);
			}
		}

		{
			Reader rd = new FileReader("file.txt");
			Writer wr = new FileWriter("output2.txt");
				
			int carattere;
			
			while( (carattere=rd.read()) != EOF ) {
				wr.write(carattere);
			}
			
		}
		
		
		try(Reader rd = new FileReader("file.txt")){
				
				char[] buffer = new char[1024];
				int len;
				
				while( ( len=rd.read(buffer)) != EOF ) {
					String s = new String(buffer,0,len);
					System.out.println("Contenuto: " + s);
				}
			}
		
		try(BufferedReader br = new BufferedReader( new FileReader("file.txt") )){
			String linea;
			while( (linea = br.readLine()) != null ) {
				System.out.println(linea);
			}
		}
		
		InputStream is;
		OutputStream os;
		
		// 1. ottengo un reader
		Reader in = new InputStreamReader( System.in );
		
		// 2. costruisco un BufferedReader
		BufferedReader br = new BufferedReader( in );
		
		// 3. uso il metodo readLine
		
		System.out.print("Inserisci il tuo nome: ");
		String s = br.readLine();
		
		System.out.println("Hai inserito: " + s);
		
		
	}

}
