package io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String[] args) {
		
		String email = "Marco <marco.torchiano@studenti.polito.it>";
		
		String expr = "([^@<]+)@((?:[^@]+\\.)?polito\\.it)";
		Pattern emailPattern = Pattern.compile(expr);
		
		System.out.println("RegExp: " + expr);
		
		Matcher m = emailPattern.matcher(email);
		
		if( m.find() ) {
			System.out.println("utente: " + m.group(1));
			System.out.println("dominio: " + m.group(2));
			System.out.println("sotto dominio: " + m.group(3));
		}else {
			System.out.println("no match");
		}
	}

}
