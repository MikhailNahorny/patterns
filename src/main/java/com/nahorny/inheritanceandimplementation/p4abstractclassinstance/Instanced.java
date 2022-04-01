package com.nahorny.inheritanceandimplementation.p4abstractclassinstance;

class Instanced {
    public static void main(String[] args) {
        //ниже - "инстанция" абстрактного класса. по сути, это анонимная реализация
        Abs instance = new Abs() {
            @Override
            public void method() {

            }

            public void oneMoreMethod() {
                //it is allowed to add some specific methods while anonymous implementation,
                //but how it can be called???
            }
        };

        instance.method();

        System.out.println(instance.s);//доступ к статическому полю абс класса есть. еще: доступ к статическому полю есть и от имени объекта, но предупреждение будет сгенерировано
        System.out.println(instance.s2);//доступ к нестатическому полю абс класса есть
    }
}
