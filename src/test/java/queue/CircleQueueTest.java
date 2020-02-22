package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleQueueTest {

    CircleQueue<Integer> circleQueue;


    @Before
    public void setUp() throws Exception {
        circleQueue = new CircleQueue<Integer>(3);
    }

    @After
    public void tearDown() throws Exception {
        circleQueue = null;
    }

    @Test
    public void isFull() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        circleQueue.addQueue(1);
        circleQueue.addQueue(2);
        assertFalse(circleQueue.isFull());
        circleQueue.addQueue(3);
        assertTrue(circleQueue.isFull());
        circleQueue.addQueue(4);
    }

    @Test
    public void isEmpty() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        assertTrue(circleQueue.isEmpty());
        circleQueue.addQueue(1);
        assertFalse(circleQueue.isEmpty());
        circleQueue.addQueue(2);
        assertFalse(circleQueue.isEmpty());

        circleQueue.popQueue();
        assertFalse(circleQueue.isEmpty());
        circleQueue.popQueue();
        assertTrue(circleQueue.isEmpty());
    }

    @Test
    public void addQueue() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        circleQueue.addQueue(1);
        assertEquals(1, circleQueue.size());

        circleQueue.addQueue(2);
        circleQueue.addQueue(3);
        assertEquals(3, circleQueue.size());

        circleQueue.addQueue(4);
        assertEquals(3, circleQueue.size());
    }

    @Test
    public void popQueue() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        circleQueue.addQueue(1);
        circleQueue.addQueue(2);
        circleQueue.addQueue(3);

        Integer num = circleQueue.popQueue();
        assertEquals(1, (int)num);

        num = circleQueue.popQueue();
        assertEquals(2, (int)num);

        num = circleQueue.popQueue();
        assertEquals(3, (int)num);
    }

    @Test
    public void showQueue() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        circleQueue.addQueue(3);
        circleQueue.addQueue(3);
        circleQueue.addQueue(1);
        circleQueue.showQueue();
    }

    @Test
    public void size() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        assertEquals(0, circleQueue.size());
        circleQueue.addQueue(4);
        assertEquals(1, circleQueue.size());
        circleQueue.addQueue(3);
        assertEquals(2, circleQueue.size());
        circleQueue.addQueue(2);
        assertEquals(3, circleQueue.size());
        circleQueue.addQueue(1);
        assertEquals(3, circleQueue.size());
        circleQueue.showQueue();

    }

    @Test
    public void headQueue() {
        CircleQueue<Integer> circleQueue = new CircleQueue<Integer>(3);
        assertEquals(0, circleQueue.size());
        circleQueue.addQueue(4);
        assertEquals(1, circleQueue.size());
        circleQueue.addQueue(3);
        assertEquals(2, circleQueue.size());
        circleQueue.addQueue(2);
        assertEquals(3, circleQueue.size());
        circleQueue.addQueue(1);
        assertEquals(3, circleQueue.size());

        assertEquals(4, (int)circleQueue.headQueue());
    }
}