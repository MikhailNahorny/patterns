/**
 * считает количество обращений
 * может ограничивать количество/частоту
 * может логировать параметры (аргументы) вызовов
 */
package com.nahorny.pattern.structural.proxy;

public class ProxyPipeV2 implements Pipe{
    private static int callCounter;
    private Pipe pipe = new IronPipe();

    @Override
    public void waterSupply() {
        callCounter++;
        pipe.waterSupply();
    }

    public static int getCallCounter() {
        return callCounter;
    }
}
