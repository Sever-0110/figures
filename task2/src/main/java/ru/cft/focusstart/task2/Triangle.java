package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Triangle extends AbstractFigure {
    private static final Logger log = LoggerFactory.getLogger(Triangle.class.getName());
    private static final String TYPE_FIGURE = "Треугольник";
    private static final String NAME_PARAMETER_ANGLE_OPPOSITE_A = "Угол противолежащий стороне А";
    private static final String NAME_PARAMETER_ANGLE_OPPOSITE_B = "Угол противолежащий стороне В";
    private static final String NAME_PARAMETER_ANGLE_OPPOSITE_C = "Угол противолежащий стороне С";
    private static final String NAME_PARAMETER_SIDE_LENGTH_A = "Длина стороны А";
    private static final String NAME_PARAMETER_SIDE_LENGTH_B = "Длина стороны В";
    private static final String NAME_PARAMETER_SIDE_LENGTH_C = "Длина стороны С";
    private static final String UNIT_OF_MEASURE_ANGLE = "радиан";
    private final double sideLength_A;
    private final double sideLength_B;
    private final double sideLength_C;

    public Triangle(ArrayList<Double> parameters) {
        super(parameters);
        if (parameters.size() < 3){
            throw new IllegalArgumentException("Недопустимый набор параметров");
        }
        sideLength_A = parameters.get(0);
        sideLength_B = parameters.get(1);
        sideLength_C = parameters.get(2);
        if (sideLength_A+sideLength_B < sideLength_C || sideLength_A+sideLength_C <sideLength_B ||
                sideLength_B +sideLength_C <sideLength_A){
            throw new IllegalArgumentException();
        }
        log.info("Создали экземпляр класса: {}", Triangle.class.getName());
    }

    @Override
    public String getTypeFigure() {
        return TYPE_FIGURE;
    }

    @Override
    public LinkedHashMap<String, Double> getOutputParameters() {
        LinkedHashMap<String, Double> outPutParameters = new LinkedHashMap<>();
        //outPutParameters.put(NAME_PARAMETER_TYPE_FIGURE, TRIANGLE.toString());
        outPutParameters.put(NAME_PARAMETER_AREA, getArea());
        outPutParameters.put(NAME_PARAMETER_PERIMETER, getPerimeter());
        outPutParameters.put(NAME_PARAMETER_SIDE_LENGTH_A, getSideLength_A());
        outPutParameters.put(NAME_PARAMETER_ANGLE_OPPOSITE_A, getAngleOpposite_A());
        outPutParameters.put(NAME_PARAMETER_SIDE_LENGTH_B, getSideLength_B());
        outPutParameters.put(NAME_PARAMETER_ANGLE_OPPOSITE_B, getAngleOpposite_B());
        outPutParameters.put(NAME_PARAMETER_SIDE_LENGTH_C, getSideLength_C());
        outPutParameters.put(NAME_PARAMETER_ANGLE_OPPOSITE_C, getAngleOpposite_C());
        return outPutParameters;
    }

    @Override
    public LinkedHashMap<String, String> getUnitsOfMeasure() {
        return getUnitsOfMeasureForAllTriangle();
    }

    private static LinkedHashMap<String, String> getUnitsOfMeasureForAllTriangle() {
        LinkedHashMap<String, String> unitsOfMeasure = new LinkedHashMap<>();
        unitsOfMeasure.put(NAME_PARAMETER_AREA, UNIT_OF_MEASURE_AREA);
        unitsOfMeasure.put(NAME_PARAMETER_PERIMETER, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_SIDE_LENGTH_A, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_ANGLE_OPPOSITE_A, UNIT_OF_MEASURE_ANGLE);
        unitsOfMeasure.put(NAME_PARAMETER_SIDE_LENGTH_B, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_ANGLE_OPPOSITE_B, UNIT_OF_MEASURE_ANGLE);
        unitsOfMeasure.put(NAME_PARAMETER_SIDE_LENGTH_C, UNIT_OF_MEASURE_LENGTH);
        unitsOfMeasure.put(NAME_PARAMETER_ANGLE_OPPOSITE_C, UNIT_OF_MEASURE_ANGLE);
        return unitsOfMeasure;
    }

    @Override
    double getArea() {
        double semiPerimeter = (sideLength_A + sideLength_B + sideLength_C) / 2;
        double squareArea = semiPerimeter * (semiPerimeter - sideLength_A) * (semiPerimeter - sideLength_B) *
                (semiPerimeter - sideLength_C);
        double area = Math.pow(squareArea, 0.5);
        return area;
    }

    @Override
    double getPerimeter() {
        double perimeter = sideLength_A + sideLength_B + sideLength_C;
        return perimeter;
    }

    public double getSideLength_A() {
        return sideLength_A;
    }

    public double getAngleOpposite_A() {
        double angleOpposite_A = Math.toDegrees(Math.acos((-sideLength_A * sideLength_A + sideLength_B * sideLength_B + sideLength_C * sideLength_C) / (2 * sideLength_B * sideLength_C)));
        return angleOpposite_A;
    }

    public double getSideLength_B() {
        return sideLength_B;
    }

    public double getAngleOpposite_B()
    {double angleOpposite_B = Math.toDegrees(Math.acos((sideLength_A * sideLength_A - sideLength_B * sideLength_B + sideLength_C * sideLength_C) / (2 * sideLength_A * sideLength_C)));
        return angleOpposite_B;
    }

    public double getSideLength_C() {
        return sideLength_C;
    }

    public double getAngleOpposite_C() {
        double angleOpposite_C = Math.toDegrees(Math.acos((sideLength_A * sideLength_A + sideLength_B * sideLength_B - sideLength_C * sideLength_C) / (2 * sideLength_A * sideLength_C)));
        return angleOpposite_C;
    }

}
