
class CarAssembly implements Runnable {
    private String componentName;
    private int timeToPrepare;

    // Constructor
    public CarAssembly(String componentName, int timeToPrepare) {   
        this.componentName = componentName;
        this.timeToPrepare = timeToPrepare;
    }

    // run method
    @Override
    public void run() {
        try {
            System.out.println(componentName + " is preparing...");
            Thread.sleep(timeToPrepare);
            System.out.println(componentName + " is ready.");
        } catch (InterruptedException e) {
            System.out.println(componentName + " preparation interrupted.");
        }
    }

    // Main method to test threads
    public static void main(String[] args) {
        // Create tasks
        CarAssembly engine = new CarAssembly("Engine", 3000);
        CarAssembly body = new CarAssembly("Body", 4000);
        CarAssembly wheels = new CarAssembly("Wheels", 5000);

        // Create threads
        Thread engineThread = new Thread(engine);
        Thread bodyThread = new Thread(body);
        Thread wheelThread = new Thread(wheels);

        // Start threads
        engineThread.start();
        bodyThread.start();
        wheelThread.start();

        try {
            // Join threads for synchronization
            engineThread.join();
            bodyThread.join();
            wheelThread.join();
        } catch (InterruptedException e) {
            System.out.println("Assembly interrupted.");
        }

        System.out.println("All components are ready. Car assembly complete.");
    }
}
