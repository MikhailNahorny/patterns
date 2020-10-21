/**
 * это фабрика типов. она хранит типы у себя и возвращает по запросу, если нужный тип есть
 * или создает новый, сохраняет у себя и возвращает, если такого типа раньше не было
 */
package com.nahorny.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<TreeType, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType requiredTreeType = new TreeType(name, color, texture);
        // or treeTypes.putIfAbsent(requiredTreeType, requiredTreeType);
        if (treeTypes.get(requiredTreeType) == null) {
            treeTypes.put(requiredTreeType, requiredTreeType);
        }
        return treeTypes.get(requiredTreeType);
    }
}
