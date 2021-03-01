// ID:322225897.

import java.util.ArrayList;
import java.util.List;

/**
 * the class operate a new game an runs it.
 */
public class Ass6Game {

    /**
     * the main creates new game and runs it.
     *
     * @param args - levels to run.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levels.add(new DirectHit());
            }
            if (args[i].equals("2")) {
                levels.add(new WideEasy());
            }
            if (args[i].equals("3")) {
                levels.add(new Green3());
            }
            if (args[i].equals("4")) {
                levels.add(new FinalFour());
            }
        }
        // in case there was no configurations.
        if (levels.isEmpty()) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        }
        AnimationRunner ar = new AnimationRunner();
        GameFlow gameFlow = new GameFlow(ar, ar.getGui().getKeyboardSensor());
        gameFlow.runLevels(levels);
    }
}
