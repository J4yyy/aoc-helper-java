package dev.jayy.aochelper.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Day {

    private final List<String> data;
    private int year, day;

    protected Day(int year, int day) {
        this.year = year;
        this.day = day;
        ArrayList<String> fileData = new ArrayList<>();
        URL resource = this.getClass().getResource("/y"+year+"/input"+day+".txt");
        try {
            assert resource != null;
            Scanner scanner = new Scanner(resource.openStream());
            while (scanner.hasNext()) {
                fileData.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.data = fileData;
    }

    public Object partOne() {
        return null;
    }

    public Object partTwo() {
        return null;
    }

    public List<String> getData() {
        return this.data;
    }

    public int getYear() {
        return this.year;
    }

    public int getDay() {
        return this.day;
    }
}