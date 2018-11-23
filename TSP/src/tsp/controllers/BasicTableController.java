package tsp.controllers;

public class BasicTableController {

    public static Double[][] createBasicTable2() {
        Double[][] table = new Double[5][5];

        table[0][0] = 0d;
        table[0][1] = 2d;
        table[0][2] = 5d;
        table[0][3] = 3d;
        table[0][4] = 6d;

        table[1][0] = 2d;
        table[1][1] = 0d;
        table[1][2] = 4d;
        table[1][3] = 3d;
        table[1][4] = 5d;

        table[2][0] = 5d;
        table[2][1] = 4d;
        table[2][2] = 0d;
        table[2][3] = 7d;
        table[2][4] = 3d;

        table[3][0] = 3d;
        table[3][1] = 3d;
        table[3][2] = 7d;
        table[3][3] = 0d;
        table[3][4] = 3d;

        table[4][0] = 6d;
        table[4][1] = 5d;
        table[4][2] = 3d;
        table[4][3] = 3d;
        table[4][4] = 0d;

        return table;
    }

    public static Double[][] createBasicTable() {
        Double[][] table = new Double[4][4];

        table[0][0] = 0d;
        table[0][1] = 4d;
        table[0][2] = 3d;
        table[0][3] = 1d;

        table[1][0] = 4d;
        table[1][1] = 0d;
        table[1][2] = 1d;
        table[1][3] = 2d;

        table[2][0] = 3d;
        table[2][1] = 1d;
        table[2][2] = 0d;
        table[2][3] = 5d;

        table[3][0] = 1d;
        table[3][1] = 2d;
        table[3][2] = 5d;
        table[3][3] = 0d;

        return table;
    }
}
