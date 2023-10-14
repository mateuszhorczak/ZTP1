package com.github.mateuszhorczak;


public class Base {
    private final char[] array = new char[100];

    private Base() {
    }

    public static IConnection getConnection() {
        return Connection.getInstance();
    }

    private static class Connection implements IConnection {
        private static Base base;

        private static final Connection[] connections = {
                new Connection(),
                new Connection(),
                new Connection()
        };
        private static int counter = 0;
        private static boolean flag = false;

        private Connection() {
            if (!flag) {
                base = new Base();
                flag = true;
            }
        }

        public static IConnection getInstance() {
            IConnection instance = connections[counter];
            counter = ++counter % 3;
            return instance;
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
