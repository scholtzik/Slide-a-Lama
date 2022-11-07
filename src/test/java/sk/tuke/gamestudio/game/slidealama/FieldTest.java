package sk.tuke.gamestudio.game.slidealama;

//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;


public class FieldTest {

    private void testFieldTest(){
        var field = new Field(5,5);
        field.initialize();
        for(int i =0;i<5;i++){
            for(int j= 0;j<5;j++){
                System.out.print(field.getTiles()[i][j].getValue() + " ");
            }
            System.out.println();
        }
        field.insertLeft(0,new Tile(9));
        System.out.println();
        for(int i =0;i<5;i++){
            for(int j= 0;j<5;j++){
                System.out.print(field.getTiles()[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
