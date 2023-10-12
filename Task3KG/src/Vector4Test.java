import Math.Vector4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector4Test {

    private final double eps = 0.000001;

    @Test
    public void testVectorEquality() {
        Vector4 vector1 = new Vector4(1.0, 2.0, 3.0, 4.0);
        Vector4 vector2 = new Vector4(1.0, 2.0, 3.0, 4.0);

        double[] elements1 = vector1.getElements();
        double[] elements2 = vector2.getElements();
        boolean elementsEqual = true;
        for (int i = 0; i < 4; i++) {
            if (Math.abs(elements1[i] - elements2[i]) >= eps) {
                elementsEqual = false;
                break;
            }
        }
        boolean vectorsEqual = vector1.equalsV4(vector2);// Сравниваем векторы с использованием equalsV4
        assertTrue(elementsEqual == vectorsEqual);
    }


    @Test
    public void testVectorNormalization() {
        Vector4 vector = new Vector4(3.0, 0.0, 4.0, 0.0);
        vector.normalize();
        Vector4 expectedVector = new Vector4(0.6, 0.0, 0.8, 0.0);

        assertTrue(vector.equalsV4(expectedVector));
    }

    @Test
    public void testVectorMultiplication() {
        Vector4 vector = new Vector4(2.0, 3.0, 4.0, 5.0);
        double scalar = 2.0;
        vector = vector.multiply( scalar);
        System.out.println(vector.getX());
        System.out.println(vector.getY());
        System.out.println(vector.getZ());
        System.out.println(vector.getW());
        Vector4 expectedProduct = new Vector4(4.0, 6.0, 8.0, 10.0);

        assertTrue(vector.equalsV4(expectedProduct));
    }

    @Test
    public void testVectorDivision() {
        Vector4 vector = new Vector4(2.0, 4.0, 6.0, 8.0);
        double scalar = 2.0;
        vector = vector.divide( scalar);
        Vector4 expectedQuotient = new Vector4(1.0, 2.0, 3.0, 4.0);

        assertTrue(vector.equalsV4(expectedQuotient));
    }

    @Test
    public void testVectorLength() {
        Vector4 vector = new Vector4(3.0, 4.0, 0.0, 0.0);
        double length = vector.length();
        double expectedLength = 5.0;

        assertEquals(expectedLength, length, eps);
    }

    @Test
    public void testVectorAddition() {
        Vector4 vector1 = new Vector4(1.0, 2.0, 3.0, 4.0);
        Vector4 vector2 = new Vector4(4.0, 5.0, 6.0, 7.0);
        Vector4 sum = vector1.add( vector2);
        Vector4 expectedSum = new Vector4(5.0, 7.0, 9.0, 11.0);

        assertTrue(sum.equalsV4(expectedSum));
    }

    @Test
    public void testVectorSubtraction() {
        Vector4 vector1 = new Vector4(1.0, 2.0, 3.0, 4.0);
        Vector4 vector2 = new Vector4(4.0, 5.0, 6.0, 7.0);
        Vector4 difference = Vector4.subtract(vector1, vector2);
        Vector4 expectedDifference = new Vector4(-3.0, -3.0, -3.0, -3.0);

        assertTrue(difference.equalsV4(expectedDifference));
    }

    @Test
    public void testVectorDotProduct() {
        Vector4 vector1 = new Vector4(1.0, 2.0, 3.0, 4.0);
        Vector4 vector2 = new Vector4(4.0, 5.0, 6.0, 7.0);
        double dotProduct = Vector4.dot(vector1, vector2);
        double expectedDotProduct = 60.0;

        assertEquals(expectedDotProduct, dotProduct, eps);
    }
}
