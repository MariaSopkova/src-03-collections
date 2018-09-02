package ru.innopolis.src;

import java.util.Random;

public class GenerateIntArray {
    /**
     * генерация массива
     *
     * @param arraySize размер массива
     * @return массив
     */
    public static Integer[] generateArray(int arraySize) {
        Random random = new Random();
        Integer[] array = new Integer[20];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
