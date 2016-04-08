import java.util.*;

public class Parser {
	
	private DerivedConcepts _derived = new DerivedConcepts();
	private HashSet<String> _concepts = new HashSet< String>();
	private HashSet<String> _primitiveconcepts = new HashSet< String>();
	private HashSet<String> _derivedconcepts;
	private PrimitiveConcepts primitive;
	
	public void parse( String line ){
		
		line = line.replaceAll("\\s","");
		String lineDelimiter = Relation.getderivedelimiter();
		if(line.contains("@")){
			Axiom._axioms.add(line);
		}
		else if(line.contains("#")){
			Definition._definition.add(line);
		}
		else{
		String[] parsedString = line.split(lineDelimiter);
		String[] derived = new String[parsedString.length - 1];
		System.arraycopy(parsedString, 0, derived, 0, parsedString.length-1);
		_derived.addDerived(derived);
		
		lineDelimiter =  Relation.getprimitivedelimiter();
		parsedString =  parsedString[parsedString.length - 1].split(lineDelimiter);
	
		for(String s : parsedString){
			_concepts.add(s);	
		}
		}
		
	}
	public void separateConcepts(){
		_derivedconcepts = _derived.getDerivedConcepts();
		for(String s : _concepts){
			System.out.println(s);
			if(!_derivedconcepts.contains(s)){
				_primitiveconcepts.add(s);
				System.out.println(s + "primitive");
			}				
		}
		primitive = new PrimitiveConcepts(_primitiveconcepts);
	}
}
