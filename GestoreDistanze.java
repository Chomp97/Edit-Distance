package distanze;
import java.io.*;
import java.util.*;

public class GestoreDistanze {
	private static char peek;
	
	private static void readch(BufferedReader br) {
	  try {
	    peek = (char) br.read();
	  } catch (IOException exc) {
	      peek = (char) -1; // ERROR
	    }
	}
	
	public static ArrayList<String> loadData(String path) {
	  ArrayList<String> l = new ArrayList<String>();
	  String parola = "";
	  try {
	    BufferedReader br = new BufferedReader(new FileReader(path));
	    readch(br);
	    int i = 0;
	    while(peek != (char) -1) {
	      if(Character.isLetter(peek)) {
	    	while(Character.isLetter(peek)) {
	    	  parola = parola.concat(Character.toString(peek));
	    	  readch(br);
	    	}
	    	l.add(i,parola);
	        parola = "";
	        i++; }
	        readch(br);
	    }
	  } catch (IOException e) {e.printStackTrace();}
	  return l;
	}
	
	public static void main(String[] args) {
	  String path = "correctme.txt";
	  ArrayList<String> tocorrect = loadData(path);
	  System.out.println("Caricato correctme.txt");
	  path = "dictionary.txt";
	  ArrayList<String> dictionary = loadData(path);
	  System.out.println("Caricato dictionary.txt");
	  ListIterator<String> correctlist = tocorrect.listIterator();
	  int dummy = Integer.MAX_VALUE, minimumdistance;
	  String wordtoiterate;
	  ArrayList<String> closewords = new ArrayList<String>();
	  while(correctlist.hasNext()) {
	    wordtoiterate = correctlist.next();
  	    for(int i = 0; i < dictionary.size(); i++) {
		  minimumdistance = EditDistance.editDistanceRecDyn(wordtoiterate, dictionary.get(i));
		  if(dummy > minimumdistance) {
			dummy = minimumdistance;
            closewords.clear();
		    closewords.add(dictionary.get(i));
		  }
		  else if(dummy == minimumdistance) {closewords.add(dictionary.get(i));}
		}
  	    System.out.print("Parole con edit distance minore verso " + wordtoiterate + "\n");
  	    for(int index = 0; index < closewords.size(); ++index) {
  	      System.out.print(closewords.get(index) + " ");
  	    }
	    System.out.print("\n");
  	    closewords.clear();
  	    dummy = Integer.MAX_VALUE;
	  }
	}
}