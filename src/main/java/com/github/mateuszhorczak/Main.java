package com.github.mateuszhorczak;

public class Main {
    public static void main(String[] args) {
        IConnection connection1 = Base.getConnection();
        IConnection connection2 = Base.getConnection();
        IConnection connection3 = Base.getConnection();
        IConnection connection4 = Base.getConnection();

        System.out.println(connection1);
        System.out.println(connection2);
        System.out.println(connection3);
        System.out.println(connection4);

        connection1.set(0, 'm');
        connection2.set(5, 'a');
        connection3.set(10, 't');
        connection4.set(15, 'i');

        System.out.println(connection4.get(0));
        System.out.println(connection3.get(5));
        System.out.println(connection2.get(10));
        System.out.println(connection1.get(15));
    }
}
