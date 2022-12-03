## Features
You can run an entire package of solution classes or test individual classes. The only important thing is that your solution class extends the Day class.

## Maven
```xml
<dependencies>
    <dependency>
      <groupId>dev.jayy.aochelper</groupId>
      <artifactId>aochelper</artifactId>
      <version>1.0</version>
    </dependency>
</dependencies>
```

## How to use
Implementation of a Solution
```java
import dev.jayy.aochelper.utils.Day;

public class DayOne extends Day {
    protected DayOne() {
        super(2022, 1);
    }

    @Override
    public Object partOne() {
        return "The Answer";
    }

    @Override
    public Object partTwo() {
        return "The Answer";
    }
}
```
Get your Solution Output
```java
public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.solveAll("dev.jayy.y2022");
        solver.solve(DayOne.class);
    }
}
```


## Issues
If you find any issues from the plugin or documentation please [open up issue](https://github.com/J4yyy/aoc-helper-java/issues)