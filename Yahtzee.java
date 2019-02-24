import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		//Player speler1 = new Player();


			System.out.println("Welkom bij Yahtzee. Start het spel en gooi de dobbelstenen(s). U kunt ten alle tijden stoppen met het spel (q)");
			YahtzeeSpel yahtzee = new YahtzeeSpel();
			yahtzee.spelen();
	}
}


class YahtzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	
	boolean[] blockArray = {false, false, false, false, false};
	
	YahtzeeSpel(){
		for(int i = 0; i<5; i++) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			dobbelstenen.add(dobbelsteen);
		}
	}
	
	void vasthouden() {
		System.out.println("welke stenen wilt u houden?");
		String input = scanner.nextLine();
		//String vastgehoudenStenen = "";

		if (input.equals("0")){
			System.out.println("Geen enkele dobbelsteen is goed genoeg voor je?");
		} 
		else{
			for (int i = 0; i < input.length(); i++){
				int convertedInput = Integer.parseInt(input.substring(i, i+1))- 1 ; //input komt binnen als String, maar moet eerst een integer worden
				//System.out.println(convertedInput);
				dobbelstenen.get(convertedInput).vasthouden = true;
				System.out.println(dobbelstenen.get(convertedInput).ogen);
			}
		}
	}
	
	void spelen() {
		boolean spelen = true;
		while(spelen) {
			String invoer = scanner.nextLine();
			switch (invoer) {
			case "s": 
				for(Dobbelsteen dobbelsteen : dobbelstenen) {
					dobbelsteen.werpen();
					System.out.print(dobbelsteen.ogen);
					}
				break;
			case "t"://vasthouden testen
				vasthouden();
				System.out.println("gooien");
				break;
			case "q":
				System.out.println("U stopt het spel");
				return;
			}//end switch
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
			//System.out.print(ogen);
		}
	}
}