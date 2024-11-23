// Классы подсистем
class TV {
    void on() { System.out.println("Телевизор включен"); }
    void off() { System.out.println("Телевизор выключен"); }
    void setChannel(int channel) { System.out.println("Канал установлен на " + channel); }
}

class AudioSystem {
    void on() { System.out.println("Аудиосистема включена"); }
    void off() { System.out.println("Аудиосистема выключена"); }
    void setVolume(int level) { System.out.println("Громкость установлена на " + level); }
}

class DVDPlayer {
    void play() { System.out.println("Воспроизведение DVD"); }
    void pause() { System.out.println("Пауза DVD"); }
    void stop() { System.out.println("Остановка DVD"); }
}

class GameConsole {
    void on() { System.out.println("Игровая консоль включена"); }
    void startGame() { System.out.println("Запуск игры"); }
}

// Класс Фасад
class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audio;
    private DVDPlayer dvd;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audio, DVDPlayer dvd, GameConsole gameConsole) {
        this.tv = tv;
        this.audio = audio;
        this.dvd = dvd;
        this.gameConsole = gameConsole;
    }

    void watchMovie() {
        tv.on();
        audio.on();
        dvd.play();
        System.out.println("Начало просмотра фильма");
    }

    void endMovie() {
        dvd.stop();
        audio.off();
        tv.off();
        System.out.println("Просмотр фильма завершен");
    }

    void playGame() {
        tv.on();
        gameConsole.on();
        gameConsole.startGame();
        System.out.println("Начало игры");
    }

    void listenToMusic() {
        tv.on();
        audio.on();
        audio.setVolume(10);
        System.out.println("Начало прослушивания музыки");
    }

    void setVolume(int level) {
        audio.setVolume(level);
        System.out.println("Громкость установлена на " + level);
    }
}

// Клиентский код
public class Best {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audio = new AudioSystem();
        DVDPlayer dvd = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audio, dvd, gameConsole);

        homeTheater.watchMovie();
        homeTheater.endMovie();
        homeTheater.playGame();
        homeTheater.listenToMusic();
        homeTheater.setVolume(7);
    }
}
