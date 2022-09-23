package Homework6;

import java.util.Objects;

public class Display {
    double diagonalSize;
    int horizontalPixelSize;
    int verticalPixelSize;

    public Display(double diagonalSize, int horizontalPixelSize, int verticalPixelSize) {
        this.diagonalSize = diagonalSize;
        this.horizontalPixelSize = horizontalPixelSize;
        this.verticalPixelSize = verticalPixelSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return Double.compare(display.diagonalSize, diagonalSize) == 0 && horizontalPixelSize == display.horizontalPixelSize && verticalPixelSize == display.verticalPixelSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonalSize, horizontalPixelSize, verticalPixelSize);
    }

    @Override
    public String toString() {
        return "{" +
                diagonalSize + ";" +
                horizontalPixelSize + 'x' +
                verticalPixelSize +
                '}';
    }

    public double getDiagonalSize() {
        return diagonalSize;
    }

    public int getHorizontalPixelSize() {
        return horizontalPixelSize;
    }

    public int getVerticalPixelSize() {
        return verticalPixelSize;
    }
}
