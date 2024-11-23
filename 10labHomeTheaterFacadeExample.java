// HomeTheaterFacadeExample.java
public class HomeTheaterFacadeExample {

    // AudioSystem ішкі жүйесі
    public static class AudioSystem {
        public void turnOn() {
            System.out.println("Аудио жүйесі қосылды.");
        }

        public void setVolume(int level) {
            System.out.println("Аудио дыбысы " + level + " деңгейіне орнатылды.");
        }

        public void turnOff() {
            System.out.println("Аудио жүйесі өшірілді.");
        }
    }

    // VideoProjector ішкі жүйесі
    public static class VideoProjector {
        public void turnOn() {
            System.out.println("Проектор қосылды.");
        }

        public void setResolution(String resolution) {
            System.out.println("Бейне ажыратымдылығы " + resolution + " болып орнатылды.");
        }

        public void turnOff() {
            System.out.println("Проектор өшірілді.");
        }
    }

    // LightingSystem ішкі жүйесі
    public static class LightingSystem {
        public void turnOn() {
            System.out.println("Жарық қосылды.");
        }

        public void setBrightness(int level) {
            System.out.println("Жарықтың жарықтығы " + level + " деңгейіне орнатылды.");
        }

        public void turnOff() {
            System.out.println("Жарық өшірілді.");
        }
    }

    // HomeTheaterFacade класы
    public static class HomeTheaterFacade {
        private AudioSystem audioSystem;
        private VideoProjector videoProjector;
        private LightingSystem lightingSystem;

        public HomeTheaterFacade(AudioSystem audioSystem, VideoProjector videoProjector, LightingSystem lightingSystem) {
            this.audioSystem = audioSystem;
            this.videoProjector = videoProjector;
            this.lightingSystem = lightingSystem;
        }

        public void startMovie() {
            System.out.println("Фильмді бастауға дайындық...");
            lightingSystem.turnOn();
            lightingSystem.setBrightness(5);
            audioSystem.turnOn();
            audioSystem.setVolume(8);
            videoProjector.turnOn();
            videoProjector.setResolution("HD");
            System.out.println("Фильм басталды.");
        }

        public void endMovie() {
            System.out.println("Фильмді тоқтату...");
            videoProjector.turnOff();
            audioSystem.turnOff();
            lightingSystem.turnOff();
            System.out.println("Фильм аяқталды.");
        }
    }

    // Клиенттік код
    public static void main(String[] args) {
        AudioSystem audio = new AudioSystem();
        VideoProjector video = new VideoProjector();
        LightingSystem lights = new LightingSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(audio, video, lights);

        // Фильмді бастау
        homeTheater.startMovie();
        System.out.println();

        // Фильмді аяқтау
        homeTheater.endMovie();
    }
}
