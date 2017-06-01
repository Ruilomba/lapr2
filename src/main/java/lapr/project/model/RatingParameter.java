package lapr.project.model;

import java.lang.IllegalArgumentException;

public class RatingParameter {
    private final String name;
    private final float maxValue;
    private final float minValue;
    private float value;

    /***
     * Object constructor
     * @param name Parameter name
     * @param maxValue max value allowed
     * @param minValue min value allowed
     * @param value rating value
     */
    public RatingParameter(String name, float minValue, float maxValue,  float value) {
        this.name = name;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.value = value;
    }

    /***
     * Get parameter name
     * @return parameter name
     */
    String getName() {
        return name;
    }

    /***
     * Get parameter max value
     * @return max value
     */
    float getMaxValue() {
        return maxValue;
    }

    /***
     * Get parameter min value
     * @return min value
     */
    float getMinValue() {
        return minValue;
    }

    /***
     * Get parameter value
     * @return parameter value
     */
    float getValue() {
        return value;
    }

    /***
     * Applies rating for the parameter
     * Throws IllegarArgumentException if the value is out of range
     * @param value parameter rating value
     */
    void applyRating(float value){
        if(value<this.getMinValue() || value > this.getMaxValue()){
            throw new IllegalArgumentException(String.format("Rating value is out of range - range between %f and %f",
                                                            this.getMinValue(), this.getMaxValue()));
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RatingParameter)) {
            return false;
        }

        RatingParameter apr = (RatingParameter)o;

        return getName().equals(apr.getName());
    }
}
