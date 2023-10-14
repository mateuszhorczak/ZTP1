package com.github.mateuszhorczak;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    @Test
    void connectionTest() {
        IConnection connection1 = Base.getConnection();
        IConnection connection2 = Base.getConnection();
        IConnection connection3 = Base.getConnection();
        IConnection connection4 = Base.getConnection();

        assertNotEquals(connection1.hashCode(), connection2.hashCode());
        assertNotEquals(connection1.hashCode(), connection3.hashCode());
        assertEquals(connection1.hashCode(), connection4.hashCode());
        assertNotEquals(connection2.hashCode(), connection3.hashCode());
        assertNotEquals(connection2.hashCode(), connection4.hashCode());
        assertNotEquals(connection3.hashCode(), connection4.hashCode());
    }

    @Test
    void secondConnectionTest() {
        IConnection[] connections = new IConnection[90];
        for (int index = 0; index < 90; ++index) {
            connections[index] = Base.getConnection();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (var connection : connections) {
            if (!hashMap.containsKey(connection.hashCode())) {
                hashMap.put(connection.hashCode(), 1);
                continue;
            }
            hashMap.merge(connection.hashCode(), 1, Integer::sum);
        }

        Object[] keysArray = hashMap.keySet().toArray();

        assertEquals(3, keysArray.length);
        assertEquals(30, hashMap.get(keysArray[0]));
        assertEquals(30, hashMap.get(keysArray[1]));
        assertEquals(30, hashMap.get(keysArray[2]));
    }

    @Test
    void ThirdConnectionTest() {
        IConnection connection1 = Base.getConnection();
        IConnection connection2 = Base.getConnection();
        IConnection connection3 = Base.getConnection();

        connection1.set(0, 'm');
        connection2.set(1, 'a');
        connection1.set(2, 't');
        connection2.set(4, 'e');
        connection1.set(8, 'u');
        connection2.set(16, 's');
        connection1.set(32, 'z');

        assertEquals('z', connection3.get(32));
        assertEquals('s', connection3.get(16));
        assertEquals('u', connection3.get(8));
        assertEquals('e', connection3.get(4));
        assertEquals('t', connection3.get(2));
        assertEquals('a', connection3.get(1));
        assertEquals('m', connection3.get(0));
    }
}
