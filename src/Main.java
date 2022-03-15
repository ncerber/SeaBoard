import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SeaBoard board = new SeaBoard();
        board.shoot(1,1,"h");
        board.shoot(3,1,"h");
        board.shoot(2,1,"d");

        board.shoot(0,3,"d");

        board.shoot(4,2,"h");
        board.shoot(4,3,"h");
        board.shoot(4,5,"h");
        board.shoot(4,4,"d");

        String[][] pArr = board.getField();
        for (int i = 0; i < pArr.length; i++) {
            System.out.println(Arrays.toString(pArr[i]));
        }
    }
}
