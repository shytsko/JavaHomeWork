package Homework6;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NoteBook implements Comparable<NoteBook>{
    private String partNumber;
    private String vendor;
    private String model;
    private String color;
    private String os;
    private Display display;
    private CPU cpu;
    private RAM ram;
    private Storage storage;

    public NoteBook(String partNumber, String vendor, String model, String color, String os, Display display, CPU cpu, RAM ram, Storage storage) {
        this.partNumber = partNumber;
        this.vendor = vendor;
        this.model = model;
        this.color = color;
        this.os = os;
        this.display = display;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteBook noteBook = (NoteBook) o;
        return Objects.equals(partNumber, noteBook.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber);
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "partNumber='" + partNumber + '\'' +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", os='" + os + '\'' +
                ", display=" + display +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", storage=" + storage +
                '}';
    }

    @Override
    public int compareTo(NoteBook o) {
        if(!this.vendor.equals(o.vendor))
            return this.vendor.compareTo(o.vendor);
        else if (!this.model.equals(o.model))
            return this.model.compareTo(o.model);
        else
            return this.partNumber.compareTo(o.partNumber);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    public Display getDisplay() {
        return display;
    }

    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    enum FilterCriteria {
        VENDOR,
        COLOR,
        OS,
        CPU_SPEED,
        RAM,
        STORAGE
    }

    public boolean CheckCriteria(Map<FilterCriteria, Object> criteria) {
       if(criteria.containsKey(FilterCriteria.VENDOR) &&
               !this.vendor.equalsIgnoreCase((String) criteria.get(FilterCriteria.VENDOR)))
           return false;
       if(criteria.containsKey(FilterCriteria.COLOR) &&
                !this.color.equalsIgnoreCase((String) criteria.get(FilterCriteria.COLOR)))
           return false;
       if(criteria.containsKey(FilterCriteria.OS) &&
                !this.os.equalsIgnoreCase((String) criteria.get(FilterCriteria.OS)))
           return false;
       if(criteria.containsKey(FilterCriteria.CPU_SPEED) &&
                this.cpu.getSpeed() < (int) criteria.get(FilterCriteria.CPU_SPEED))
           return false;
       if(criteria.containsKey(FilterCriteria.RAM) &&
                this.ram.getSize() < (int) criteria.get(FilterCriteria.RAM))
           return false;
       if(criteria.containsKey(FilterCriteria.STORAGE) &&
                this.storage.getCapacity() < (int) criteria.get(FilterCriteria.STORAGE))
           return false;
       return true;
    }
}
