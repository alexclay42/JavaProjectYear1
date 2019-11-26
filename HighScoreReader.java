package game;

import org.jbox2d.common.Vec2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * reads data for score,level, position, health, and ship parts between game plays
 */
public class HighScoreReader {

    private String fileName;
int score;
int level;
float positionx;
float positiony;
int health;
int ships;


    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public HighScoreReader(String fileName) {
        this.fileName = fileName;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public int getHealth(){
        return health;
    }
    public float getPositionx(){
        return positionx;
    }
    public float getPositiony(){
        return positiony;
    }


    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public void readScores() throws IOException {

        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                   String[] tokens = line.split("l");
                    score = Integer.parseInt(tokens[0]);
                    level = Integer.parseInt(tokens[1]);
                    positionx = Float.parseFloat(tokens[2]);
                    positiony = Float.parseFloat(tokens[3]);
                    health = Integer.parseInt(tokens[4]);
                    ships = Integer.parseInt(tokens[5]);
                   System.out.println("Score: " + score + "level" + level + "posiion" + positionx + "positiony" + positiony + "health" + health + "ships" + ships);
                   line = reader.readLine();


            }
            System.out.println("...done.");
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

    }
    public static void main(String[] args) throws IOException {
        HighScoreReader demo = new HighScoreReader(args[0]);
        demo.readScores();
    }

}
