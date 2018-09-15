package ru.innopolis.src;

import ru.innopolis.src.Annotation.Logger;
import ru.innopolis.src.Annotation.ResetData;

import java.util.ArrayList;
import java.util.TreeSet;

public interface IMathBox {
    TreeSet<Integer> getValues();

    long summator();

    ArrayList<Double> splitter(Integer divider);

    boolean deleteElement(Integer elementValue);

    boolean setNewData(Integer[] newData);
}
