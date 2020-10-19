/**
 * Composite. позволяет клиентам обращаться к отдельным объектам и к группам объектов одинаково
 * имеет смысл тогда, когда задачу можно представить в виде дерева, где у каждого узла одинаковый интерфейс
 */
package com.nahorny.pattern.structural.composite;

public class Client {
    public static void main(String[] args) {
        Worker bricklayer = new Bricklayer();
        Worker carpenter = new Carpenter();
        Worker wallpaperMaster = new WallpaperMaster();
        Worker painter = new Painter();

        Foreman foreman1 = new Foreman("builders");
        Foreman foreman2 = new Foreman("decorators");

        foreman1.addWorker(bricklayer);
        foreman1.addWorker(carpenter);

        foreman2.addWorker(wallpaperMaster);
        foreman2.addWorker(painter);

        ConstructionDirector constructionDirector = new ConstructionDirector("future city");

        constructionDirector.addWorker(foreman1);
        constructionDirector.addWorker(foreman2);

        //this place you can ask any worker to perform their job, but result will be different according to worker's responsibilities
        //so you can call any node of your tree with the same interface
        System.out.println();
        bricklayer.doWork();
        System.out.println();
        foreman2.doWork();
        System.out.println();
        constructionDirector.doWork();


    }

}
