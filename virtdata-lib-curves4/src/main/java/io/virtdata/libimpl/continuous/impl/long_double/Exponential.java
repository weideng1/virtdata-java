package io.virtdata.libimpl.continuous.impl.long_double;

import io.virtdata.annotations.ThreadSafeMapper;
import org.apache.commons.statistics.distribution.ExponentialDistribution;

/**
 * {@inheritDoc}
 *
 * @see io.virtdata.libimpl.continuous.impl.long_double.LongToDoubleContinuousCurve
 */
@ThreadSafeMapper
public class Exponential extends LongToDoubleContinuousCurve {
    public Exponential(double mean, String... mods) {
        super(new ExponentialDistribution(mean), mods);
    }
}
