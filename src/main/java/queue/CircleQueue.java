package queue;

/**
 * 用数组实现队列
 * ps: 环形队列，先进先出
 */
public class CircleQueue<T> {

    /**
     * 最大保存元素个数
     */
    private int maxSize;

    /**
     * 指向队列头，第一个元素index
     */
    private int front = 0;

    /**
     * 指向队列尾，最后一个元素位置index的后一个位置
     * 这个位置arr在内存中，始终留空，作为指示位
     */
    private int tail = 0;

    /**
     * 保存数据的数组
     */
    private Object[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize+1;
        arr = new Object[maxSize+1];
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (tail+1)%maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 添加数据到队列
     * @param t
     */
    public void addQueue(T t) {
        if (isFull()) {
            System.out.println("队列已满，不能添加数据...");
            return;
        }
        arr[tail] = t;
        tail = (tail+1)%maxSize;
    }

    /**
     * 数据出队列
     * @return
     */
    @SuppressWarnings("unchecked")
    public T popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空...");
        }
        T ret = (T)arr[front];
        front = (front+1)%maxSize;
        return ret;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if(isEmpty()){
            System.out.println("队列空的，没有数据...");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%s\n", i%maxSize, arr[i%maxSize].toString());
        }
    }

    /**
     * 求出当前队列有效的数据的个数
     * @return
     */
    public int size() {
        return (tail + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的头部数据，不是取出数据
     * @return
     */
    @SuppressWarnings("unchecked")
    public T headQueue() {
        return (T)arr[front];
    }
}
