/**
 * этот класс облегчен за счет вынесения неуникальных свойств в отдельный класс TreeType
 */
package com.nahorny.pattern.structural.flyweight;

public class Tree {
    private int poisitionx;
    private int poisitiony;
    private int height;
    private TreeType treeType;

    public Tree(int poisitionx, int poisitiony, int height, TreeType treeType) {
        this.poisitionx = poisitionx;
        this.poisitiony = poisitiony;
        this.height = height;
        this.treeType = treeType;
    }

    public void grow(){
        System.out.println(height + "-meters " + treeType.getName() + " grows in position (" + poisitionx + ", " + poisitiony + ")");
    }
}
