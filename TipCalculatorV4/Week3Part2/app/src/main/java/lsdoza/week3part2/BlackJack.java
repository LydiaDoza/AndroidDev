package lsdoza.week3part2;

import android.view.View;

import java.util.Random;

/**
 * Created by lsdoza on 1/28/2017.
 */

/*
Write an app that displays four labels and a button. The first
two labels represent two cards in a simplified BlackJack game
and are filled with two randomly generated integers with values
between 1 and 11 inclusive. The total of the two is displayed
inside the fourth label. When the user clicks on the button,
if the current total shown inside the fourth label is 15 or less,
the third label is filled with a randomly generated number between
1 and 11 inclusive and the total inside the fourth label is updated
to equal the sum of the three numbers in labels one, two, and three.
If the current total shown inside the fourth label is greater than 15,
nothing happens. Include a Model. Do not use XML.
 */

public class BlackJack {
    private int card1;
    private int card2;
    private int card3;
    private int total;
    private Random rn;

    public int GetCard1(){
        return card1;
    }

    public int GetCard2(){
        return card2;
    }

    public int GetCard3(){
        return card3;
    }

    public int GetTotal(){
        return total;
    }

    public BlackJack(){
        card1 = DrawCard();
        card2 = DrawCard();
        total = card1 + card2;
        rn = new Random();
    }

    public void DrawCard3(){
        if (total < 15){
            card3 = DrawCard();
            total += card3;
        }
    }

    public int DrawCard(){
        return rn.nextInt(11)+1;
    }
}
