package lexical_analyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Automaton {

	private String[] tipos = { "boolean", "int", "float" };
	private String[] ignoreLine = { "/*", "*/" };
	private String[] points = { "{", "}", ">", "<", "(", ")" };
	private String[] reservedWords = { "se", "senao", "imprimi" };
	private List<String> palavrasReservadas = new ArrayList<>();

	
	public void identifyCharacter(String line, int lineNumber){
		this.palavrasReservadas.addAll(Arrays.asList(tipos));
		this.palavrasReservadas.addAll(Arrays.asList(points));
		this.palavrasReservadas.addAll(Arrays.asList(ignoreLine));
		this.palavrasReservadas.addAll(Arrays.asList(reservedWords));

		if(!line.equals("")){
			String[] words = line.split(" ");

			for (String word : words) {
				if (palavrasReservadas.contains(word)) {
					this.treatReservedWord(word);
				} else if (isNumber(word)) {
					Output.setNumber(word);
				} else {
					Output.setVariableIdentifier(word);
				}

				// if(error){
				// 	Error.addError(lineNumber);
				// 	break;
				// }
			}
		}else{
			Error.addError(lineNumber);
		}
	}

	private void treatReservedWord(String word) {
		if (Arrays.asList(tipos).contains(word)) {
			Output.setType(word);
		} else if (Arrays.asList(points).contains(word)) {
			Output.setPunctuation(word);
		} else if (Arrays.asList(reservedWords).contains(word)) {
			Output.setReservedWord(word);
		} else if (Arrays.asList(ignoreLine).contains(word)) {
			Output.setCommentIdentifier(word);
		}
	}
	
	private boolean isNumber(String c) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	 
	    return pattern.matcher(c).matches();
	}
}
