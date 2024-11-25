package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQueueTees {

    QueueTees queue;

    // A simple Cutie implementation for testing
    static class TestCutie implements Cutie {
        private final String description;
        private final int cuteness;

        public TestCutie(String description, int cuteness) {
            this.description = description;
            this.cuteness = cuteness;
        }

        @Override
        public String description() {
            return description;
        }

        @Override
        public Integer cutenessRating() {
            return cuteness;
        }
    }

    @BeforeEach
    void setUp() {
        queue = new QueueTees(3); // Initialize the queue with a capacity of 3
    }

    @Test
    void testEnqueueAndSize() {
        Cutie cutie1 = new TestCutie("Cutie 1", 8);
        Cutie cutie2 = new TestCutie("Cutie 2", 9);

        queue.enqueue(cutie1);
        queue.enqueue(cutie2);

        assertEquals(2, queue.size(), "Queue size should be 2 after two enqueues.");
    }

    @Test
    void testDequeue() {
        Cutie cutie1 = new TestCutie("Cutie 1", 8);
        Cutie cutie2 = new TestCutie("Cutie 2", 9);

        queue.enqueue(cutie1);
        queue.enqueue(cutie2);

        assertEquals(cutie1, queue.dequeue(), "First dequeued item should be 'Cutie 1'.");
        assertEquals(cutie2, queue.dequeue(), "Second dequeued item should be 'Cutie 2'.");
        assertEquals(0, queue.size(), "Queue size should be 0 after dequeuing all elements.");
    }

    @Test
    void testQueueIsFull() {
        Cutie cutie1 = new TestCutie("Cutie 1", 8);
        Cutie cutie2 = new TestCutie("Cutie 2", 9);
        Cutie cutie3 = new TestCutie("Cutie 3", 10);
        Cutie cutie4 = new TestCutie("Cutie 4", 7);

        queue.enqueue(cutie1);
        queue.enqueue(cutie2);
        queue.enqueue(cutie3);

        assertTrue(queue.isFull(), "Queue should be full after enqueuing 3 elements.");
        queue.enqueue(cutie4); // Attempt to enqueue to a full queue
        assertEquals(3, queue.size(), "Queue size should remain 3 after attempting to enqueue to a full queue.");
    }

    @Test
    void testQueueIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should initially be empty.");
        Cutie cutie = new TestCutie("Cutie 1", 8);
        queue.enqueue(cutie);
        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements.");
    }

    @Test
    void testDequeueFromEmptyQueue() {
        assertNull(queue.dequeue(), "Dequeue from an empty queue should return null.");
        assertTrue(queue.isEmpty(), "Queue should still be empty after trying to dequeue from an empty queue.");
    }
}
