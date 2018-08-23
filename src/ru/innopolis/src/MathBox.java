package ru.innopolis.src;

import java.util.*;

/**
 * Задание 3
 */
public class MathBox {
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
    public TreeSet<Integer> getValues(){
        return mValues;
    }

    /**
     * Найти сумму элементов
     * @return сумма элементов
     */
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
    public boolean deleteElement(Integer elementValue){
        return mValues.remove(elementValue);
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
