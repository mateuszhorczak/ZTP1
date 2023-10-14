package com.github.mateuszhorczak;

import java.util.ArrayList;
import java.util.List;

public class Base {
    private char[] array = new char[100];


    public static IConnection getConnection() {
        return Connection.getInstance();
    }

    private static class Connection implements IConnection {
        private Base base;

        public static IConnection getInstance() {
            int counter = 0;
            if (instance == null) {
                instance = new Connection();
            }
        }

        public char get(int index) {
            return base.array[index];
        }

        public void set(int index, char c) {
            base.array[index] = c;
        }

        public int length() {
            return base.array.length;
        }
    }
}
