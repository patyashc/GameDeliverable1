package Uno;

/**
 * Basically this class is to get card for user and computer turn.
 *
 * @author PARTH PATEL, YASH PATEL
 */
public class UnoCard
{

    public int colour;
    public int NumberOnCard;
    int DrawCards;

    UnoCard()
    {
        this.colour = 100;
        this.NumberOnCard = 100;

    }

    void setColour(int colour)
    {
        this.colour = colour;
    }

    void assign(int number_on_card, int colour)
    {
        this.colour = colour;
        this.NumberOnCard = number_on_card;
        DrawCards = 0;
        if (number_on_card == 12)
        {
            DrawCards = 2;
        }
        if (number_on_card == 14)
        {
            DrawCards = 4;
        }
    }

    void displayUnoCard()
    {
        System.out.print("CARD IS: ");

        if (this.NumberOnCard < 10)
        {
            switch (this.colour)
            {

                case 1 ->
                    System.out.println(NumberOnCard + " " + "yellow");
                case 2 ->
                    System.out.println(NumberOnCard + " " + "green");
                case 3 ->
                    System.out.println(NumberOnCard + " " + "blue");
                case 4 ->
                    System.out.println(NumberOnCard + " " + "red");

            }
        } else
        {
            String str1, str2;
            if (this.NumberOnCard == 10)
            {
                str1 = "skip";
            } else if (this.NumberOnCard == 11)
            {
                str1 = "reverse";
            } else if (this.NumberOnCard == 12)
            {
                str1 = "draw 2";
            } else if (this.NumberOnCard == 13)
            {
                str1 = "wild";
            } else
            {
                str1 = "wildDraw4";
            }
            if (this.colour == 0)
            {
                str2 = "";
            } else if (this.colour == 1)
            {
                str2 = "yellow";
            } else if (this.colour == 2)
            {
                str2 = "green";
            } else if (this.colour == 3)
            {
                str2 = "blue";
            } else
            {
                str2 = "red";
            }
            System.out.println(str1 + " " + str2);
        }

    }

}

