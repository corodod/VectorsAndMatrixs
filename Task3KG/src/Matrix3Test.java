//import Math.Matrix3;
//import Math.Vector3;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static Math.Matrix3.equalsM3;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class Matrix3Test {
//
//    private final double eps = 0.0000001;
//
//    @Test
//    public void testMatrixMultiplicationByScalar() {
//        double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//        Matrix3 matrix = new Matrix3(elements);
//        double scalar = 2.0;
//        Matrix3 product = matrix.multiplyScalar(scalar);
//        double[][] expectedElements = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};
//
//        assertTrue(Arrays.deepEquals(product.getElements(), expectedElements));
//    }
//
//    @Test
//    public void testMatrixDivisionByScalar() {
//        double[][] elements = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};
//        Matrix3 matrix = new Matrix3(elements);
//        double scalar = 2.0;
//        Matrix3 quotient = matrix.divide(scalar);
//        double[][] expectedElements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//
//        assertTrue(Arrays.deepEquals(quotient.getElements(), expectedElements));
//    }
//
//    @Test
//    public void testMatrixTranspose() {
//        double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//        Matrix3 matrix = new Matrix3(elements);
//        Matrix3 transposedMatrix = matrix.transpose();
//        double[][] expectedElements = {{1.0, 4.0, 7.0}, {2.0, 5.0, 8.0}, {3.0, 6.0, 9.0}};
//
//        assertTrue(Arrays.deepEquals(transposedMatrix.getElements(), expectedElements));
//    }
//
//    @Test
//    public void testMatrixMultiplicationByVector() {
//        double[][] elements = {{1.0, 2.0, 3.0},
//                                {4.0, 5.0, 6.0},
//                                {7.0, 8.0, 9.0}};
//        Matrix3 matrix = new Matrix3(elements);
//        Vector3 vector = new Vector3(1.0, 2.0, 3.0);
//        Matrix3 product = matrix.multiplyVector(vector);
//        System.out.println(product.toString());
//        double[][] elem = {{1.0, 4.0, 9.0},
//                            {4.0, 10.0, 18.0},
//                            {7.0, 16.0, 27.0}};
//        Matrix3 fmatrix = new Matrix3(elem);
//
//
//        assertTrue(equalsM3(fmatrix,product));
//    }
//
//    @Test
//    public void testMatrixMultiplication() {
//        double[][] elements1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//        double[][] elements2 = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}};
//        Matrix3 matrix1 = new Matrix3(elements1);
//        Matrix3 matrix2 = new Matrix3(elements2);
//        Matrix3 product = Matrix3.multiply(matrix1,matrix2);
//        double[][] expectedElements = {{30.0, 24.0, 18.0}, {84.0, 69.0, 54.0}, {138.0, 114.0, 90.0}};
//
//        assertTrue(Arrays.deepEquals(product.getElements(), expectedElements));
//    }
//
//    @Test
//    public void testMatrixInverse() {
//        double[][] elements = {{1.0, 2.0, 3.0}, {0.0, 1.0, 4.0}, {5.0, 6.0, 0.0}};
//        Matrix3 matrix = new Matrix3(elements);
//        Matrix3 inverseMatrix = matrix.inverse();
//        double[][] expectedElements = {{-24.0, 18.0, 5.0}, {20.0, -15.0, -4.0}, {-5.0, 4.0, 1.0}};
//        //System.out.println(inverseMatrix.toString());
//
//        assertTrue(Arrays.deepEquals(inverseMatrix.getElements(), expectedElements));
//    }
//
//    @Test
//    public void testMatrixDeterminant() {
//        double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
//        double determinant = Matrix3.determinant(elements);
//        double expectedDeterminant = 0.0;
//
//        assertEquals(expectedDeterminant, determinant, eps);
//    }
//}
import Math.Matrix3;
import Math.Vector3;
import org.junit.jupiter.api.Test;
import static Math.Matrix3.equalsM3;
import static Math.Matrix4.equalsM4;
import static org.junit.jupiter.api.Assertions.*;



public class Matrix3Test {

    private final double epsilon = 0.0000001;

    @Test
    public void testMatrixMultiplicationByScalar() {
        double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix3 matrix = new Matrix3(elements);
        double scalar = 2.0;
        Matrix3 product = matrix.multiplyScalar(scalar);
        double[][] expectedElements = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};

