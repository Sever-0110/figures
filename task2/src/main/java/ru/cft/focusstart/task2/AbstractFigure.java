package ru.cft.focusstart.task2;

import java.util.ArrayList;


public abstract class AbstractFigure implements Figures {
    final static String NAME_PARAMETER_AREA = "Площадь";
    final static String NAME_PARAMETER_PERIMETER = "Периметр";
    final static String UNIT_OF_MEASURE_LENGTH = "мм";
    final static String UNIT_OF_MEASURE_AREA = "кв. мм";


    public AbstractFigure(ArrayList<Double> parameters) {
        for (double parameter : parameters){
            if (parameter <= 0){
                throw new IllegalArgumentException("Параметры фигуры не могут быть отрицательными или нулевыми");
            }
        }
    }

    abstract double getArea();

    abstract double getPerimeter();
}

