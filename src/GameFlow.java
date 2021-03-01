import biuoop.KeyboardSensor;

import java.util.List;

/**
 * class will be in charge of creating the different levels, and moving from one level to the next.
 * implements the methods: constructor and run levels.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;

    /**
     * constructor.
     *
     * @param ks keyboard sensor.
     * @param ar an animation runner.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    /**
     * runs an animation of given list of levels.
     *
     * @param levels a list of levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        int score = 0;
        GameLevel finalLevel = null;
        for (LevelInformation levelInfo : levels) {
            //create a level from the given on =e in the list.
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score);
            level.initialize();
            while (level.getBallCounter().getValue() > 0 && level.getBlockCounter().getValue() > 0) {
                level.run();
            }
            // if there is no balls
            if (level.getBallCounter().getValue() == 0) {
                EndScreen endScreen = new EndScreen(level.getScoreCounter().getValue(), this.keyboardSensor,
                        this.animationRunner, false);
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, endScreen));
                break;
            }
            // save the score and the last level been played.
            score = level.getScoreCounter().getValue();
            finalLevel = level;
        }
        EndScreen endScreen = new EndScreen(finalLevel.getScoreCounter().getValue(), this.keyboardSensor,
                this.animationRunner, true);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                KeyboardSensor.SPACE_KEY, endScreen));
    }
}