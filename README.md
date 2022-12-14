<p align="center">
  <img src="https://user-images.githubusercontent.com/64800218/205461499-f57f0218-c755-4438-afe7-4898701f9bbf.png" style="width: 500px; border-radius: 15px" alt="banner">
</p>

<h3 align="center">Advent of Code Helper</h3>

<p align="center">
    <img alt="project-size" src="https://img.shields.io/github/languages/code-size/J4yyy/aoc-helper-java">
    <img alt="open-issues" src="https://img.shields.io/github/issues-raw/J4yyy/aoc-helper-java">
</p>

## Features
This Java library helps you to keep your project structure for AdventOfCode simple, output your solutions formatted and keep track of the speed of your solution. You can run a whole package or just single classes.
The only important thing is that your solution classes extends the Day class.

Feel free to give me feedback.

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
Implementation of a Solution, you can get all Rows from the input File with ```getData();```
The input file must be placed in the resources folder in the structure for example:</br>
&nbsp;-resources</br>
&nbsp;&nbsp;&nbsp;&nbsp; -y2021</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-input1.txt</br>

```java
import dev.jayy.aochelper.utils.Day;

import java.util.stream.Stream;

public class DayOne extends Day {

    private List<String> data = getData();
    // Or
    private Stream<String> data = dataAsStream();

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
If you find any issues from the library or documentation please [open up issue](https://github.com/J4yyy/aoc-helper-java/issues)


Made with ??? by [J4yy](https://github.com/J4yyy)

## License

[GNU GPL v3](./LICENSE)
