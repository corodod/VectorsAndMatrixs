package Math;

public class Vector2 {
    private final double eps = 0.0000001;
    private double x;
    private double y;
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
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
    public boolean equalsV2(Vector2 other) {//метод сравнения двух векторов
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.x) < eps &&
                Math.abs(this.y - other.y) < eps;
    }

    public double length() {//Метод для вычисления модуля вектора
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {//метод для нормализации вектора
        double length = Math.sqrt(x * x + y * y);
        if ( eps < Math.abs(length)) {
            x /= length;
            y /= length;

        }
    }
    public static double dot(Vector2 vector1, Vector2 vector2) {// cкалярное произведение векторов
        return vector1.x * vector2.x + vector1.y * vector2.y;
    }


    public double[] getElements(){
        double[] res = {x,y};
        return res;
    }
    public Vector2 add(Vector2 other) {// Метод для сложения двух векторов
        double resultX = this.x + other.x;
        double resultY = this.y + other.y;
        return new Vector2(resultX, resultY);
    }

    public static Vector2 subtract(Vector2 vector1, Vector2 vector2) {// метод для вычитания двух векторов
        double resultX = vector1.x - vector2.x;
        double resultY = vector1.y - vector2.y;
        return new Vector2(resultX, resultY);
    }

    public Vector2 multiply(double scalar) {// Метод для умножения вектора на скаляр
        double resultX = this.x * scalar;
        double resultY = this.y * scalar;
        return new Vector2(resultX, resultY);
    }

    public Vector2 divide(double scalar) {  // Метод для деления вектора на скаляр
        if (Math.abs(scalar) < this.eps) {
            throw new IllegalArgumentException("Деление на ноль не допустимо");
        }
        double resultX = this.x / scalar;
        double resultY = this.y / scalar;
        return new Vector2(resultX, resultY);
    }
}
