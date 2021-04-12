package ru.cft.focusstart.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ModelFigureTypeWithParameters {
    private static final Logger log = LoggerFactory.getLogger(ModelFigureTypeWithParameters.class.getName());
    private String figureType;
    private ArrayList<Double> parameters;

    public ModelFigureTypeWithParameters(String figureType, ArrayList<Double> parameters) {
        this.figureType = figureType;
        this.parameters = parameters;
        log.info("Создали экземпляр класса: {}", ModelFigureTypeWithParameters.class.getName());
    }

    public String getFigureType() {
        return figureType;
    }

    public ArrayList<Double> getParameters() {
        return parameters;
    }
}
