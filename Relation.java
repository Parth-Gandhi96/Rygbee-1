import java.util.HashSet;
import java.util.Iterator;

public class Relation {
	private static HashSet<String> _primitiveRelation = new HashSet<String>();
	private static HashSet<String> _derivedRelation = new HashSet<String>();
	
	public Relation(){
		Relation._derivedRelation.add("=");// equals
		Relation._primitiveRelation.add("|]");// intersection
		Relation._primitiveRelation.add("[]"); // union
		Relation._primitiveRelation.add("!"); // not
		Relation._primitiveRelation.add("<"); // subset
		Relation._primitiveRelation.add(">"); // superset 
		Relation._primitiveRelation.add("<="); // subset or equals
		Relation._primitiveRelation.add("=>"); // superset or equals
		Relation._primitiveRelation.add("$"); // there exists
		Relation._primitiveRelation.add("~"); // for all
		/*
		 * a equal b union c leq d
	c equal a union d
		 */
	}
	public void addPrimitiveRelation(String relation){
		Relation._primitiveRelation.add(relation);
	}
	
	public void addDerivedRelation(String relation){
		Relation._derivedRelation.add(relation);
	}
	
	public boolean isPrimitiveRelation(String relation){
		return Relation._primitiveRelation.contains(relation);
	}
	
	public HashSet<String> getPrimitiveRelation(){
		return _primitiveRelation;
	}
	
	public HashSet<String> getDerivedRelation(){
		return _derivedRelation;
	}
	
	public static String getprimitivedelimiter(){
		String lineDelimiter = "";
		Iterator<String> iterator = _primitiveRelation.iterator(); 
		lineDelimiter += iterator.next();
		while (iterator.hasNext()){ // adds all primitive relations to lineDelimiter
			lineDelimiter +=  "|" + iterator.next(); // OR operation on delimiter to split line wrt any primitive relation
		}
		return lineDelimiter;
	}
	
	public static String getderivedelimiter(){
		String lineDelimiter = "";
		Iterator<String> iterator = _derivedRelation.iterator(); 
		lineDelimiter += iterator.next();
		while (iterator.hasNext()){ // adds all primitive relations to lineDelimiter
			lineDelimiter +=  "|" + iterator.next(); // OR operation on delimiter to split line wrt any primitive relation
		}
		//System.out.println(lineDelimiter);
		return lineDelimiter;
	}
}
