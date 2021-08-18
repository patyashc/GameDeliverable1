package Uno;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author PARTH PATEL, YASH PATEL
 */
public class Deck
{

    int no = 5;

    ArrayList<UnoCard> array = new ArrayList<>();

    Deck()
    {	
        for (int i = 0; i < 112; i++)
        {
            array.add(new UnoCard());
        }
        int x = 0;
        for (int i = 0; i <= 12; i++)
        {
            int a = 2;
            while (a > 0)
            {
                array.get(x).colour = 1;
                array.get(x).NumberOnCard = i;
                a--;
                x++;
            }
        }
        for (int i = 0; i <= 12; i++)
        {
            int a = 2;
            while (a > 0)
            {
                array.get(x).colour = 2;
                array.get(x).NumberOnCard = i;
                a--;
                x++;
            }
        }
        for (int i = 0; i <= 12; i++)
        {
            int a = 2;
            while (a > 0)
            {
                array.get(x).colour = 3;
                array.get(x).NumberOnCard = i;
                a--;
                x++;
            }
        }
        for (int i = 0; i <= 12; i++)
        {
            int a = 2;
            while (a > 0)
            {
                array.get(x).colour = 4;
                array.get(x).NumberOnCard = i;
                a--;
                x++;
            }
        }
        while (x <= 107)
        {
            array.get(x).colour = 0;
            array.get(x).NumberOnCard = 13;
            x++;
        }
        while (x <= 111)
        {
            array.get(x).colour = 0;
            array.get(x).NumberOnCard = 14;
            x++;
        }
    }

    void distribute_cards(comp_Player computer_Player1, user_Player user_Player2)
    {

        for (int i = 0; i <= 13; i++)
        {
            Random rand = new Random();
            int Low = 0;
            int High = 111;
            int result = rand.nextInt(High - Low) + Low;

            if (array.get(result) != null)
            {

                if (i % 2 == 0)
                {
                    computer_Player1.PlayerCards.add(array.get(result));
                    array.set(result, null);
                } else
                {
                    user_Player2.PlayerCards.add(array.get(result));
                    array.set(result, null);
                }
            } else
            {
                i--;
            }

        }
    }

    UnoCard assignTopCard()
    {
        Random rand1 = new Random();
        int Low = 0;
        int High = 111;
        int result = rand1.nextInt(High - Low) + Low;
        int l = ((result % 26) / 2);
        while (array.get(result) == null || (result >= 104) || l >= 10)
        {

            result = rand1.nextInt(High - Low) + Low;
        }
        UnoCard temp = new UnoCard();
        temp = array.get(result);
        array.set(result, null);
        return temp;
    }

    UnoCard getRandomCard()
    {
        Random rand2 = new Random();
        int Low = 0;
        int High = 111;
        int result = rand2.nextInt(High - Low) + Low;
        while (array.get(result) == null)
        {

            result = rand2.nextInt(High - Low) + Low;
        }
        UnoCard uc = new UnoCard();
        uc = array.get(result);
        array.set(result, null);
        return uc;

    }

}
