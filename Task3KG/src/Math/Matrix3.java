package Math;
import java.util.Arrays;
public class Matrix3 {
    private double[][] elements;
    private static final double eps = 0.000001;
    public Matrix3(double[][] elements) {
        if (elements.length != 3 || elements[0].length != 3) {
            throw new IllegalArgumentException("Матрица должна иметь размер 3x3");
        }
        this.elements = elements;
    }
    public double[][] getElements() {// Геттер для получения элементов матрицы
        return elements;
    }
    public void setElements(double[][] elements) {
        if (elements.length != 3 || elements[0].length != 3) {
            throw new IllegalArgumentException("Матрица должна иметь размер 3x3");
        }
        this.elements = elements;
    }
    public double getElement(int a, int b) {// Геттер для получения элемента матрицы
        if (a>=0 && a<3 &&b>=0 && b<3){
            return elements[a][b];
        }
        throw new IllegalArgumentException("индексы за границы выходят");
    }
    public void setElement(int a, int b, double value) {
        if (a >= 0 && a < 3 && b >= 0 && b < 3) {
            elements[a][b] = value;
        } else {
            throw new IllegalArgumentException("Индексы выходят за границы матрицы");
        }
    }
    public static Matrix3 identity() {// метод для создания единичной матрицы
        double[][] identityMatrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                identityMatrix[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }
        return new Matrix3(identityMatrix);
    }
    public static Matrix3 zero() {//метод для создания нулевой матрицы
        double[][] zeroMatrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                zeroMatrix[i][j] = 0.0;
            }
        }
        return new Matrix3(zeroMatrix);
    }
    public Matrix3 divide(double scalar) {//Метод для деления матрицы на скаляр
        if (scalar == 0) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = elements[i][j] / scalar;
            }
        }
        return new Matrix3(result);
    }
    public Matrix3 transpose() {//Метод для транспонирования матрицы
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = elements[j][i];
            }
        }
        return new Matrix3(result);
    }
    public double determinant() {
        if (elements.length != 3 || elements[0].length != 3) {
            throw new IllegalArgumentException("Матрица должна иметь размер 3x3");
        }
        double a = elements[0][0];
        double b = elements[0][1];
        double c = elements[0][2];
        double d = elements[1][0];
        double e = elements[1][1];
        double f = elements[1][2];
        double g = elements[2][0];
        double h = elements[2][1];
        double i = elements[2][2];
        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
    }

    public static Matrix3 add(Matrix3 matrix1, Matrix3 matrix2) {//метод для сложения двух матриц
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1.elements[i][j] + matrix2.elements[i][j];
            }
        }
        return new Matrix3(result);
    }
    public static Matrix3 subtract(Matrix3 matrix1, Matrix3 matrix2) {//метод для вычитания двух матриц
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1.elements[i][j] - matrix2.elements[i][j];
            }
        }
        return new Matrix3(result);
    }
    public Matrix3 multiplyScalar(double scalar) {//Метод для умножения матрицы на скаляр
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = elements[i][j] * scalar;
            }
        }
        return new Matrix3(result);
    }
    public Matrix3 multiplyVector(Vector3 vector) {//метод для умножения матрицы на вектор
        double[] vectorElements = vector.getElements();
        double[][] resultElements = new double[3][3]; // Размерность результата - 3x3

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultElements[i][j] = elements[i][j] * vectorElements[j];
            }
        }

        return new Matrix3(resultElements);
    }

    public static Matrix3 multiply(Matrix3 matrix1, Matrix3 matrix2) {//метод для перемножения двух матриц
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1.elements[i][k] * matrix2.elements[k][j];
                }
            }
        }
        return new Matrix3(result);
    }
    public Matrix3 inverse() {
        double[][] mat = elements;
        double[][] result = new double[3][3];
        double det = determinant();
        if (Math.abs(det) < 1e-10) {
            throw new ArithmeticException("Матрица вырождена, обратной матрицы не существует");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double cofactor = cofactor(i, j, mat);
                result[j][i] = cofactor / det;
            }
        }
        return new Matrix3(result);
    }
    private double cofactor(int row, int col, double[][] mat) {
        double[][] subMatrix = new double[2][2];
        int subRow = 0, subCol = 0;

        for (int i = 0; i < 3; i++) {
            if (i == row) continue;
            subCol = 0;
            for (int j = 0; j < 3; j++) {
                if (j == col) continue;
                subMatrix[subRow][subCol] = mat[i][j];
                subCol++;
            }
            subRow++;
        }
        double determinant = subMatrix[0][0] * subMatrix[1][1] - subMatrix[0][1] * subMatrix[1][0];
        if ((row + col) % 2 == 0) {
            return determinant;
        } else {
            return -determinant;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : elements) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
    public static boolean equalsM3(Matrix3 matrix1,Matrix3 matrix2) {
        double[][] elements1 = matrix1.getElements();
        double[][] elements2 = matrix2.getElements();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.abs(elements1[i][j] - elements2[i][j])>eps) {
                    return false;
                }
            }
        }
        return true;
    }
}