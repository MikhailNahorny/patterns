/**
 * Chain of Responsibility
 * передача запроса по цепочке
 */

package com.nahorny.pattern.behavioral.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        Notifier lowPriorityHandlerPriority = new LowPriorityHandler(Priority.NOTICE);
        Notifier middlePriorityHandler = new MiddlePriorityHandler(Priority.WARNING);
        Notifier highPriorityHandler = new HighPriorityHandler(Priority.ALARM);
        lowPriorityHandlerPriority.setNextHandler(middlePriorityHandler);
        middlePriorityHandler.setNextHandler(highPriorityHandler);
        System.out.println();
        lowPriorityHandlerPriority.notificationManage("power suply of your house is of", Priority.NOTICE);
        System.out.println();
        lowPriorityHandlerPriority.notificationManage("water leek detected", Priority.WARNING);
        System.out.println();
        lowPriorityHandlerPriority.notificationManage("unauthorized entry into the house", Priority.ALARM);
    }
}