        assertTrue(equalsM3(product, new Matrix3(expectedElements)));
    }

    @Test
    public void testMatrixVectorMultiplication() {
        double[][] elements = {{1.0, 2.0, 3.0},
                                {4.0, 5.0, 6.0},
                                {7.0, 8.0, 9.0}};
        Matrix3 matrix = new Matrix3(elements);
        Vector3 vector = new Vector3(1.0, 2.0, 3.0);
        Matrix3 result = matrix.multiplyVector(vector);

        double[][] expectedElements = {{1.0, 4.0, 9.0},
                                        {4.0, 10.0, 18.0},
                                        {7.0, 16.0, 27.0}};
        Matrix3 exres = new Matrix3(expectedElements);

        assertTrue(equalsM3(exres, result));
    }

    @Test
    public void testMatrixMultiplication() {
        double[][] elements1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] elements2 = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}};
        Matrix3 matrix1 = new Matrix3(elements1);
        Matrix3 matrix2 = new Matrix3(elements2);

        Matrix3 result = Matrix3.multiply(matrix1, matrix2);

        double[][] expectedElements = {{30.0, 24.0, 18.0}, {84.0, 69.0, 54.0}, {138.0, 114.0, 90.0}};

        assertTrue(Matrix3.equalsM3(new Matrix3(expectedElements), result));
    }

    @Test
    public void testMatrixTranspose() {
        double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix3 matrix = new Matrix3(elements);
        Matrix3 transposed = matrix.transpose();
        double[][] expectedElements = {{1.0, 4.0, 7.0}, {2.0, 5.0, 8.0}, {3.0, 6.0, 9.0}};

        assertTrue(equalsM3(transposed, new Matrix3(expectedElements)));
    }

    @Test
    public void testMatrixInverse() {
        double[][] elements = {{1.0, 2.0, 1.0},
                                {2.0, 3.0, 3.0},
                                {1.0, 2.0, 4.0}};
        Matrix3 matrix = new Matrix3(elements);
        Matrix3 inverseMatrix = matrix.inverse();
        double[][] expectedElements = {{-2.0, 2.0, -1.0},
                                        {1.6666666666667, -1.0, 0.3333333333333334},
                                        {-0.3333333333333334, 0.0, 0.3333333333333334}};
        Matrix3 matrixEx = new Matrix3(expectedElements);
        System.out.println(inverseMatrix.toString());
        System.out.println(matrixEx.toString());

        assertTrue(equalsM3(matrixEx, inverseMatrix));
    }


    @Test
    public void testMatrixDeterminant() {
        double[][] elements = {{1.0, 2.0, 1.0},
                                {2.0, 3.0, 3.0},
                                {1.0, 2.0, 4.0}};
        Matrix3 matrix = new Matrix3(elements);
        double determinant = matrix.determinant();

        double expectedDeterminant = -3.0;

         assertEquals(expectedDeterminant, determinant, epsilon);
    }

    @Test
    public void testMatrixAddition() {
        double[][] elements1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] elements2 = {{4.0, 3.0, 2.0}, {8.0, 7.0, 6.0}, {12.0, 11.0, 10.0}};
        Matrix3 matrix1 = new Matrix3(elements1);
        Matrix3 matrix2 = new Matrix3(elements2);
        Matrix3 result = Matrix3.add(matrix1, matrix2);
        double[][] expectedElements = {{5.0, 5.0, 5.0},
                                       {12.0, 12.0, 12.0},
                                       {19.0, 19.0, 19.0}};

        assertTrue(equalsM3(new Matrix3(expectedElements), result));
    }

    @Test
    public void testMatrixSubtraction() {
        double[][] elements1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] elements2 = {{4.0, 3.0, 2.0}, {8.0, 7.0, 6.0}, {12.0, 11.0, 10.0}};
        Matrix3 matrix1 = new Matrix3(elements1);
        Matrix3 matrix2 = new Matrix3(elements2);
        Matrix3 result = Matrix3.subtract(matrix1, matrix2);
        double[][] expectedElements = {{-3.0, -1.0, 1.0}, {-4.0, -2.0, 0.0}, {-5.0, -3.0, -1.0}};

        assertTrue(equalsM3(new Matrix3(expectedElements), result));
    }

    @Test
    public void testIdentityMatrix() {
        Matrix3 identityMatrix = Matrix3.identity();
        double[][] expectedElements = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};

        assertTrue(equalsM3(new Matrix3(expectedElements), identityMatrix));
    }

    @Test
    public void testZeroMatrix() {
        Matrix3 zeroMatrix = Matrix3.zero();
        double[][] expectedElements = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};

        assertTrue(equalsM3(new Matrix3(expectedElements), zeroMatrix));
    }

    @Test
    public void testMatrixDivisionByScalar() {
        double[][] elements = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};
        Matrix3 matrix = new Matrix3(elements);
        double scalar = 2.0;
        Matrix3 result = matrix.divide(scalar);
        double[][] expectedElements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};

        assertTrue(equalsM3(new Matrix3(expectedElements), result));
    }

        @Test
        public void testGetElement() {
            double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
            Matrix3 matrix = new Matrix3(elements);

            assertEquals(5.0, matrix.getElement(1, 1));
            assertEquals(8.0, matrix.getElement(2, 1));
            assertEquals(3.0, matrix.getElement(0, 2));

            assertThrows(IllegalArgumentException.class, () -> matrix.getElement(-1, 0));
            assertThrows(IllegalArgumentException.class, () -> matrix.getElement(0, -1));
            assertThrows(IllegalArgumentException.class, () -> matrix.getElement(3, 0));
            assertThrows(IllegalArgumentException.class, () -> matrix.getElement(0, 3));
        }

        @Test
        public void testSetElement() {
            double[][] elements = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
            Matrix3 matrix = new Matrix3(elements);

            matrix.setElement(0, 0, 0.0);
            matrix.setElement(2, 1, 100.0);

            assertEquals(0.0, matrix.getElement(0, 0));
            assertEquals(100.0, matrix.getElement(2, 1));

            assertThrows(IllegalArgumentException.class, () -> matrix.setElement(-1, 0, 0.0));
            assertThrows(IllegalArgumentException.class, () -> matrix.setElement(0, -1, 0.0));
            assertThrows(IllegalArgumentException.class, () -> matrix.setElement(3, 0, 0.0));
            assertThrows(IllegalArgumentException.class, () -> matrix.setElement(0, 3, 0.0));
        }

    @Test
    public void testMatrixEquality() {
        double[][] elements1 = {{1.0, 2.0, 3.0}, {5.0, 6.0, 7.0}, {9.0, 10.0, 11.0}};
        Matrix3 matrix1 = new Matrix3(elements1);
        double[][] elements2 = {{1.0, 2.0, 3.0}, {5.0, 6.0, 7.0}, {9.0, 10.0, 11.0}};
        Matrix3 matrix2 = new Matrix3(elements2);

        boolean matrixEquality1 = equalsM3(matrix1, matrix2);
        boolean arrayEquality = areArraysEqual(elements1, elements2, epsilon);

        assertTrue(arrayEquality, String.valueOf(matrixEquality1));
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

