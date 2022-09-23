package Homework6;

import java.util.Objects;

public class CPU {
    private String vendor;
    private String model;
    private int cores;
    private int threads;
    private int speed;

    public CPU(String vendor, String model, int cores, int threads, int speed) {
        this.vendor = vendor;
        this.model = model;
        this.cores = cores;
        this.threads = threads;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPU cpu = (CPU) o;
        return Objects.equals(model, cpu.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "{" +
                vendor + ';' +
                model + ';' +
                cores + "cores;" +
                threads + "threads;" +
                speed + "MHz" +
                '}';
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public int getCores() {
        return cores;
    }

    public int getThreads() {
        return threads;
    }

    public int getSpeed() {
        return speed;
    }
}
