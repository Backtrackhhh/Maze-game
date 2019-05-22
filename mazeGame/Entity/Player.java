package Entity;

import Core.Core;

import java.util.Scanner;

public class Player extends Entity implements Alive,Moveable {
    private int blood;
    private int x;
    private int y;
    @Override
    public void setBlood() {
     blood = 3;
    }

    @Override
    public void move() {
        Scanner inp = new Scanner(System.in);
        String some = inp.next();
        switch (some){
            case "a" :
                y--;
                if (isUnmoveable())
                    y++;
            case"d":
                y++;
                if (isUnmoveable())
                    y--;
            case "w":
                x--;
                if (isUnmoveable())
                    x++;
            case "s":
                x++;
                if (isUnmoveable())
                    x--;
        }
    }

    public boolean isUnmoveable(){
        if(Core.testMap[x][y]==1|| Core.testMap[x][y]==3){
            return true;
        }
        else
            return false;
    }

    public int getBlood() {
        return blood;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
