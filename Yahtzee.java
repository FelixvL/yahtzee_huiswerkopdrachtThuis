import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		System.out.println("Welkom bij yahtzee, druk op d om te starten");
		YahtzeeSpel nieuwSpel = new YahtzeeSpel();
		nieuwSpel.Starten();
		int worp = nieuwSpel.Werpen();
		
	}

}// end class Yahtzee

class YahtzeeSpel{
	Scanner scanner = new Scanner(System.in);
	boolean doorgaan = true;
	
	void Starten() {
		while(doorgaan) {
			String ingave = scanner.nextLine();
			switch(ingave) {
				case "d":  System.out.println("Het werkt jeej");
					break;
				case "q": System.out.println("Het spel stopt. boe");
					break;
			}
		}
	}//end method Starten
	
	int Werpen() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}//end method Werpen
	
}//end class YahtzeeSpel