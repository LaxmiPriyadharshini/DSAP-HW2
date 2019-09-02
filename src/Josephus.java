import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 17683 Data Structures for Application Programmers.
 *
 * Homework Assignment 2 Solve Josephus problem
 * with different data structures
 * and different algorithms and compare running times
 *
 * Andrew ID:lsureshk
 * @author Laxmi PriyaDharshini Suresh Kumar
 */
public class Josephus {

    /**
     * Uses ArrayDeque class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithAD(int size, int rotation) {
        // TODO your implementation here
        if(size<=0){
            throw new RuntimeException("Throw exception: Size should be >0");
        }
        if(rotation<=0){
            throw new RuntimeException("Throw exception: Rotation should be >0");
        }
        ArrayDeque<Integer> arr= new ArrayDeque();
        for(int i=0;i<size;i++){
            arr.addLast(i+1);
        }

        // REmoval Procedure
        int removeindex=0;

        for (int i = 0; i < (rotation - 1) % arr.size(); i++) {
            arr.addLast(arr.removeFirst());
        }
        arr.removeFirst();

        return arr.peekFirst();
    }

    /**
     * Uses LinkedList class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLL(int size, int rotation) {
        // TODO your implementation here
        if (size <= 0) {
            throw new RuntimeException(
                    "Invalid arguments: size must be greater than 0");
        }

        if (rotation <= 0) {
            throw new RuntimeException(
                    "Invalid argument: rotation must be greater than 0");
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.add(i + 1); // add to end of queue
        }

        while (queue.size() != 1) {
            for (int i = 0; i < (rotation - 1) % queue.size(); i++) {
                queue.add(queue.poll());
            }
            queue.poll(); // poll at the front

        }

        // now linkedList.size() = 1
        return queue.peek();
    }

    /**
     * Uses LinkedList class to find the survivor's position.
     * However, do NOT use the LinkedList as Queue/Deque
     * Instead, use the LinkedList as "List"
     * That means, it uses index value to find and remove a person to be executed in the circle
     *
     * Note: Think carefully about this method!!
     * When in doubt, please visit one of the office hours!!
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLLAt(int size, int rotation) {
        // TODO your implementation here

        if(size<=0) throw  new RuntimeException("Throw exception: Size should be >0");

        if(rotation<=0) throw  new RuntimeException("Throw exception: Rotation should be >0");

        LinkedList<Integer> queue= new LinkedList<>();

        for(int i=0;i<size;i++){
            queue.add(i+1);
        }
        int removeindex=0;
        while(queue.size()!=1){

            removeindex=(removeindex+rotation-1)%queue.size();
            queue.remove(removeindex);
        }

        return queue.get(0);
    }

}


