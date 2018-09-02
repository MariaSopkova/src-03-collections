package ru.innopolis.src.Test;

import ru.innopolis.src.GenerateIntArray;
import ru.innopolis.src.MathBox;

/**
 * класс для тестирования класса MathBox
 */
public class MathBoxTest {
    public MathBoxTest(){
    }

    /**
     * Тестирование метода summator
     */
    public static void testSummator(){
        MathBox mathBox = new MathBox(GenerateIntArray.generateArray(5));
        System.out.println("///////////");
        System.out.println("Summator test begin");
        System.out.println(mathBox.toString());
        System.out.println(mathBox.summator());
        System.out.println("Summator test end");
    }

    /**
     * Тестирование метода deleteElement
     */
    public static void testDeleteElement(){
        Integer[] array = GenerateIntArray.generateArray(10);
        array[array.length - 1] = 3;
        MathBox mathBox = new MathBox(array);
        System.out.println("///////////");
        System.out.println("Delete element test begin");
        System.out.println(mathBox.toString());
        System.out.println(mathBox.deleteElement(3));
        System.out.println(mathBox.toString());
        System.out.println(mathBox.deleteElement(15));
        System.out.println(mathBox.toString());
        System.out.println("Delete element test end");
    }

    /**
     * тестирование метода Splitter
     */
    public static void testSplitter(){
        MathBox mathBox = new MathBox(GenerateIntArray.generateArray(5));
        System.out.println("///////////");
        System.out.println("Splitter test begin");
        System.out.println(mathBox.toString());
        System.out.println(mathBox.splitter(2).toString());
        System.out.println("Splitter test end");
    }
}
