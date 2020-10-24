/**
 * Mediator
 * обеспечивает взаимодействие множества объектов, сформировав при этом слабую связанность и избавив объекты от необходимости явно ссылаться друг на друга.
 * для этого создается объект-посредник. примеры: пользователи чата, коллеги и начальник отдела (в контексте формализованного обмена информацией),
 * почта и люди обменивающиеся посылками.
 */

package com.nahorny.pattern.behavioral.mediator;

public class Client {
    public static void main(String[] args) {
        Foreman foreman = new Foreman();
        Bricklayer bricklayer = new Bricklayer(foreman);
        Carpenter carpenter = new Carpenter(foreman);
        foreman.setCarpenter(carpenter);
        foreman.setBricklayer(bricklayer);
        //carpenter will not receive his own message, only bricklayer
        carpenter.send("Hello, Bricklayer");
        bricklayer.send("Hey, Carpenter");

    }
}
