import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

	public static void main(String[] args) {
		Player speler1 = new Player();
		boolean spelen = true;
		while(spelen) {
			System.out.println("Welkom bij Yahtzee. Start het spel en gooi de dobbelstenen(s). U kunt ten alle tijden stoppen met het spel (q)");
			speler1.spelkeuzes();
		}
	}


}

class Player{
	String name = "";
	Scanner scanner = new Scanner(System.in);
	Dobbelstenen dobbelstenen = new Dobbelstenen(); 

	
	void werpen() {
		dobbelstenen.dobbelstenenVullen();
	}//end werpen method
	
	void spelkeuzes() {
		boolean spelen = true;
		while(spelen) {
			String invoer = scanner.nextLine();
			switch (invoer) {
			case "s": 
				System.out.println("Uw dobbelstenen zijn: ");
				werpen();
				break;
			case "t":
				for(int i = 0; i < 5; i++) {
					
				}
			case "q":
				System.out.println("U stopt het spel");
				return;

			}//end switch
		}//end while loop 
	}//end spelkeuzes method
}//end player class

class Dobbelstenen{
	ArrayList<Dobbelsteen> worp = new ArrayList<Dobbelsteen>();
	
	void dobbelstenenVullen() {
		for(int i = 0; i < 5; i++) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			worp.add(dobbelsteen);
			System.out.print(dobbelsteen.face);
		}//end for loop
		System.out.println("");

	}//end method dobbelstenenVullen
}//end class Dobbelbakje

class Dobbelsteen{
	Random random = new Random();	
	int face = random.nextInt(6)+1;

}//end class Dobbelsteen

class Tafel{
	ArrayList<Dobbelsteen> tafel = new ArrayList();
	void stenenOpTafel(){
		//tafel.add(dobbelsteen);
	}
}