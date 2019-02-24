import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		//Player speler1 = new Player();


			System.out.println("Welkom bij Yahtzee. Start het spel en gooi de dobbelstenen(g). U kunt ten alle tijden stoppen met het spel (q)");
			YahtzeeSpel yahtzee = new YahtzeeSpel();
			yahtzee.spelen();
			System.out.println("check");
			yahtzee.spelen();
	}
}


class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	boolean[] blockArray = {false, false, false, false, false};
	Worp worp = new Worp();
	Speler speler1 = new Speler();
	
	YahtzeeSpel(){
		for(int i = 0; i<5; i++) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			dobbelstenen.add(dobbelsteen);
		}
	}
	
	void vasthouden() {
		System.out.println("welke stenen wilt u houden?");
		String input = scanner.nextLine();
		int convertedInput = 0;
		int index = 0;
		if (input.equals("0")){
			System.out.println("Geen enkele dobbelsteen is goed genoeg voor je?");
			for(Dobbelsteen dobbelsteen : dobbelstenen) {
				dobbelsteen.vasthouden = false;
				//System.out.println(dobbelsteen.vasthouden);// testen of vasthouden terug naar false gaat
				dobbelsteen.ogen= 0;
				worp.uitslag[index] = 0;
				index++;
			}
			
		} 
		else{
			for (int i = 0; i < input.length(); i++){
				convertedInput = Integer.parseInt(input.substring(i, i+1))- 1 ; //input komt binnen als String, maar moet eerst een integer worden
				//System.out.println(convertedInput); -- voor testen
				dobbelstenen.get(convertedInput).vasthouden = true;
				//System.out.print(dobbelstenen.get(convertedInput).ogen); // voor het testen
				worp.uitslag[i] = dobbelstenen.get(convertedInput).ogen;
			}
		}
	}
	
	void spelen() {
		boolean spelen = true;
		int beurten = 3;
		while(spelen) {
			if(beurten>0) {
			String invoer = scanner.nextLine();
			switch (invoer) {
			case "g": 
				for(Dobbelsteen dobbelsteen : dobbelstenen) {
					dobbelsteen.werpen();
					System.out.print(dobbelsteen.ogen);
					}
				System.out.println("");
				vasthouden();
				worp.worpTonen();
				beurten--;
				System.out.println("u mag het nog " + beurten + " keer proberen. Als u tevreden bent met uw dobbelstenen drukt u op p om te passen.");
				break;
			case "p": 
				/*int i = 0;
				for(Dobbelsteen dobbelsteen : dobbelstenen) {
					speler1.worpGeschiedenis.add(worp.uitslag[i]);
					i++;
					}	
				System.out.println();*/
				return;
			case "q":
				System.out.println("U stopt het spel");
				System.out.println("Bedankt voor het spelen.");
			}//end switch
			}else {
				System.out.println("uw beurten zijn opperdepop");
				break;
			}

		}//end while loop 
	}
}

class Dobbelsteen{
	int ogen;
	boolean vasthouden = false;
	void werpen() {
		if(vasthouden == false) {
			Random random = new Random();
			ogen = random.nextInt(6)+1;
		}//end if statement
	}//end methode werpen
}//end class Dobbelsteen

class Worp{
	int uitslag[] = new int[5];
	void worpTonen() {
		System.out.println("U heeft nu de volgende dobbelsteenwaardes: ");
		for (int worp : uitslag) {
			System.out.print(worp);
		}
		System.out.println("");
	}

}

class Speler{
	ArrayList<Integer> worpGeschiedenis = new ArrayList();
}