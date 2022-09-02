package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(8, 5, 6));
        List<Integer> numbers2 = new ArrayList<>(List.of(2, 7, 4, 8, 0, 1, 76, 16));
        List<List<Integer>> values = new ArrayList<>(List.of(numbers, numbers2));
        LOGGER.info("List of lists - " + values);
        List<Integer> result = values.stream().flatMap(List::stream).toList();
        LOGGER.info("Made one list using flatMap() - " + result);
        List<Integer> sortedList = new ArrayList<>(result.stream().sorted().toList());
        LOGGER.info("Sorted list - " + sortedList);
        sortedList.add(null);
        LOGGER.info("Sorted list with null- " + sortedList);
        List<Integer> numbersNotNull = sortedList.stream().map(x -> Optional.ofNullable(x).orElse(55)).collect(Collectors.toList());
        LOGGER.info("Changed null with 55" + numbersNotNull);
        int multiplier = 2;
        functionInterface p = (int x) -> x * multiplier;
        List<Integer> listMultiply = numbersNotNull.stream()
                .map(p::multiplication)
                .collect(Collectors.toList());
        LOGGER.info("Multiplied each number from task 1 by number 2 - " + listMultiply);
    }
}
