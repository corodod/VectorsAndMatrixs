import Math.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2Test {

    private final double eps = 0.0000001;

    @Test
    public void testVectorEquality() {
        Vector2 vector1 = new Vector2(1.0, 2.0);
        Vector2 vector2 = new Vector2(1.0, 2.0);

        double[] elements1 = vector1.getElements();
        double[] elements2 = vector2.getElements();
        boolean elementsEqual = true;
        for (int i = 0; i < 2; i++) {
            if (Math.abs(elements1[i] - elements2[i]) >= eps) {
                elementsEqual = false;
                break;
            }
        }
        boolean vectorsEqual = vector1.equalsV2(vector2);// Сравниваем векторы с использованием equalsV4
        assertTrue(elementsEqual == vectorsEqual);
    }

    @Test
    public void testVectorNormalization() {
        Vector2 vector = new Vector2(3.0, 0.0);
        vector.normalize();
        Vector2 expectedVector = new Vector2(1.0, 0.0);

        assertTrue(vector.equalsV2(expectedVector));
    }

    @Test
    public void testVectorMultiplication() {
        Vector2 vector = new Vector2(2.0, 3.0);
        double scalar = 2.0;
        vector = vector.multiply(scalar);
        System.out.println(vector);
        Vector2 expectedProduct = new Vector2(4.0, 6.0);

        assertTrue(vector.equalsV2(expectedProduct));
    }

    @Test
    public void testVectorDivision() {
        Vector2 vector = new Vector2(2.0, 4.0);
        double scalar = 2.0;
        vector = vector.divide(scalar);
        Vector2 expectedQuotient = new Vector2(1.0, 2.0);

        assertTrue(vector.equalsV2(expectedQuotient));
    }

    @Test
    public void testVectorLength() {
        Vector2 vector = new Vector2(3.0, 4.0);
        double length = vector.length();
        double expectedLength = 5.0;

        assertEquals(expectedLength, length, eps);
    }

    @Test
    public void testVectorAddition() {
        Vector2 vector1 = new Vector2(1.0, 2.0);
        Vector2 vector2 = new Vector2(4.0, 5.0);
        vector1 = vector1.add(vector2);
        Vector2 expectedSum = new Vector2(5.0, 7.0);

        assertTrue(vector1.equalsV2(expectedSum));
    }

    @Test
    public void testVectorSubtraction() {
        Vector2 vector1 = new Vector2(1.0, 2.0);
        Vector2 vector2 = new Vector2(4.0, 5.0);
        Vector2 difference = Vector2.subtract(vector1, vector2);
        Vector2 expectedDifference = new Vector2(-3.0, -3.0);

        assertTrue(difference.equalsV2(expectedDifference));
    }

    @Test
    public void testVectorDotProduct() {
        Vector2 vector1 = new Vector2(1.0, 2.0);
        Vector2 vector2 = new Vector2(4.0, 5.0);
        double dotProduct = Vector2.dot(vector1, vector2);
        double expectedDotProduct = 14.0;

        assertEquals(expectedDotProduct, dotProduct, eps);
    }
}
