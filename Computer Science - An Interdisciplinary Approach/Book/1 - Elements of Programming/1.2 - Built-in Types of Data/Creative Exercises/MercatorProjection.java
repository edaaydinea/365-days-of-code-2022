public class MercatorProjection {
    public static void main(String[] args) {
        double lambda0 = Double.parseDouble(args[0]);
        double latitude = Double.parseDouble(args[1]);
        double longitude = Double.parseDouble(args[2]);

        double x = longitude - lambda0;
        double y = Math.log((1 + Math.sin(latitude)) / (1 - Math.sin(latitude))) / 2;
        System.out.println("Projection (x,y): (" + x + "," + y + ")");
    }
}