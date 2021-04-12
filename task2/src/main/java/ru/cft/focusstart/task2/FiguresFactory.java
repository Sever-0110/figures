package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class FiguresFactory {
    private static final Logger log = LoggerFactory.getLogger(FiguresFactory.class.getName());
    private ArrayList<Double> parameters;

    public FiguresFactory(ArrayList<Double> parameters) {
        this.parameters = parameters;
        log.info("Создали экземпляр класса: {}", FiguresFactory.class.getName());
    }

    public Figures createFigures(String name){
        Figures figure = null;
        switch (name){
            case "CIRCLE":
                figure = new Circle(parameters);
                break;
            case "TRIANGLE":
                figure = new Triangle(parameters);
                break;
            case "RECTANGLE":
                figure = new Rectangle(parameters);
                break;
            default:
                throw  new IllegalArgumentException("Фигуры с данным названием не существует: " + name);
        }
        return figure;
    }
}
