package sk.tuke.gamestudio.game.slidealama;
import java.util.Random;
public class Field {
    private final Tile[][] tiles;
    private final Tile[] nextTiles;
    private int rowCount;
    private int colCount;
    private int score;
    private GameState state;
    public Field(int rowCount,int colCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.tiles = new Tile[rowCount][colCount];
        this.nextTiles = new Tile[3];
        this.state= GameState.PLAYING;
        initialize();
    }
    public void initialize(){
        Random random = new Random();
        for(int row =0;row < rowCount; row++){
            for(int col=0; col<colCount; col++){
                this.tiles[row][col]= new Tile(random.nextInt(5));
            }
        }
        for(int i=0; i<3; i++){
            nextTiles[i] = new Tile(random.nextInt(5));
        }
    }
    public Tile getNextTile(){
        Random random = new Random();
        var tile=this.nextTiles[0];
        nextTiles[0]=nextTiles[1];
        nextTiles[1]=nextTiles[2];
        nextTiles[2] = new Tile(random.nextInt(5));
        return tile;
    }
    public void insertLeft(int row,Tile tile){
        for(int col = colCount-1; col>0;col--){
            tiles[row][col] = tiles[row][col-1];
        }
        tiles[row][0] = tile;
    }

    public void insertRight(int row, Tile tile){
        for(int col = 0; col<colCount-1;col++){
            tiles[row][col] = tiles[row][col+1];
        }
        tiles[row][colCount-1] = tile;
    }

    public void insertTop(int col, Tile tile){
        for(int row = rowCount-1;row > 0; row--){
            tiles[row][col]=tiles[row-1][col];
        }
        tiles[0][col]=tile;
    }

    //todo implement 4+ tile check & scoring
    public void checkHorizontal(){
        for(int row = 0; row<rowCount;row++){
            for(int col = 0; col< colCount -2; col++){
                if(tiles[row][col] == tiles[row][col+1] && tiles[row][col] == tiles[row][col+2]){
                    tiles[row][col]=null;
                    tiles[row][col+1]=null;
                    tiles[row][col+2]=null;
                    score += 100;
                }
            }
        }
    }

    public void checkVertical(){
        for(int row = 0; row < rowCount - 2;row++){
            for(int col = 0; col< colCount; col++){
                if(tiles[row][col] == tiles[row+1][col] && tiles[row][col] == tiles[row-2][col]){
                    tiles[row][col]=null;
                    tiles[row+1][col]=null;
                    tiles[row+2][col]=null;
                    score += 100;
                }
            }
        }
    }


    public Tile[][] getTiles() {
        return tiles;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
