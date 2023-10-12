package Math;

public class Vector3 {
    private double x;
    private double y;
    private double z;
    private final double eps = 0.000001;

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double[] getElements(){
        double[] res = {x,y,z};
        return res;
    }
    public boolean equalsV3(Vector3 other) {//метод сравнения двух векторов
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.x) < eps &&
                Math.abs(this.y - other.y) < eps &&
                Math.abs(this.z - other.z) < eps;
    }
    public static Vector3 cross(Vector3 vector1, Vector3 vector2) {//Метод для вычисления векторного произведения двух векторов
        double resultX = vector1.y * vector2.z - vector1.z * vector2.y;
        double resultY = vector1.z * vector2.x - vector1.x * vector2.z;
        double resultZ = vector1.x * vector2.y - vector1.y * vector2.x;

        return new Vector3(resultX, resultY, resultZ);
    }

    public void normalize() {//метод для нормализации вектора
        double length = Math.sqrt(x * x + y * y + z * z);
        if (length > eps) {
            x /= length;
            y /= length;
            z /= length;
        }
    }

    public static double dot(Vector3 vector1, Vector3 vector2) {//Метод для вычисления скалярного произведения двух векторов
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
    }


    public double length() {//Метод для вычисления модуля вектора
        return Math.sqrt(x * x + y * y + z * z);
    }





    public Vector3 add( Vector3 other) {// +
        double resultX = this.x + other.x;
        double resultY = this.y + other.y;
        double resultZ = this.z + other.z;

        return new Vector3(resultX, resultY, resultZ);
    }



    public Vector3 multiply( double scalar) {// метод для умножения вектора на скаляр
        double resultX = this.x * scalar;
        double resultY = this.y * scalar;
        double resultZ = this.z * scalar;

        return new Vector3(resultX, resultY, resultZ);
    }


    public Vector3 divide(double scalar) {// метод для деления вектора на скаляр
        if (Math.abs(scalar) < this.eps) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }

        double resultX = this.x / scalar;
        double resultY = this.y / scalar;
        double resultZ = this.z / scalar;

        return new Vector3(resultX, resultY, resultZ);
    }
    public static Vector3 subtract(Vector3 vector1, Vector3 vector2) {//метод для вычитания двух векторов
        double resultX = vector1.x - vector2.x;
        double resultY = vector1.y - vector2.y;
        double resultZ = vector1.z - vector2.z;

        return new Vector3(resultX, resultY, resultZ);
    }
}

