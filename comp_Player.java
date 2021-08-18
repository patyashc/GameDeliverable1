package Uno;

/**
 * Change #2: Here we have used LiskovSubstitution Principle by creating
 * sub-class user_Player of super-class Player.
 *
 * @author PARTH PATEL, YASH PATEL
 */
public class comp_Player extends Player
{

    void displayCards()
    {
        System.out.println("you dont need to see this");
        for (int p = 0; p < this.PlayerCards.size(); p++)
        {
            System.out.print(p + " ");
            if (this.PlayerCards.get(p) == null)
            {
                System.out.println("We are breaking the loop");
                break;
            }
            this.PlayerCards.get(p).displayUnoCard();
        }
    }

    UnoCard play(UnoCard TopCard)
    {

        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        for (int i = 0; i < this.PlayerCards.size(); i++)
        {
            if (this.PlayerCards.get(i) == null)
            {
                System.out.println("we are breaking the loop");
                break;
            }
            if (this.PlayerCards.get(i).colour == TopCard.colour)
            {
                index1 = i;
            }
            if (this.PlayerCards.get(i).NumberOnCard == TopCard.NumberOnCard)
            {
                index2 = i;
            }
            if (this.PlayerCards.get(i).colour == 0)
            {
                index3 = i;
            }

        }
        UnoCard temp = new UnoCard();
        if (index1 != -1)
        {

            temp.colour = this.PlayerCards.get(index1).colour;
            temp.NumberOnCard = this.PlayerCards.get(index1).NumberOnCard;
            this.PlayerCards.remove(index1);

        } else if (index2 != -1)
        {
            temp.colour = this.PlayerCards.get(index2).colour;
            temp.NumberOnCard = this.PlayerCards.get(index2).NumberOnCard;
            this.PlayerCards.remove(index2);
        } else if (index3 != -1)
        {
            temp.colour = this.PlayerCards.get(index3).colour;
            temp.NumberOnCard = this.PlayerCards.get(index3).NumberOnCard;
            this.PlayerCards.remove(index3);
        } else
        {
            //COMPUTER DRAWS CARD
            temp = null;

        }
        return temp;
    }

}

