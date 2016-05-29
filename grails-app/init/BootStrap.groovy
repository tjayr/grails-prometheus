import com.codahale.metrics.JmxReporter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.jvm.BufferPoolMetricSet
import com.codahale.metrics.jvm.GarbageCollectorMetricSet
import com.codahale.metrics.jvm.MemoryUsageGaugeSet
import com.codahale.metrics.jvm.ThreadStatesGaugeSet
import java.lang.management.ManagementFactory

class BootStrap {

    def init = { servletContext ->

        def metricsRegistry = new MetricRegistry()

        //Metrics for Monitoring
        metricsRegistry.register("jvm.buffers", new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()));
        metricsRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
        metricsRegistry.register("jvm.memory", new MemoryUsageGaugeSet());
        metricsRegistry.register("jvm.threads", new ThreadStatesGaugeSet());

        final JmxReporter reporter = JmxReporter.forRegistry(metricsRegistry).build();
        reporter.start();
    }
    def destroy = {
    }
}
