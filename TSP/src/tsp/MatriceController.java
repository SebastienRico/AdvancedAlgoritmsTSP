package tsp;

public class MatriceController {

    public static Double[][] createBasicMatrice() {
        Double[][] matrice = new Double[4][4];
        
        matrice[0][0] = 0d;
        matrice[0][1] = 4d;
        matrice[0][2] = 3d;
        matrice[0][3] = 1d;

        matrice[1][0] = 4d;
        matrice[1][1] = 0d;
        matrice[1][2] = 1d;
        matrice[1][3] = 2d;

        matrice[2][0] = 3d;
        matrice[2][1] = 1d;
        matrice[2][2] = 0d;
        matrice[2][3] = 5d;

        matrice[3][0] = 1d;
        matrice[3][1] = 2d;
        matrice[3][2] = 5d;
        matrice[3][3] = 0d;
        
        return matrice;
    }

}
