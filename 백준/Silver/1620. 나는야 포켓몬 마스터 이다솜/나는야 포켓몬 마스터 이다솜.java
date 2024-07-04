import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberOfPokemons = Integer.parseInt(st.nextToken());
		int numberOfQueries = Integer.parseInt(st.nextToken());
		StringBuilder result = new StringBuilder();

		HashMap<Integer, String> numberToPokemon = new HashMap<>(); //번호로포켓몬
		HashMap<String, Integer> pokemonToNumber = new HashMap<>(); //이름으로번호
		
		//포켓몬 이름과 번호 저장
		for(int i = 1; i <= numberOfPokemons; i++) {
			String pokemonName = br.readLine();
			numberToPokemon.put(i, pokemonName);
			pokemonToNumber.put(pokemonName, i);
		}
		
		for(int i = 0; i < numberOfQueries; i++) {
			String query = br.readLine();
            
			//입력값이 번호인지 이름인지			
            if(Character.isDigit(query.charAt(0))) {
				result.append(numberToPokemon.get(Integer.parseInt(query))).append("\n");
			} else {
				result.append(pokemonToNumber.get(query)).append("\n");
			}
		}
		System.out.print(result);
	}
}
