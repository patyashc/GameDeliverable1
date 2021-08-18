package Uno;


import java.util.Scanner;

/**
 *
 * @author PARTH PATEL, YASH PATEL 
 */
public class Game {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        //CREATING DECK OF CARDS 
        Deck Deck1 = new Deck();

        //CREATING OBJECT OF COMPUTER PLAYER
        comp_Player computer_Player1 = new comp_Player();

        //CREATING OBJECT OF USER PLAYER
        user_Player user_Player2 = new user_Player();

        Deck1.distribute_cards(computer_Player1, user_Player2);
        UnoCard TopCard = new UnoCard();
        TopCard = Deck1.assignTopCard();
        System.out.print("TOP ");
        TopCard.displayUnoCard();

        boolean move = false;
        boolean tcupdate = false;

        while (computer_Player1.PlayerCards.isEmpty() != true && 
				user_Player2.PlayerCards.isEmpty() != true) {
            UnoCard tempCard = new UnoCard();

            if (move == true) {
                System.out.println("*TURN:  COMPUTER*");

                System.out.println();
                UnoCard compPlayCard;
                compPlayCard = computer_Player1.play(TopCard);
                if (compPlayCard == null) {
                    System.out.println("Top card does not change");
                    UnoCard temp2 = new UnoCard();
                    temp2 = Deck1.getRandomCard();
                    computer_Player1.PlayerCards.add(temp2);
                    if (move == false) //now its computer's chance.
                    {
                        move = true;
                    } else {
                        move = false;
                    }
                } else {
                    tempCard = compPlayCard;
                    tcupdate = true;
                }
            } else {
                System.out.println("*TURN: USER*");
                System.out.println("Your cards are:- ");
                System.out.println();
                user_Player2.displayCards();
                int no;
                System.out.println();
                System.out.println("Enter 1 to DRAW the card or Enter 2 to PUT the card");
                no = scanner.nextInt();
                while(no != 2 && no != 1){
                    System.out.println("Invalid choice choose again:");
                    no = scanner.nextInt();
                }
                if (no == 1) {
                    if (move == false) 
                    {
                        move = true;
                    } else {
                        move = false;
                    }
                    user_Player2.PlayerCards.add(Deck1.getRandomCard());

                } else {
                    System.out.println("Enter the Card you want to PUT");

                    tempCard = user_Player2.getCard(TopCard);//get card will take the card and check if it is correct. if its not will again ask for input.
                    user_Player2.PlayerCards.remove(tempCard);
                    tcupdate = true;
                }

            }
            if (tcupdate == true) {
                tcupdate = false;
                //putting the previous top card back in the deck
                int number = TopCard.NumberOnCard;
                int col = TopCard.colour;
                int index = ((col - 1) * 25) + (2 * number);
                if (Deck1.array.get(index) == null) {
                    Deck1.array.set(index, TopCard);
                } else {
                    Deck1.array.set(index + 1, TopCard);
                }

                TopCard = tempCard;
                System.out.print("TOP ");
                TopCard.displayUnoCard();
                {
                    //IF WILD IS TOP CARD
                    if (TopCard.colour == 0 && TopCard.NumberOnCard == 13) {
                      //nothing happens. move does not changes
                    } // IF WILD DRAW4 IS TOP CARD
                    else if (TopCard.colour == 0 && TopCard.NumberOnCard == 14) {
                        if (move == false) {
                            //computer draws 4 cards 
                            for (int counter = 0; counter <= 3; counter++) {
                                computer_Player1.PlayerCards.add(Deck1.getRandomCard());
                            }
                        } else {
                            for (int counter = 0; counter <= 3; counter++) {
                                user_Player2.PlayerCards.add(Deck1.getRandomCard());
                            }
                            //player draws 4 cards
                        }
                     
                    } //IF TOP CARD IS ACTION CARD
                    else if (TopCard.NumberOnCard >= 10) {
                        if (TopCard.NumberOnCard == 12) {
                            if (move == false) {
                                for (int counter = 0; counter <= 1; counter++) {
                                    computer_Player1.PlayerCards.add(Deck1.getRandomCard());
                                }
                                //computer draws 2 cards 
                            } else {
                                for (int counter = 0; counter <= 1; counter++) {
                                    user_Player2.PlayerCards.add(Deck1.getRandomCard());
                                }
                                //player draws 2 cards
                            }
                            
                        } else {
                            for (int counter = 0; counter <= 1; counter++) {
                                user_Player2.PlayerCards.add(Deck1.getRandomCard());
                            }
                        }
                    } //IF TOPCARD IS NORMAL NUMBER CARD
                    else {
                        if (move == false) //now its computer's chance.
                        {
                            move = true;
                        } else {
                            move = false;
                        }
                    }

                }

            } else {

            }

            //CODE TO CLEAR SCREEN
        }
        if (computer_Player1.PlayerCards.isEmpty() == true) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You Win!");
        }

    }

}