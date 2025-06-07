import com.fishinggame.Assets;
import com.fishinggame.FishingGame;

public class Main {
    public static void main(String[] args) {
        Assets.load();  // Load images
        new FishingGame(); // Start game
    }
}