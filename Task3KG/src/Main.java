import Math.Vector2;
import Math.Vector3;
import Math.Vector4;
import Math.Matrix3;
import Math.Matrix4;

public class Main {
    public static void main(String[] args) {
        Matrix3 matrix1 = new Matrix3(new double[][]{{1, 2,3}, {4, 5,6}, {7,8,9}});
        Matrix3 matrix2 = new Matrix3(new double[][]{{10,11,12}, {13,14,15},{16,17,18}});
        Matrix3 resultMatrix = Matrix3.add(matrix1, matrix2);
        System.out.println(resultMatrix.toString());
        Vector3 vector = new Vector3(1, 2, 3);
        System.out.println(resultMatrix.getElement(1,1));
        Matrix4 s = new Matrix4(new double[][]{{10,11,12,13}, {14,15,16,17},{18,19,20,21},{22,23,24,25}});
    }
}
