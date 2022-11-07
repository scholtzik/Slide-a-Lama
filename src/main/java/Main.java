import sk.tuke.gamestudio.game.slidealama.Field;
import sk.tuke.gamestudio.game.slidealama.Tile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        var field = new Field(5,5);
        field.initialize();
        for(int i =0;i<5;i++){
            for(int j= 0;j<5;j++){
                System.out.print(field.getTiles()[i][j].getValue() + " ");
            }
            System.out.println();
        }
//        field.insertLeft(0,new Tile(9));
//        field.insertRight(2,new Tile(8));
        field.insertTop(2,new Tile(7));
        System.out.println();
        for(int i =0;i<5;i++){
            for(int j= 0;j<5;j++){
                System.out.print(field.getTiles()[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
