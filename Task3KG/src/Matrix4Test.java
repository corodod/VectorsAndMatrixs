import Math.Matrix4;
import Math.Vector4;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static Math.Matrix4.equalsM4;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Matrix4Test {

    private final double epsilon = 0.0000001;

    @Test
    public void testMatrixMultiplicationByScalar() {
        double[][] elements = {{1.0, 2.0, 3.0, 4.0},
                {5.0, 6.0, 7.0, 8.0},
                {9.0, 10.0, 11.0, 12.0},
                {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix = new Matrix4(elements);
        double scalar = 2.0;
        Matrix4 product = matrix.multiplyScalar(scalar);
        double[][] expectedElements = {{2.0, 4.0, 6.0, 8.0}, {10.0, 12.0, 14.0, 16.0}, {18.0, 20.0, 22.0, 24.0}, {26.0, 28.0, 30.0, 32.0}};

        assertTrue(equalsM4(product, new Matrix4(expectedElements)));
    }

    @Test
    public void testMatrixVectorMultiplication() {
        double[][] elements = {{1.0, 2.0, 3.0, 4.0},
                {5.0, 6.0, 7.0, 8.0},
                {9.0, 10.0, 11.0, 12.0},
                {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix = new Matrix4(elements);
        Vector4 vector = new Vector4(1.0, 2.0, 3.0, 4.0);
        Matrix4 result = matrix.multiplyVector(vector);
        double[][] elem = {{1.0, 4.0, 9.0, 16.0},
                {5.0, 12.0, 21.0, 32.0},
                {9.0, 20.0, 33.0, 48.0},
                {13.0, 28.0, 45.0, 64.0}};
        Matrix4 expected = new Matrix4(elem);
        System.out.println(result.toString());

        assertTrue(equalsM4(expected, result));
    }

    @Test
    public void testMatrixMultiplication() {
        double[][] elements1 = {{1.0, 2.0, 3.0, 4.0},
                {5.0, 6.0, 7.0, 8.0},
                {9.0, 10.0, 11.0, 12.0},
                {13.0, 14.0, 15.0, 16.0}};
        double[][] elements2 = {{16.0, 15.0, 14.0, 13.0},
                {12.0, 11.0, 10.0, 9.0},
                {8.0, 7.0, 6.0, 5.0},
                {4.0, 3.0, 2.0, 1.0}};
        Matrix4 matrix1 = new Matrix4(elements1);
        Matrix4 matrix2 = new Matrix4(elements2);

        Matrix4 result = Matrix4.multiply(matrix1, matrix2);

        double[][] expectedElements = {
                {80.0, 70.0, 60.0, 50.0},
                {240.0, 214.0, 188.0, 162.0},
                {400.0, 358.0, 316.0, 274.0},
                {560.0, 502.0, 444.0, 386.0}
        };

        assertTrue(equalsM4(new Matrix4(expectedElements), result));
    }

    @Test
    public void testMatrixTranspose() {
        double[][] elements = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix = new Matrix4(elements);
        Matrix4 transposed = matrix.transpose();
        double[][] expectedElements = {{1.0, 5.0, 9.0, 13.0}, {2.0, 6.0, 10.0, 14.0}, {3.0, 7.0, 11.0, 15.0}, {4.0, 8.0, 12.0, 16.0}};

        assertTrue(equalsM4(transposed, new Matrix4(expectedElements)));
    }

    @Test
    public void testMatrixInverse() {
        double[][] elements = {{1.0, 2.0, 1.0, 2.0},
                {2.0, 3.0, 3.0, 2.0},
                {1.0, 2.0, 4.0, 1.0},
                {3.0, 4.0, 1.0, 2.0}};
        Matrix4 matrix = new Matrix4(elements);
        Matrix4 inverseMatrix = matrix.inverse();
        double[][] expectedElements = {{-1.75, 3.5, -2.0, -0.75},
                {1.25, -3.5, 2.0, 1.25},
                {-0.25, 0.5, 0, -0.25},
                {0.25, 1.5, -1.0, -0.75}};
        Matrix4 matrixWWW = new Matrix4(expectedElements);
        System.out.println(inverseMatrix.toString());
        assertTrue(equalsM4(matrixWWW, inverseMatrix));
    }

    @Test
    public void testMatrixDeterminant() {
        double[][] elements = {{1.0, 2.0, 1.0, 2.0},
                {2.0, 3.0, 3.0, 2.0},
                {1.0, 2.0, 4.0, 1.0},
                {3.0, 4.0, 1.0, 2.0}};
        Matrix4 matrix = new Matrix4(elements);
        double determinant = matrix.determinant();

        double expectedDeterminant = 4.0;

        assertEquals(expectedDeterminant, determinant, epsilon);
    }

    @Test
    public void testMatrixAddition() {
        double[][] elements1 = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        double[][] elements2 = {{4.0, 3.0, 2.0, 1.0}, {8.0, 7.0, 6.0, 5.0}, {12.0, 11.0, 10.0, 9.0}, {16.0, 15.0, 14.0, 13.0}};
        Matrix4 matrix1 = new Matrix4(elements1);
        Matrix4 matrix2 = new Matrix4(elements2);
        Matrix4 result = Matrix4.add(matrix1, matrix2);
        double[][] expectedElements = {{5.0, 5.0, 5.0, 5.0}, {13.0, 13.0, 13.0, 13.0}, {21.0, 21.0, 21.0, 21.0}, {29.0, 29.0, 29.0, 29.0}};

        assertTrue(equalsM4(result, new Matrix4(expectedElements)));
    }

    @Test
    public void testMatrixSubtraction() {
        double[][] elements1 = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        double[][] elements2 = {{4.0, 3.0, 2.0, 1.0}, {8.0, 7.0, 6.0, 5.0}, {12.0, 11.0, 10.0, 9.0}, {16.0, 15.0, 14.0, 13.0}};
        Matrix4 matrix1 = new Matrix4(elements1);
        Matrix4 matrix2 = new Matrix4(elements2);
        Matrix4 result = Matrix4.subtract(matrix1, matrix2);
        double[][] expectedElements = {{-3.0, -1.0, 1.0, 3.0}, {-3.0, -1.0, 1.0, 3.0}, {-3.0, -1.0, 1.0, 3.0}, {-3.0, -1.0, 1.0, 3.0}};

        assertTrue(equalsM4(result, new Matrix4(expectedElements)));
    }

    @Test
    public void testIdentityMatrix() {
        Matrix4 identityMatrix = Matrix4.identity();
        double[][] expectedElements = {{1.0, 0.0, 0.0, 0.0}, {0.0, 1.0, 0.0, 0.0}, {0.0, 0.0, 1.0, 0.0}, {0.0, 0.0, 0.0, 1.0}};
        assertTrue(equalsM4(identityMatrix, new Matrix4(expectedElements)));
    }

    @Test
    public void testZeroMatrix() {
        Matrix4 zeroMatrix = Matrix4.zero();
        double[][] expectedElements = {{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}};
        assertTrue(equalsM4(zeroMatrix, new Matrix4(expectedElements)));
    }

    @Test
    public void testMatrixDivisionByScalar() {
        double[][] elements = {{2.0, 4.0, 6.0, 8.0}, {10.0, 12.0, 14.0, 16.0}, {18.0, 20.0, 22.0, 24.0}, {26.0, 28.0, 30.0, 32.0}};
        Matrix4 matrix = new Matrix4(elements);
        double scalar = 2.0;
        Matrix4 result = matrix.divide(scalar);
        double[][] expectedElements = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};

        assertTrue(equalsM4(result, new Matrix4(expectedElements)));
    }

    @Test
    public void testGetElement() {
        double[][] elements = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix = new Matrix4(elements);

        assertEquals(6.0, matrix.getElement(1, 1));
        assertEquals(12.0, matrix.getElement(2, 3));
        assertEquals(13.0, matrix.getElement(3, 0));

        assertThrows(IllegalArgumentException.class, () -> matrix.getElement(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> matrix.getElement(0, -1));
        assertThrows(IllegalArgumentException.class, () -> matrix.getElement(4, 0));
        assertThrows(IllegalArgumentException.class, () -> matrix.getElement(0, 4));
    }

    @Test
    public void testSetElement() {
        double[][] elements = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix = new Matrix4(elements);

        matrix.setElement(0, 0, 0.0);
        matrix.setElement(2, 3, 100.0);

        assertEquals(0.0, matrix.getElement(0, 0));
        assertEquals(100.0, matrix.getElement(2, 3));

        assertThrows(IllegalArgumentException.class, () -> matrix.setElement(-1, 0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> matrix.setElement(0, -1, 0.0));
        assertThrows(IllegalArgumentException.class, () -> matrix.setElement(4, 0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> matrix.setElement(0, 4, 0.0));
    }


    @Test
    public void testMatrixEquality() {
        double[][] elements1 = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix1 = new Matrix4(elements1);

        double[][] elements2 = {{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}, {9.0, 10.0, 11.0, 12.0}, {13.0, 14.0, 15.0, 16.0}};
        Matrix4 matrix2 = new Matrix4(elements2);

        boolean matrixEquality1 = equalsM4(matrix1, matrix2);

        boolean arrayEquality = areArraysEqual(elements1, elements2, epsilon);

        assertTrue(arrayEquality, String.valueOf(matrixEquality1)); // Убедимся, что двумерные массивы равны
    }
    public boolean areArraysEqual(double[][] arr1, double[][] arr2, double epsilon) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) return false;
            for (int j = 0; j < arr1[i].length; j++) {
                if (Math.abs(arr1[i][j] - arr2[i][j]) > epsilon) return false;
            }
        }
        return true;
    }
}
