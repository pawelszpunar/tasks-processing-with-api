package com.pawel.restapi.taskprocessing.enums;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InputData {

    @NotNull
    @Min(1)
    private int base;

    @NotNull
    @Min(1)
    private int exponent;

    public InputData(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public InputData() {
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "base=" + base +
                ", exponent=" + exponent +
                '}';
    }
}
