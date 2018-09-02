package ru.innopolis.src;

import ru.innopolis.src.Annotation.Logger;
import ru.innopolis.src.Annotation.ResetData;

import java.util.ArrayList;
import java.util.TreeSet;

public interface IMathBox {
    public TreeSet<Integer> getValues();

    @ResetData
    @Logger
    public long summator();

    @ResetData
    @Logger
    public ArrayList<Double> splitter(Integer divider);

    @Logger
    public boolean deleteElement(Integer elementValue);

    public boolean setNewData(Integer[] newData);
}
