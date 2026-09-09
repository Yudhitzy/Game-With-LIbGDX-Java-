package GameplayScreen;

public class ObjectFilled {

    private static final int MAX_PLATFORMS = 100;
    private PlatformCoordinate[] platformCoordinates;
    private int platformCount;

    public ObjectFilled() {
        platformCoordinates = new PlatformCoordinate[MAX_PLATFORMS];
        platformCount = 0;
    }

    public void addPlatformCoordinate(Platform currentPlatform) {
        if (platformCount < MAX_PLATFORMS) {
            platformCoordinates[platformCount] = new PlatformCoordinate(x, y, width, height);
            platformCount++;
        }
    }

    public PlatformCoordinate[] getPlatformCoordinates() {
        return platformCoordinates;
    }

    public int getPlatformCount() {
        return platformCount;
    }

    public static class PlatformCoordinate {
        public float x;
        public float y;
        public float width;
        public float height;

        public PlatformCoordinate(float x, float y, float width, float height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean contains(float px, float py) {
            return px >= x && px <= x + width && py >= y && py <= y + height;
        }

        @Override
        public String toString() {
            return "Platform[x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
        }
    }
}
