package practicos.practico2.propios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import practicos.practico2.ColaConPila;

public class ColaConPilaTest {
    private ColaConPila<Integer> tester;

    @Before
    public void setUp() {
        this.tester = new ColaConPila<Integer>();
    }

    // Testeamos el método enqueue (encolar)
    @Test
    public void enqueue() {
        assertEquals(tester.size(), 0);

        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);

        assertEquals(tester.size(), 3);
    }

    @Test
    public void dequeue() {
        assertEquals(tester.size(), 0);

        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);

        assertEquals(tester.size(), 3);

        tester.dequeue();
        tester.dequeue();

        assertEquals(tester.size(), 1);
    }

    @Test
    public void front() {
        assertEquals(tester.size(), 0);

        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);

        assertEquals(tester.size(), 3);

        tester.dequeue();
        tester.dequeue();

        assertEquals(tester.size(), 1);
    }

    @Test
    public void size() {
        assertEquals(tester.size(), 0);

        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);

        assertEquals(tester.size(), 3);
    }

    @Test
    public void pop() {
        
    }

    @Test
    public void isEmpty() {
        assertEquals(tester.isEmpty(), true);

        tester.enqueue(1);

        assertEquals(tester.isEmpty(), false);
    }

    @Test
    public void peek() {
        tester.enqueue(2);
        tester.enqueue(3);

        assertTrue(tester.peek() == 2);
    }
}