package managers;

public class Wait {

    /**
     * Helper to slow down execution of steps for presentation (DO NOT ACTUALLY DO IN REAL WORLD)
     */

    public void sleep(int time){
        try {

            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
