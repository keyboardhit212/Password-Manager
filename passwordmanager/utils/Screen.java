package passwordmanager.utils;

public class Screen {

    private static final long DELAY = 1000;

    private Screen() {}

    public static void pause() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {

        }
    }

    public static void clear() {
        System.out.println("\033\143");
    }
}
