package ru.cft.focusstart.task2;

public enum FiguresType {

    CIRCLE,
    RECTANGLE,
    TRIANGLE;

    @Override
    public String toString() {
        switch(this) {
            case CIRCLE: return "Круг";
            case RECTANGLE: return "Прямоугольник";
            case TRIANGLE: return "Треугольник";
            default: throw new IllegalArgumentException();
        }
    }
}
