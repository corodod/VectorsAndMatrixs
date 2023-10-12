import Math.Vector3;
import org.junit.jupiter.api.Test;

import static Math.Vector3.subtract;
import static org.junit.jupiter.api.Assertions.*;

public class Vector3Test {
    private final double eps = 0.000001;
    @Test
    public void testVectorEquality() {
        Vector3 vector1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 vector2 = new Vector3(1.0, 2.0, 3.0);

        double[] elements1 = vector1.getElements();
        double[] elements2 = vector2.getElements();
        boolean elementsEqual = true;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(elements1[i] - elements2[i]) >= eps) {
                elementsEqual = false;
                break;
            }
        }
        boolean vectorsEqual = vector1.equalsV3(vector2);// Сравниваем векторы с использованием equalsV4
        assertTrue(elementsEqual == vectorsEqual);
    }

    @Test
    public void testVectorNormalization() {
        Vector3 vector = new Vector3(3.0, 0.0, 4.0);
        vector.normalize();
        Vector3 expectedVector = new Vector3(0.6, 0.0, 0.8);
        assertTrue(vector.equalsV3(expectedVector));
    }
    @Test
    public void testVectorCrossProduct() {
        Vector3 vector1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 vector2 = new Vector3(4.0, 5.0, 6.0);
        Vector3 crossProduct = Vector3.cross(vector1, vector2);
        Vector3 expectedCrossProduct = new Vector3(-3.0, 6.0, -3.0);
        assertTrue(crossProduct.equalsV3(expectedCrossProduct));
    }
    @Test
    public void testVectorDotProduct() {
        Vector3 vector1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 vector2 = new Vector3(4.0, 5.0, 6.0);
        double dotProduct = Vector3.dot(vector1, vector2);
        double expectedDotProduct = 32.0;
        assertEquals(expectedDotProduct, dotProduct, eps);
    }
    @Test
    public void testVectorLength() {
        Vector3 vector = new Vector3(3.0, 4.0, 0.0);
        double length = vector.length();
        double expectedLength = 5.0;
        assertEquals(expectedLength, length, eps);
    }
    @Test
    public void testVectorAddition() {
        Vector3 vector1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 vector2 = new Vector3(4.0, 5.0, 6.0);
        Vector3 sum = vector1.add(vector2);
        Vector3 expectedSum = new Vector3(5.0, 7.0, 9.0);
        assertTrue(sum.equalsV3(expectedSum));
    }
    @Test
    public void testVectorSubtraction() {
        Vector3 vector1 = new Vector3(1.0, 2.0, 3.0);
        Vector3 vector2 = new Vector3(4.0, 5.0, 6.0);
        Vector3 difference = Vector3.subtract(vector1, vector2);
        Vector3 expectedDifference = new Vector3(-3.0, -3.0, -3.0);
        assertTrue(difference.equalsV3(expectedDifference));
    }
    @Test
    public void testVectorMultiplication() {
        Vector3 vector = new Vector3(2.0, 3.0, 4.0);
        double scalar = 2.0;
        Vector3 product = vector.multiply(scalar);
        Vector3 expectedProduct = new Vector3(4.0, 6.0, 8.0);
        assertTrue(product.equalsV3(expectedProduct));
    }
    @Test
    public void testVectorDivision() {
        Vector3 vector = new Vector3(2.0, 4.0, 6.0);
        double scalar = 2.0;
        Vector3 quotient = vector.divide(scalar);
        Vector3 expectedQuotient = new Vector3(1.0, 2.0, 3.0);
        assertTrue(quotient.equalsV3(expectedQuotient));
    }
}
