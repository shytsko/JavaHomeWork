package Homework6;

import java.util.Objects;

public class RAM {
    enum RAMType {
        DDR3,
        DDR4,
        DDR5
    }

    private RAMType type;
    private int size;
    private int speed;

    public RAM(RAMType type, int size, int speed) {
        this.type = type;
        this.size = size;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return size == ram.size && speed == ram.speed && type == ram.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, speed);
    }

    @Override
    public String toString() {
        return "{" +
                type + ";" +
                size + "Gb;" +
                speed + "MHz" +
                '}';
    }

    public RAMType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }
}
