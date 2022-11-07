package sk.tuke.gamestudio.game.slidealama;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI {
    private final Field field;
    private final Scanner scanner;
    private static final Pattern INPUT_PATTERN = Pattern.compile("([TLR])([1-9])");
    public ConsoleUI(Field field){
        this.field=field;
        scanner=new Scanner(System.in);
    }
    public void printField(){
        for(int row = 0;row < this.field.getRowCount();row++){
            for(int col = 0; col < this.field.getColCount();col ++) {
                System.out.print(field.getTiles()[row][col].getValue() + " ");
            }
            System.out.println();
        }
    }
    public void handleInput(){
        String line = scanner.nextLine().toUpperCase();
        var matcher = INPUT_PATTERN.matcher(line);
        if(matcher.matches()){
            int position = Integer.parseInt(matcher.group(2)) - 1;
            System.out.println(" LINE INPUT " + position);
            switch (matcher.group(1)){
                case "T" : field.insertTop(position,new Tile(0)); break;
                case "L" : field.insertLeft(position,new Tile(0)); break;
                case "R" : field.insertRight(position,new Tile(0)); break;
            }
        }else{
            System.out.println("doesnt match");
        }

    }
    public void play(){
        do{
            printField();
            handleInput();
        }while(this.field.getState()==GameState.PLAYING);
        printField();
    }
}
