package it.polito.oop3.university;

public class ExceptionLessonNotFound extends Exception {
	public ExceptionLessonNotFound() {
		super("Lezione non trovata");
	}
}
