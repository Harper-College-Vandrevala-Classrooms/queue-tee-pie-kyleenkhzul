package com.csc;

// QueueTees class
class QueueTees {
  private Cutie[] queue;
  private int front;
  private int rear;
  private int size;
  private int capacity;

  // Constructor
  public QueueTees(int capacity) {
      this.capacity = capacity;
      this.queue = new Cutie[capacity];
      this.front = 0;
      this.rear = -1;
      this.size = 0;
  }

  // Enqueue method
  public void enqueue(Cutie cutie) {
      if (isFull()) {
          System.out.println("The queue is full. Cannot enqueue.");
          return;
      }
      rear = (rear + 1) % capacity;
      queue[rear] = cutie;
      size++;
  }

  // Dequeue method
  public Cutie dequeue() {
      if (isEmpty()) {
          System.out.println("The queue is empty. Cannot dequeue.");
          return null;
      }
      Cutie removedCutie = queue[front];
      front = (front + 1) % capacity;
      size--;
      return removedCutie;
  }

  // Size method
  public int size() {
      return size;
  }

  // Check if the queue is full
  public boolean isFull() {
      return size == capacity;
  }

  // Check if the queue is empty
  public boolean isEmpty() {
      return size == 0;
  }
}
