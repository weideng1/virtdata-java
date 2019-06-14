package io.virtdata.libbasics.shared.from_double.to_other;

import io.virtdata.annotations.Categories;
import io.virtdata.annotations.Category;
import io.virtdata.annotations.ThreadSafeMapper;

import java.util.function.Function;

@ThreadSafeMapper
@Categories(Category.nulls)
public class NullIfEq implements Function<Double,Double> {

    private final double compareto;

    public NullIfEq(double compareto) {
        this.compareto = compareto;
    }

    @Override
    public Double apply(Double value) {
        if (value == compareto) return null;
        return value;
    }
}