package Uno;


import java.util.*;

/**
 * Change#3: We have used Model-View-Controller pattern (MVC) by using uno class
 * as a model and Game class as a controller for this game.
 *
 * @author PARTH PATEL, YASH PATEL
 */
public class uno
{

    int white = 0;
    int yellow = 1;
    int green = 2;
    int blue = 3;
    int red = 4;
    int skip = 10;
    int reverse = 11;
    int draw2 = 12;
    int wild = 13;
    int wild_4 = 14;

    public static void main(String[] args)
    {

        System.out.println("Welcome to Uno Game");
        Game game = new Game();
        game.run();

    }

}
