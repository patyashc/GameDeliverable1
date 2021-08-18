package Uno;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PARTH PATEL, YASH PATEL
 */
public class Player
{

    int x;
    ArrayList<UnoCard> PlayerCards = new ArrayList<UnoCard>(x);

    UnoCard getCard(UnoCard TopCard)
    {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        UnoCard Ucard = new UnoCard();
        Ucard = this.PlayerCards.get(x);
        if (Ucard.colour == TopCard.colour || Ucard.NumberOnCard == TopCard.NumberOnCard)
        {
            return Ucard;
        } else
        {
            return this.getCard(TopCard);

        }

    }

}
