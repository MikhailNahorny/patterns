/**
 * этот прокси обеспечивает ленивую реализацию тяжелого объекта
 */

package com.nahorny.pattern.structural.proxy;

public class ProxyPipeV1 implements Pipe {
    private Pipe pipe;

    private void init() {
        if (pipe == null) {
            pipe = new IronPipe();
        }
    }

    @Override
    public void waterSupply() {
        init();
        pipe.waterSupply();
    }
}
