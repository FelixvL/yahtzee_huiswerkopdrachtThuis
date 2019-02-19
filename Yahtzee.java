import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		System.out.println("Welkom bij yahtzee, druk op d om te starten");
		YahtzeeSpel nieuwSpel = new YahtzeeSpel();
		nieuwSpel.Spelen();
		
	}

}// end class Yahtzee

class YahtzeeSpel{
	Scanner scanner = new Scanner(System.in);
	boolean doorgaan = true;
	ArrayList<Integer> dobbelstenen = new ArrayList<Integer>(); 
	
	public YahtzeeSpel() {
		dobbelstenen.add(YahtzeeSpel.Werpen());
		dobbelstenen.add(YahtzeeSpel.Werpen());
		dobbelstenen.add(YahtzeeSpel.Werpen());
		dobbelstenen.add(YahtzeeSpel.Werpen());
		dobbelstenen.add(YahtzeeSpel.Werpen());
		dobbelstenen.add(YahtzeeSpel.Werpen());
	}
	//onderstaande method om het spel te starten. wordt aangeroepen in main.
	void Spelen() {
		while(doorgaan) {
			String ingave = scanner.nextLine();
			switch(ingave) {
				case "d": 
					
					for(int i : dobbelstenen) {
						//YahtzeeSpel.Werpen(); werkt niet
						System.out.println(i);
					}
					break;
				case "q": 
					System.out.println("Het spel stopt. boe");
					doorgaan = false;
					break;
			}
		}
	}//end method Starten
	
	// onderstaande is om een random getal tussen 1 en 6 te werpen. deze wordt gereturned.
	static int Werpen() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}//end method Werpen
	
}//end class YahtzeeSpel

class Dobbelsteen{

	void Dobbelstenen() {
		
	}
}// end class Dobbelsteen