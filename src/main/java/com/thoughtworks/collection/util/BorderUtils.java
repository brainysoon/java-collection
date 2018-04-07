package com.thoughtworks.collection.util;

public class BorderUtils {
    public static class Border {

        private int startValue;
        private int endValue;

        private Border(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public int getStartValue() {
            return startValue;
        }

        public int getEndValue() {
            return endValue;
        }
    }

    public static Border valueOf(int leftBorder, int rightBorder) {
        int startValue = leftBorder < rightBorder ? leftBorder : rightBorder;
        int entValue = leftBorder > rightBorder ? leftBorder : rightBorder;

        return new Border(startValue, entValue);
    }
}
