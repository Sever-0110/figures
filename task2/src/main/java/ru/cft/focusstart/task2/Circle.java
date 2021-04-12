package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Circle extends AbstractFigure {
    private static final Logger log = LoggerFactory.getLogger(Circle.class.getName());
    private static final String NAME_PARAMETER_RADIUS = "Радиус";
    private static final String NAME_PARAMETER_DIAMETER = "Диаметр";
    private static final String TYPE_FIGURE = "Круг";
    private final double radius;


    public Circle(ArrayList<Double> parameters) {
        super(parameters);
        if (parameters.size() < 1) {
            throw new IllegalArgumentException("Недопустимый набор параметров");
        }
        radius = parameters.get(0);
        log.info("Создали экземпляр класса: {} ", Circle.class.getName());
    }

    @Override
    public String getTypeFigure() {
        return TYPE_FIGURE;
    }

    @Override
    public LinkedHashMap<String, Double> getOutputParameters() {
        LinkedHashMap<String, Double> outPutParameters = new LinkedHashMap<>();
        // outPutParameters.put(NAME_PARAMETER_TYPE_FIGURE, (Double)CIRCLE.ordinal());
        outPutParameters.put(NAME_PARAMETER_AREA, getArea());
        outPutParameters.put(NAME_PARAMETER_PERIMETER, getPerimeter());
        outPutParameters.put(NAME_PARAMETER_RADIUS, getRadius());
        outPutParameters.put(NAME_PARAMETER_DIAMETER, getDiameter());
        return outPutParameters;
    }

    @Override
    public LinkedHashMap<String, String> getUnitsOfMeasure() {
        return getUnitsOfMeasureForAllCircle();
    }

    private static LinkedHashMap<String, String> getUnitsOfMeasureForAllCircle() {
        LinkedHashMap<String, String> unitsOfMeasure = new LinkedHashMap<>();
        unitsOfMeasure.put(NAME_PARAMETER_AREA, UNIT_OF_MEASURE_AREA);
        unitsOfMeasure.put(NAME_PARAMETER_PERIMETER, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_RADIUS, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_DIAMETER, UNIT_OF_MEASURE_LENGTH);
        return unitsOfMeasure;
    }

    @Override
    double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    @Override
    double getPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    private double getRadius() {
        return radius;
    }

    private double getDiameter() {
        double diameter = 2 * radius;
        return diameter;
    }


}



