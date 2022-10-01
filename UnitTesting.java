package distanze;
import java.io.*;
import java.util.*;

public class UnitTesting {
	public static void CaricaCorrectMe() {
		  String path = "correctme.txt";
		  ArrayList<String> tocorrect = GestoreDistanze.loadData(path);
		  System.out.println("Caricato correctme.txt");
	}
	
	public static void CaricaDizionario() {
		  String path = "dictionary.txt";
		  ArrayList<String> dictionary = GestoreDistanze.loadData(path);
		  System.out.println("Caricato dictionary.txt");
	}
	
	public static void TestDistanze() {
		String prima = "mimmuzzo";
		String seconda = "pierino";
		System.out.println("Edit distance tra le due stringhe: " + EditDistance.editDistanceRec(prima, seconda));
	}

	public static void TestDistanzeDinamico() {
		String prima = "mimmuzzo";
		String seconda = "pierino";
		System.out.println("Edit distance tra le due stringhe: " + EditDistance.editDistanceRecDyn(prima, seconda));
	}
	
	public static void main(String[] args) {
		CaricaCorrectMe();
		CaricaDizionario();
		TestDistanze();
		TestDistanzeDinamico();
	}
}
