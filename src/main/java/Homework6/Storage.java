package Homework6;

import java.util.Objects;

public class Storage {
    enum StorageType {
        HDD,
        SDD
    }

    enum InterfaceType {
        SATA3,
        PCIe
    }

    private StorageType type;
    private InterfaceType interfaceType;
    private int capacity;


    public Storage(StorageType type, InterfaceType interfaceType, int capacity) {
        this.type = type;
        this.interfaceType = interfaceType;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return capacity == storage.capacity && type == storage.type && interfaceType == storage.interfaceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, interfaceType, capacity);
    }

    @Override
    public String toString() {
        return "{" +
                type + ';' +
                interfaceType + ';' +
                capacity + "Gb;" +
                '}';
    }

    public StorageType getType() {
        return type;
    }

    public InterfaceType getInterfaceType() {
        return interfaceType;
    }

    public int getCapacity() {
        return capacity;
    }
}
