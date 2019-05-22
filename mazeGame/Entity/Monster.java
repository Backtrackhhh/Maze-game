package Entity;

public class Monster extends Entity implements Alive,Moveable{
   private int monsx;
   private int monsy;
   private int blood;
    public void move(){
        int ranm = (int)(Math.random() * 5);
        switch (ranm){
            case 1 :
                monsx++;
                break;
            case 2 :
                monsx--;
                break;
            case 3 :
                monsy++;
                break;
            case 4 :
                monsy--;
            case 0 :
                return;
        }
    }
    public void setBlood(){
        blood = 3;
    }

    public int getBlood() {
        return blood;
    }

    public int getMonsx() {
        return monsx;
    }

    public int getMonsy() {
        return monsy;
    }
}
