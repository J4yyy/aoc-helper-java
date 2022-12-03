package dev.jayy.aochelper;

import dev.jayy.aochelper.utils.ClassFinder;
import dev.jayy.aochelper.utils.CommandLineTable;
import dev.jayy.aochelper.utils.Day;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Supplier;

public class Solver {

    private String challengePackage;
    private CommandLineTable clt;
    private boolean solveAll;

    public Solver() {
        this.clt = new CommandLineTable();
        clt.setShowVerticalLines(true);
        clt.setHeaders("Class", "Part", "Solution", "Elapsed Time");
        this.solveAll = false;
    }

    public void solveAll(String challengePackage) {
        this.challengePackage = challengePackage;
        if(challengePackage == null) {
            throw new IllegalStateException("You must specify a package to be solved");
        }
        this.solveAll = true;
        List<Class<?>> solutions = getSolutions();
        for(Class<?> clazz : solutions) {
            if(Day.class.isAssignableFrom(clazz)) {
                solve(clazz);
                this.clt.addRow("", "", "", "");
            }
        }
        if(this.solveAll) {
            clt.print();
        }
    }

    public void solve(Class<?> clazz) {
        Day day;
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            day = (Day) constructor.newInstance();
            Object[] firstPart = evalSolution(day::partOne);
            Object[] secondPart = evalSolution(day::partTwo);
            if(!this.solveAll) {
                CommandLineTable singleTable = new CommandLineTable();
                singleTable.setHeaders("Class", "Part", "Solution", "Elapsed Time");
                singleTable.setShowVerticalLines(true);
                singleTable.addRow(clazz.getSimpleName(), "Part 1", firstPart[0].toString(), firstPart[1].toString()+" ms");
                singleTable.addRow(clazz.getSimpleName(), "Part 2", secondPart[0].toString(), secondPart[1].toString()+" ms");
                singleTable.print();
                singleTable.clearRows();
            } else {
                this.clt.addRow(clazz.getSimpleName(), "Part 1", firstPart[0].toString(), firstPart[1].toString()+" ms");
                this.clt.addRow(clazz.getSimpleName(), "Part 2", secondPart[0].toString(), secondPart[1].toString()+" ms");
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private List<Class<?>> getSolutions() {
        return ClassFinder.getClasses(this.challengePackage, Day.class);
    }

    private Object[] evalSolution(Supplier<Object> func) {
        long startTime = System.currentTimeMillis();
        Object result = func.get();
        long endTime = System.currentTimeMillis();
        return new Object[]{result, (endTime-startTime)};
    }
}