class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        // Push all elements from the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Pop elements from the stack and enqueue them back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        return queue;
    }
}