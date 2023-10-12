package Math;

public class Vector4 {
    private double x;
    private double y;
    private double z;
    private double w;
    private final double eps = 0.0000001;

    public Vector4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }
    public void setW(double w) {
        this.w = w;
    }

    public double[] getElements(){
        double[] res = {x,y,z,w};
        return res;
    }
    public double length() { //метод для вычисления модуля вектора
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }
    public boolean equalsV4(Vector4 other) {//метод сравнения двух векторов
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.x) < eps &&
                Math.abs(this.y - other.y) < eps &&
                Math.abs(this.z - other.z) < eps&&
                Math.abs(this.w - other.w) < eps;
    }
    public Vector4 multiply(double scalar) {//метод для умножения вектора на скаляр
        double resultX = x * scalar;
        double resultY = y * scalar;
        double resultZ = z * scalar;
        double resultW = w * scalar;
        return new Vector4(resultX, resultY, resultZ, resultW);
    }

    public Vector4 divide(double scalar) {//метод для деления вектора на скаляр
        if (Math.abs(scalar) < eps) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }
        double resultX = x / scalar;
        double resultY = y / scalar;
        double resultZ = z / scalar;
        double resultW = w / scalar;
        return new Vector4(resultX, resultY, resultZ, resultW);
    }
    public void normalize() {//метод для нормализации вектора
        double length = Math.sqrt(x * x + y * y + z * z + w * w);
        if (length > eps) {
            x /= length;
            y /= length;
            z /= length;
            w /= length;
        }
    }
    public Vector4 add(Vector4 other) {//метод для сложения двух векторов
        double resultX = this.x + other.x;
        double resultY = this.y + other.y;
        double resultZ = this.z + other.z;
        double resultW = this.w + other.w;
        return new Vector4(resultX, resultY, resultZ, resultW);
    }
    public static Vector4 subtract(Vector4 vector1, Vector4 vector2) {//метод для вычитания двух векторов
        double resultX = vector1.x - vector2.x;
        double resultY = vector1.y - vector2.y;
        double resultZ = vector1.z - vector2.z;
        double resultW = vector1.w - vector2.w;

        return new Vector4(resultX, resultY, resultZ, resultW);
    }


    public static double dot(Vector4 vector1, Vector4 vector2) { //метод для вычисления скалярного произведения двух векторов
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z + vector1.w * vector2.w;
    }
}

