package lexical_analyzer;

import java.util.LinkedHashMap;

public class Output {

	private static LinkedHashMap<String, String> output = new LinkedHashMap<String, String>();

	public static void setPunctuation(String lexema) {
		output.put(lexema, "PONTUACAO");
	}

	public static void setType(String lexema) {
		output.put(lexema, "TIPO");
	}

	public static void setNumber(String lexema) {
		output.put(lexema, "NUMERO");
	}
	
	public static void setCommentIdentifier(String lexema){
		output.put(lexema, "COMENTARIO");
	}
	
	public static void setVariableIdentifier(String lexema){
		output.put(lexema, "VARIAVEL");
	}
	
	public static void setReservedWord(String lexema){
		output.put(lexema, "PALAVRA RESERVADA");
	}
	
	public static LinkedHashMap<String, String> getOutput(){
		return output;
	}
}
