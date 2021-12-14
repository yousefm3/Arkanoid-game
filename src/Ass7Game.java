/**
 * @author Mohamed Yousef
 */
import java.util.ArrayList;
import java.util.List;

/**
 * starts a game according to the args.
 */
public class Ass7Game {
    /**
     * @param args the levels we will play
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        int[] list = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                list[i] = Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("throwing a string");
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 5 && list[i] > 0) {
                if (list[i] == 1) {
                    levels.add(new Level1());
                }
                if (list[i] == 2) {
                    levels.add(new Level2());
                }
                if (list[i] == 3) {
                    levels.add(new Level3());
                }
                if (list[i] == 4) {
                    levels.add(new Level4());
                }
            }
        }
        if (levels.size() > 0) {
            GameFlow game = new GameFlow(levels);
            game.runLevels(levels);
        }
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            GameFlow game = new GameFlow(levels);
            game.runLevels(levels);
        }
    }
}
