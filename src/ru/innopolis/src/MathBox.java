package ru.innopolis.src;

import ru.innopolis.src.Annotation.ClearData;
import ru.innopolis.src.Annotation.Logger;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Задание 3
 */
public class MathBox implements IMathBox {
    private TreeSet<Integer> mValues;

    /**
     * @param array массив чисел, которве необходимо сохранить
     */
    public MathBox(Integer[] array){
        mValues = new TreeSet<>();
        if(array == null){
            return;
        }
        for(Integer element : array){
            if (element != null){
                mValues.add(element);
            }
        }
    }

    /**
     * Получить числа, хранящихся в классе
     * @return числа, хранящиеся в классе
     */
    @Override
    public TreeSet<Integer> getValues(){
        return mValues;
    }

    /**
     * Найти сумму элементов
     * @return сумма элементов
     */
    @Override
    public long summator(){
        long resultSum = 0;
        for(Integer value : mValues){
            resultSum += value;
        }
        return resultSum;

    }

    /**
     * Разделить каждый элемент
     * @param divider делитель
     * @return частные
     */
    @Override
    public ArrayList<Double> splitter(Integer divider){
        if(divider == null || divider == 0)
            return null;
        ArrayList<Double> result = new ArrayList<Double>();
        for(Integer value : mValues){
            result.add((double)value / divider);
        }
        return result;
    }

    /**
     * удалить элемент из коллекции
     * @param elementValue значение элемента, которые необходимо удалить
     * @return удалось ли удалить
     */
    @Override
    @Logger
    public boolean deleteElement(Integer elementValue){
        return mValues.remove(elementValue);
    }

    /**
     * Очистить данные
     */
    @Logger
    public void cleanData() {
        mValues.clear();
    }

    @ClearData
    @Logger
    public void cleanDataWithAnnotation() {

    }

    /**
     * Добавить новые данные из массива
     *
     * @param newData массив новых данных
     * @return удалось ли добавить все элементы
     */
    @Override
    @Logger
    public boolean setNewData(Integer[] newData) {
        boolean result = true;
        cleanData();
        for (Integer element : newData) {
            if (element != null) {
                mValues.add(element);
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return mValues.equals(((MathBox)obj).getValues());
    }

    @Override
    public int hashCode() {
        return mValues.hashCode();
    }

    @Override
    public String toString() {
        String resultString = new String( "Size: " + mValues.size() + "\n" );
        if(mValues.isEmpty()){
            return resultString;
        }
        resultString += "Values:";
        for(Integer value : mValues){
            resultString += " " + value.toString();
        }
        return resultString;
    }
}
