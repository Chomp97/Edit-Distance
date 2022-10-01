package distanze;

public class EditDistance {
	
	public static String rest(String s) {
		return s.substring(1);
	}
	
	public static int editDistanceRec(String s1, String s2) {
		int dNoOp, dCanc, dIns;
		if(s1.length() == 0) return s2.length();
		else if(s2.length() == 0) return s1.length();
		else {
			dCanc = editDistanceRec(s1,rest(s2)) + 1;
			dIns = editDistanceRec(rest(s1),s2) + 1;
			if(s1.charAt(0) == s2.charAt(0)) {
				dNoOp = editDistanceRec(rest(s1),rest(s2));
				return Math.min(Math.min(dCanc, dIns),dNoOp);
			}
			else return Math.min(dCanc, dIns);
		}
	}
	
	//Initializing the matrix, memorizing the base cases and then running the recursive algorithm.
	public static int editDistanceRecDyn(String s1, String s2) {
		Integer m [][] = new Integer[s1.length()+1][s2.length()+1];
		for(int i = 0;i<= s1.length();i++) 
		  m[i][0] = i;
		for(int j = 0; j<= s2.length();j++) 
		  m[0][j] = j;
		return editDistanceRecDynMem(s1,s2,m,s1.length(),s2.length());
	}
	
	/*If the algorithm has already been ran for this particular case the method returns the stored solution. 
	If there is not a solution stored in the matrix we find, store and return it.*/
	public static int editDistanceRecDynMem(String s1, String s2, Integer [][]m, int l1, int l2) {
		if(m[l1][l2] != null) {
			return m[l1][l2];
		}
		int dNoOp, dCanc, dIns;
		dCanc = editDistanceRecDynMem(s1,rest(s2), m, l1, l2-1) + 1;
		dIns = editDistanceRecDynMem(rest(s1),s2, m, l1-1, l2) + 1;
		if(s1.charAt(0) == s2.charAt(0)) {
			dNoOp = editDistanceRecDynMem(rest(s1),rest(s2), m, l1-1, l2-1);
			m[l1][l2] = Math.min(Math.min(dCanc, dIns),dNoOp);
		}
		else {
			m[l1][l2] = Math.min(dCanc, dIns);
		}
		return m[l1][l2];
	}

}