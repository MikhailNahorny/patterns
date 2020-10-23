/**
 * Proxy
 * замещает собой объект. может:
 * протоколировать, связывать с объектом из другого адресного пространства,
 * лениво инициализировать, кэшировать, синхронизировать в потоках, умно ссылаться, экранировать
 * минусы: увеличивает время отклика
 */

package com.nahorny.pattern.structural.proxy;

public class Client {
    public static void main(String[] args) {

//        Pipe pipe = new IronPipe(); //even if you don't use your pipe, initialization will perform when constructor called
//        pipe.waterSupply();

        Pipe p1 = new ProxyPipeV1(); //initialization will perform when you call waterSupply()
        p1.waterSupply();


        Pipe p2 = new ProxyPipeV2(); //count callings, can limit it
        p2.waterSupply();
        p2.waterSupply();
        p2.waterSupply();
        p2.waterSupply();
        System.out.println("waterSupply was called " + ProxyPipeV2.getCallCounter());
    }
}
