import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		YahtzeeSpel yahtzee = new YahtzeeSpel();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welkom bij Yahtzee. U kunt dit spel met zijn tweeën spelen.");
		System.out.println("Wat is uw naam speler 1?");
		String p1 = scanner.nextLine();
		System.out.println("Wat is uw naam speler 2?");
		String p2 = scanner.nextLine();
		Speler speler1 = new Speler(p1);
		Speler speler2 = new Speler(p2);
		ArrayList<Speler> spelers = new ArrayList<Speler>();
		spelers.add(speler1);
		spelers.add(speler2);
		System.out.println(p1 + " start het spel.");
			for(int i = 0; i<5000; i++) {
				for(Speler player : spelers) {
					System.out.println("Gooi de dobbelstenen (g). U kunt ten alle tijden stoppen met het spel (q)");
					yahtzee.spelen();
					System.out.println("U bent aan de beurt " + player.name);
				}
			}
	}
}


class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	boolean[] blockArray = {false, false, false, false, false};
	Worp worp = new Worp();
	Speler speler1 = new Speler("Loes");
	
	YahtzeeSpel(){
		for(int i = 0; i<5; i++) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			dobbelstenen.add(dobbelsteen);
		}
	}
	
	void vasthouden(int beurt) {
		String input = "12345";
		if(beurt > 0) {
		System.out.println("welke stenen wilt u houden?");
			input = scanner.nextLine();
		}
			int convertedInput = 0;
			int index = 0;
			if (input.equals("0")){
				System.out.println("Geen enkele dobbelsteen is goed genoeg voor je?");
				for(Dobbelsteen dobbelsteen : dobbelstenen) {
					dobbelsteen.dobbelsteenResetten();
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
					beurten--;
					vasthouden(beurten);
					worp.worpTonen();
					System.out.println("u mag het nog " + beurten + " keer proberen. Als u tevreden bent met uw dobbelstenen drukt u op p om te passen.");
					break;
				case "p": 
					beurten = 0;
					vasthouden(beurten);
					speler1.worpGeschiedenis.add(worp.uitslag);
					speler1.geschiedenisPrinten();
					System.out.println("");
					speler1.speelbeurten++;
					int index = 0;
					for(Dobbelsteen dobbelsteen : dobbelstenen) {
						dobbelsteen.dobbelsteenResetten();
						worp.uitslag[index] = 0;
						index++;
					}
					
					return;
				case "q":
					System.out.println("U stopt het spel");
					System.out.println("Bedankt voor het spelen.");
				}//end switch
			}//end if statement
			else {
				speler1.geschiedenisPrinten();
				System.out.println("");
				speler1.speelbeurten++;
				int index = 0;
				for(Dobbelsteen dobbelsteen : dobbelstenen) {
					dobbelsteen.dobbelsteenResetten();
					worp.uitslag[index] = 0;
					index++;
				}//end for loop
				return;
			}//end else statement
		}//end while loop 

	}//end method spelen
}

class Dobbelsteen{
	Worp worp = new Worp();
	int ogen;
	boolean vasthouden = false;
	void werpen() {
		if(vasthouden == false) {
			Random random = new Random();
			ogen = random.nextInt(6)+1;
		}//end if statement
	}//end methode werpen
	void dobbelsteenResetten() {
			vasthouden = false;
			//System.out.println(dobbelsteen.vasthouden);// testen of vasthouden terug naar false gaat
			ogen= 0;
	}
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
	String name;
	Worp worp = new Worp();
	int speelbeurten = 1;
	ArrayList<int[]> worpGeschiedenis = new ArrayList<int[]>();
	void geschiedenisPrinten() {
		for(int i = 0; i< speelbeurten; i++) {
			worpGeschiedenis.add(worp.uitslag);
			System.out.println(Arrays.toString(worpGeschiedenis.get(i)));
		}//end for loop
	}//end method geschiedenisPrinten
	Speler(String name){
		this.name = name;
	}
}//end class Speler