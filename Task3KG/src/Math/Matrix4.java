package Math;
import java.util.Arrays;
public class Matrix4 {
    private static final double eps = 0.000001;
    private double[][] elements;
    public Matrix4(double[][] elements) {
        if (elements.length != 4 || elements[0].length != 4) {
            throw new IllegalArgumentException("Матрица должна иметь размер 4x4");
        }
        this.elements = elements;
    }
    public double[][] getElements() {
        return elements;
    }
    public void setElements(double[][] elements) {
        if (elements.length != 4 || elements[0].length != 4) {
            throw new IllegalArgumentException("Матрица должна иметь размер 4x4");
        }
        this.elements = elements;
    }
    public double getElement(int row, int column) {
        if (row >= 0 && row < 4 && column >= 0 && column < 4) {
            return elements[row][column];
        }
        throw new IllegalArgumentException("Индексы выходят за границы матрицы");
    }
    public void setElement(int row, int column, double value) {
        if (row >= 0 && row < 4 && column >= 0 && column < 4) {
            elements[row][column] = value;
        } else {
            throw new IllegalArgumentException("Индексы выходят за границы матрицы");
        }
    }
    public static Matrix4 identity() {// метод для создания единичной матрицы
        double[][] identityMatrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                identityMatrix[i][j] = (i == j) ? 1.0 : 0.0;
            }
        }
        return new Matrix4(identityMatrix);
    }
    public static Matrix4 zero() {//метод для создания нулевой матрицы
        double[][] zeroMatrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                zeroMatrix[i][j] = 0.0;
            }
        }
        return new Matrix4(zeroMatrix);
    }
    public Matrix4 divide(double scalar) {//Метод для деления матрицы на скаляр
        if (scalar == 0) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = elements[i][j] / scalar;
            }
        }
        return new Matrix4(result);
    }
    public Matrix4 transpose() {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = elements[j][i];
            }
        }
        return new Matrix4(result);
    }
    public double determinant() {
        double[][] mat = elements;
        double det = 0;

        for (int i = 0; i < 4; i++) {
            det += mat[0][i] * cofactor(0, i, mat);
        }
        return det;
    }

    private double cofactor(int row, int col, double[][] mat) {
        double[][] minor = new double[3][3];
        int minorRow, minorCol;
        int n = 3; // Размерность минора

        for (int i = 0; i < n; i++) {
            minorRow = (i < row) ? i : i + 1;
            for (int j = 0; j < n; j++) {
                minorCol = (j < col) ? j : j + 1;
                minor[i][j] = mat[minorRow][minorCol];
            }
        }
        double minorDeterminant = minorDeterminant(minor);
        return ((row + col) % 2 == 0) ? minorDeterminant : -minorDeterminant;
    }
    private double minorDeterminant(double[][] mat) {
        if (mat.length != 3 || mat[0].length != 3) {
            throw new IllegalArgumentException("Минор должен иметь размер 3x3");
        }
        double det = 0;
        det += mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]);
        det -= mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0]);
        det += mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);

        return det;
    }
    public static Matrix4 add(Matrix4 matrix1, Matrix4 matrix2) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = matrix1.elements[i][j] + matrix2.elements[i][j];
            }
        }
        return new Matrix4(result);
    }
    public static Matrix4 subtract(Matrix4 matrix1, Matrix4 matrix2) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = matrix1.elements[i][j] - matrix2.elements[i][j];
            }
        }
        return new Matrix4(result);
    }
    public Matrix4 multiplyScalar(double scalar) {//Метод для умножения матрицы на скаляр
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = elements[i][j] * scalar;
            }
        }
        return new Matrix4(result);
    }
    public Matrix4 multiplyVector(Vector4 vector) {
        double[] vectorElements = vector.getElements();
        double[][] resultElements = new double[4][4]; // Размерность результата - 4x4

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultElements[i][j] = elements[i][j] * vectorElements[j];
            }
        }

        return new Matrix4(resultElements);
    }
    public static Matrix4 multiply(Matrix4 matrix1, Matrix4 matrix2) {
        double[][] result = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result[i][j] += matrix1.elements[i][k] * matrix2.elements[k][j];
                }
            }
        }
        return new Matrix4(result);
    }
    public Matrix4 inverse() {
        double[][] mat = elements;
        double[][] result = new double[4][4];
        double[][] augmentedMatrix = new double[4][8];

        // Создаем расширенную матрицу [mat | I], где I - единичная матрица
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                augmentedMatrix[i][j] = mat[i][j];
                augmentedMatrix[i][j + 4] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Приводим расширенную матрицу к диагональному виду с помощью метода Гаусса-Жордана
        for (int pivotRow = 0; pivotRow < 4; pivotRow++) {
            double pivot = augmentedMatrix[pivotRow][pivotRow];

            // Делаем текущий элемент на диагонали равным 1
            for (int j = 0; j < 8; j++) {
                augmentedMatrix[pivotRow][j] /= pivot;
            }

            // Обнуляем остальные элементы в текущем столбце
            for (int i = 0; i < 4; i++) {
                if (i != pivotRow) {
                    double factor = augmentedMatrix[i][pivotRow];
                    for (int j = 0; j < 8; j++) {
                        augmentedMatrix[i][j] -= factor * augmentedMatrix[pivotRow][j];
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) { // Извлекаем обратную матрицу из расширенной матрицы
            for (int j = 0; j < 4; j++) {
                result[i][j] = augmentedMatrix[i][j + 4];
            }
        }

        return new Matrix4(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : elements) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
    public static boolean equalsM4(Matrix4 matrix1, Matrix4 matrix2) {
        double[][] elements1 = matrix1.getElements();
        double[][] elements2 = matrix2.getElements();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Math.abs(elements1[i][j] - elements2[i][j])>eps) {
                    System.out.println(elements1[i][j]);
                    System.out.println( elements2[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

}
