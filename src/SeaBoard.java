import java.util.ArrayList;

public class SeaBoard {
    private String[][] field;

    public SeaBoard() {
        this.field = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = ".";
            }
        }
    }

    public String[][] getField() {
        return field;
    }

    public String check(int line, int column) {
        return field[line][column];
    }

    public void shoot(int line, int column, String issue) {
        if (issue.equals("m")) field[line][column] = "#";
        else if (issue.equals("h")) field[line][column] = "x";
        else if (issue.equals("d")) {
            field[line][column] = "x";
            DestroyBoars(line, column);
        }
    }

    private void DestroyBoars(int line, int column) {
        int vInter = 1, hIter = 1;
        boolean isVertical = line - 1 > 0 && field[line - 1][column].equals("x");

        if (line + 1 < 10 && field[line + 1][column].equals("x")) {
            isVertical = true;
        }

        if (isVertical) {
            for (int i = line; i > 0; i--) {
                if (field[i][column].equals("x")) fillCell(i, column);
                else break;
            }

            for (int i = line; i < 10; i++) {
                if (field[i][column].equals("x")) fillCell(i, column);
                else break;
            }
        } else{
            for (int i = column; i > 0; i--) {
                if (field[line][i].equals("x")) fillCell(line, i);
                else break;
            }

            for (int i = column; i < 10; i++) {
                if (field[line][i].equals("x")) fillCell(line, i);
                else break;
            }
        }
    }

    private void fillCell(int line, int column) {
        if (line - 1 >= 0 && field[line - 1][column].equals(".")) field[line - 1][column] = "#";
        if (line + 1 < 10 && field[line + 1][column].equals(".")) field[line + 1][column] = "#";
        if (column - 1 >= 0 && field[line][column - 1].equals(".")) field[line][column - 1] = "#";
        if (column + 1 < 10 && field[line][column + 1].equals(".")) field[line][column + 1] = "#";

        if (line - 1 >= 0 && column - 1 >= 0 && field[line - 1][column - 1].equals("."))
            field[line - 1][column - 1] = "#";
        if (line - 1 >= 0 && column + 1 < 10 && field[line - 1][column + 1].equals("."))
            field[line - 1][column + 1] = "#";
        if (line + 1 < 10 && column - 1 >= 0 && field[line + 1][column - 1].equals("."))
            field[line + 1][column - 1] = "#";
        if (line + 1 < 10 && column + 1 < 10 && field[line + 1][column + 1].equals("."))
            field[line + 1][column + 1] = "#";
    }
}
