package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static ru.cft.focusstart.task2.FiguresType.RECTANGLE;

public class Rectangle extends AbstractFigure {
    private static final Logger log = LoggerFactory.getLogger(Rectangle.class.getName());
    private static final String TYPE_FIGURE = "Прямоугольник";
    private static final String NAME_PARAMETER_DIAGONAL = "Диагональ";
    private static final String NAME_PARAMETER_LENGTH = "Длина";
    private static final String NAME_PARAMETER_WIDTH = "Ширина";
    double sideLength_A;
    double sideLength_B;

    public Rectangle(ArrayList<Double> parameters) {
        super(parameters);
        if (parameters.size() < 2){
            throw new IllegalArgumentException("Недопустимый набор параметров");
        }
        sideLength_A = parameters.get(0);
        sideLength_B = parameters.get(1);
        log.info("Создали экземпляр класса: {}", Rectangle.class.getName());
    }


    @Override
    public String getTypeFigure() {
        return TYPE_FIGURE;
    }

    @Override
    public LinkedHashMap<String, Double> getOutputParameters() {
        LinkedHashMap<String, Double> outPutParameters = new LinkedHashMap<>();
        //outPutParameters.put(NAME_PARAMETER_TYPE_FIGURE,RECTANGLE.toString());
        outPutParameters.put(NAME_PARAMETER_AREA, getArea());
        outPutParameters.put(NAME_PARAMETER_PERIMETER, getPerimeter());
        outPutParameters.put(NAME_PARAMETER_DIAGONAL, getDiagonal());
        outPutParameters.put(NAME_PARAMETER_LENGTH, getLength());
        outPutParameters.put(NAME_PARAMETER_WIDTH, getWidth());
        return outPutParameters;
    }

    @Override
    public LinkedHashMap<String, String> getUnitsOfMeasure() {
        LinkedHashMap<String, String> unitsOfMeasure = new LinkedHashMap<>();

        return getUnitsOfMeasureForAllRectangle();
    }

    private static LinkedHashMap<String, String> getUnitsOfMeasureForAllRectangle() {
        LinkedHashMap<String, String> unitsOfMeasure = new LinkedHashMap<>();
        unitsOfMeasure.put(NAME_PARAMETER_AREA, UNIT_OF_MEASURE_AREA);
        unitsOfMeasure.put(NAME_PARAMETER_PERIMETER, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_DIAGONAL, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_LENGTH, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_WIDTH, UNIT_OF_MEASURE_LENGTH);

        return unitsOfMeasure;
    }

    @Override
    double getArea() {
        double area = sideLength_A * sideLength_B;
        return area;
    }

    @Override
    double getPerimeter() {
        double perimeter = 2 * (sideLength_B + sideLength_A);
        return perimeter;
    }

    public double getDiagonal() {
        double diagonal = Math.sqrt(Math.pow(sideLength_A, 2) + Math.pow(sideLength_B, 2));
        return diagonal;
    }

    public double getLength() {
        if (sideLength_A > sideLength_B) {
            return sideLength_A;
        } else {
            return sideLength_B;
        }
    }

    public double getWidth() {
        if (sideLength_B > sideLength_A) {
            return sideLength_A;
        } else {
            return sideLength_B;
        }
    }
}
