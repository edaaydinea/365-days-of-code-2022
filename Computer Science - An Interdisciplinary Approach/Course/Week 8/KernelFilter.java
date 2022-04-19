import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies a inputted filter to the given picture.
    public static Picture filter(double[][] filter, Picture picture) {
        int center = (filter.length - 1) / 2;
        Picture newPicture = new Picture(picture.width(), picture.height());
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                double red = 0;
                double blue = 0;
                double green = 0;
                for (int column = -1 * center; column <= center; column++) {
                    int col_to_filter = i + column;
                    if (col_to_filter < 0) col_to_filter += picture.width();
                    if (col_to_filter >= picture.width()) col_to_filter -= picture.width();
                    for (int row = -1 * center; row <= center; row++) {
                        int row_to_filter = j + row;
                        if (row_to_filter < 0) row_to_filter += picture.height();
                        if (row_to_filter >= picture.height()) row_to_filter -= picture.height();
                        red += picture.get(col_to_filter, row_to_filter).getRed() * filter[column + center][row + center];
                        blue += picture.get(col_to_filter, row_to_filter).getBlue() * filter[column + center][row + center];
                        green += picture.get(col_to_filter, row_to_filter).getGreen() * filter[column + center][row + center];
                    }
                }
                if (red > 255.0) red = 255.0;
                if (red < 0.0) red = 0.0;
                if (red % 1 >= .5) red += (1 - (red % 1));
                else red = (int) red;

                if (blue > 255.0) blue = 255.0;
                if (blue < 0.0) blue = 0.0;
                if (blue % 1 >= .5) blue += (1 - (blue % 1));
                else blue = (int) blue;

                if (green > 255.0) green = 255.0;
                if (green < 0.0) green = 0.0;
                if (green % 1 >= .5) green += (1 - (green % 1));
                else green = (int) green;

                Color color = new Color((int) red, (int) green, (int) blue);
                newPicture.set(i, j, color);
            }
        }
        return newPicture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] a = {{1.0 / 16, 2.0 / 16, 1.0 / 16}, {2.0 / 16, 4.0 / 16, 2.0 / 16}, {1.0 / 16, 2.0 / 16, 1.0 / 16}};
        return filter(a, picture);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] a = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return filter(a, picture);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] a = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return filter(a, picture);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] a = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return filter(a, picture);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] a = {{1.0 / 9, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1.0 / 9, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1.0 / 9, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1.0 / 9, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1.0 / 9, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1.0 / 9, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1.0 / 9, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1.0 / 9, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9}};
        return filter(a, picture);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String file = args[0];
        String variant = args[1];
        Picture pic = new Picture(file);
        if (variant.equals("gaussian")) gaussian(pic).show();
        if (variant.equals("sharpen")) sharpen(pic).show();
        if (variant.equals("laplacian")) laplacian(pic).show();
        if (variant.equals("emboss")) emboss(pic).show();
        if (variant.equals("motionBlur")) motionBlur(pic).show();
    }

}