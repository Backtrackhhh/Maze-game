package Server;

import Core.Core;

import java.io.*;
import java.util.Scanner;

public class Server {

private int[][] box;
private int[] pos;

    public void setBox(){
        box = Core.testMap;
    }

    public void setPos(int x,int y){
        pos[0] = x;
        pos[1] = y;
    }
    public void saveGame() {
        try {
            checkDirectory("save");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./save/1.save"));
            oos.writeObject(box);
            oos.writeObject(pos);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkDirectory(String name) {
        File file = new File(name);
        if (!file.exists() || file.isFile())
            while (!file.mkdir()) {
                System.out.println("can not create directory: " + name);
            }
    }

    public void loadGame() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./save/1.save"));
            try {
                box = (int[][]) ois.readObject();
                pos = (int[]) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadExternalMap(File file) {
        try {
            Scanner in = new Scanner(file);
            int height = in.nextInt();
            int width = in.nextInt();
            int[][] map = new int[height][width];
            int[] pos = new int[]{1, 1};
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int num = in.nextInt();
                    switch (num) {
                        case 1:
                            map[i][j] = 1;
                            break;
                        case 0:
                            map[i][j] = 0;
                            break;
                        case 2:
                            map[i][j] = 2;
                            break;
                        case 3:
                            map[i][j] = 3;
                            break;
                        case 4:
                            map[i][j] = 4;
                            break;
                        case 5:
                            map[i][j] = 5;
                            pos = new int[]{i, j};
                            break;
                    }
                }
            }
            this.box = map;
            this.pos = pos;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}