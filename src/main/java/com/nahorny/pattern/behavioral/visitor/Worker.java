/**
 * Visitor's interface
 */

package com.nahorny.pattern.behavioral.visitor;

public interface Worker {
    void build(Hospital hospital);
    void build(Store store);
    void build(House house);
}
