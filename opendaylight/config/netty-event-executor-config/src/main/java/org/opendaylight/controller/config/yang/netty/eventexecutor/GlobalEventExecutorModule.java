/**
 * Generated file

 * Generated from: yang module name: netty-event-executor  yang module local name: netty-global-event-executor
 * Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
 * Generated at: Tue Nov 12 10:44:21 CET 2013
 *
 * Do not modify this file unless it is present under src/main directory
 */
package org.opendaylight.controller.config.yang.netty.eventexecutor;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.TimeUnit;

/**
*
*/
public final class GlobalEventExecutorModule extends
        org.opendaylight.controller.config.yang.netty.eventexecutor.AbstractGlobalEventExecutorModule {

    public GlobalEventExecutorModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public GlobalEventExecutorModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
            GlobalEventExecutorModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void validate() {
        super.validate();
        // Add custom validation for module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        return new GlobalEventExecutorCloseable(GlobalEventExecutor.INSTANCE);
    }

    static final private class GlobalEventExecutorCloseable extends AbstractEventExecutor implements AutoCloseable {

        private EventExecutor executor;

        public GlobalEventExecutorCloseable(EventExecutor executor) {
            this.executor = executor;
        }

        @Override
        public EventExecutorGroup parent() {
            return this.executor.parent();
        }

        @Override
        public boolean inEventLoop(Thread thread) {
            return this.executor.inEventLoop(thread);
        }

        @Override
        public boolean isShuttingDown() {
            return this.executor.isShuttingDown();
        }

        @Override
        public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
            return this.executor.shutdownGracefully(quietPeriod, timeout, unit);
        }

        @Override
        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }

        @Override
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.executor.awaitTermination(timeout, unit);
        }

        @Override
        public void execute(Runnable command) {
            this.executor.execute(command);
        }

        @Override
        public void close() throws Exception {
            shutdownGracefully();
        }

        @SuppressWarnings("deprecation")
        @Override
        public void shutdown() {
            this.executor.shutdown();
        }

    }
}