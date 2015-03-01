package org.automon.monitors;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * Created by stevesouza on 2/26/15.
 */
public class Metrics implements OpenMon<Timer> {
    private MetricRegistry metrics = new MetricRegistry();

    @Override
    public Timer start(String label) {
        return metrics.timer(name(label));
    }

    @Override
    public void stop(Timer timer) {
        timer.time().stop();
    }

    @Override
    public void exception(String label) {
        metrics.counter(label).inc();
    }

    public MetricRegistry getMetricRegistry() {
        return metrics;
    }

    public void setMetricRegistry(MetricRegistry metrics) {
        this.metrics = metrics;
    }

}
