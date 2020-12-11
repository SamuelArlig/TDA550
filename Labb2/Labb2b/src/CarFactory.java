public class CarFactory {

    public static Car CreateSaab95(double x, double y){
        return new Saab95(x, y);
    }

    public static Car CreateVolvo240(double x, double y){
        return new Volvo240(x, y);
    }

    public static Car CreateScania(double x, double y){
        return new Scania(x, y);
    }

    public static Car CreateCarTransport(int capacity){
        return new CarTransport(capacity);
    }
}
