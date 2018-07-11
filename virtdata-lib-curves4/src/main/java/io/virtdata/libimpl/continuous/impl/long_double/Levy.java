package io.virtdata.libimpl.continuous.impl.long_double;

import io.virtdata.annotations.ThreadSafeMapper;
import org.apache.commons.statistics.distribution.LevyDistribution;

/**
 * {@inheritDoc}
 *
 * @see io.virtdata.libimpl.continuous.impl.long_double.LongToDoubleContinuousCurve
 */

@ThreadSafeMapper
public class Levy extends LongToDoubleContinuousCurve { public Levy(double mu, double c, String... mods) { super(new LevyDistribution(mu,c), mods);
    }
}
