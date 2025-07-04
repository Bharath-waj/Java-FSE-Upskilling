public class VirtualThreads {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread: " + Thread.currentThread());
            });
        }
        long end = System.currentTimeMillis();
        System.out.println("Launched 100,000 virtual threads in " + (end - start) + " ms");
    }
}
// This code demonstrates the use of virtual threads in Java.
// It launches 100,000 virtual threads that print a message to the console.