package game;
import java.io.FileWriter;
import java.io.IOException;

/**
 * saves game data to a text file.
 */
public class HighScoreWriter {

    private String fileName;

    public HighScoreWriter(String fileName) { this.fileName = fileName;}


    public void writeHighScore( int score, int level, float positionx,float positiony, int health, int ships) throws IOException {

        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write( score + "l" + level +"l" + positionx +"l"+positiony +"l"+ health + "l"+ ships +"\n" );
            System.out.println( score + "l" + level +"l" + positionx +"l"+positiony +"l"+ health + "l"+ ships +"\n" );


        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
            HighScoreWriter hsWriter = new HighScoreWriter("sample.hs");
            for (int i = 0; i < args.length; i += 6) {
                int score = Integer.parseInt(args[i ]);
                int level = Integer.parseInt(args[i+1]);
                float positionx = Float.parseFloat(args[i+2]);
                float positiony = Float.parseFloat(args[i+3]);
                int health = Integer.parseInt(args[i+4]);
                int ships = Integer.parseInt(args[i+5]);
                hsWriter.writeHighScore(score,level,positionx,positiony,health,ships);
            }
        }
    }

