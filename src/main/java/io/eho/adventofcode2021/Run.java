package io.eho.adventofcode2021;

import io.eho.adventofcode2021.days.Day01;
import io.eho.adventofcode2021.days.Day02;
import io.eho.adventofcode2021.days.Day03;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Run {

    private static final Map<Integer, Day> DAYS;

    static {
        DAYS = new HashMap<>();
        DAYS.put(1, new Day01());
        DAYS.put(2, new Day02());
        DAYS.put(3, new Day03());
    }

    public static List<String> loadInput(int day) {
        String theDay = String.valueOf(day);
        if (day < 10) {
            theDay = "0" + day;
        }
        String fileName = "day" + theDay + ".txt";

        try (BufferedReader br =
                     new BufferedReader((new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))))) {
            return br.lines().collect(toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e); // TODO: solve this differently?
        }
    }

    public static void main(String[] args) {
        int day = 3;
        if(args.length != 0) {
            day = Integer.parseInt(args[0]);
        }

        int part = 2;
        if(args.length > 1) {
            part = Integer.parseInt(args[1]);
        }

        List<String> input = null;
        try {
            input = loadInput(day);
        } catch (UncheckedIOException e) {
            System.out.println("unchecked exception while loading / reading " +
                                       "resources");
        }

        String result;
        if (part == 1) {
            result = DAYS.get(day).part1(input);
        } else {
            result = DAYS.get(day).part2(input);
        }

        System.out.println(result);
    }
}
