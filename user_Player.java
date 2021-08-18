package Uno;

import java.util.Scanner;



/**
 *Change #2: Here we have used LiskovSubstitution Principle by creating sub-class user_Player of super-class Player.
 * 
 * 
 * @author PARTH PATEL, YASH PATEL 
 */
public class user_Player extends Player {

    void displayCards() {
        for (int p = 0; p < this.PlayerCards.size(); p++) {
            System.out.print(p + " ");
            this.PlayerCards.get(p).displayUnoCard();
        }
    }

    UnoCard getCard(UnoCard TopCard) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        UnoCard card = new UnoCard();
        card = this.PlayerCards.get(x);
			if (card.colour == TopCard.colour || 
				card.NumberOnCard == TopCard.NumberOnCard || 
				card.colour == 0 || 
				TopCard.colour == 0) {
            return card;
        } else {
            UnoCard card1 = new UnoCard();
            System.out.println("Invalid choice choose again:");
            x = scanner.nextInt();
            card1 = this.PlayerCards.get(x);
            while(card1.colour != TopCard.colour && card1.NumberOnCard != TopCard.NumberOnCard)
            {
                System.out.println("Invalid choice choose again:");
                x = scanner.nextInt();
                card1 = this.PlayerCards.get(x);
            }
            return card1;
        }
    }

}