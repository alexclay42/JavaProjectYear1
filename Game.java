package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alex Clay
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;


    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;

    /**
     * A variable to help control the movements between  levels
     */
    private int level;

    public int getLevel() {
        return level;
    }


    /**
     * Controllers which allow the movement of the player and the enemies
     */
    private PlayerController controller;
    private EnemyController controller2;
    /**
     * Soundclips to provide the music for each respective level
     */
    private SoundClip menuMusic;
    private SoundClip lvl1Music;
    private SoundClip lvl2Music;
    private SoundClip lvl3Music;
    private SoundClip lvl4Music;
    private SoundClip endMusic;

    /**
     * Boolean variables to check if music is running
     */
    private boolean menuPlaying;
    private boolean lvl1Playing;
    private boolean lvl2Playing;
    private boolean lvl3Playing;
    private boolean lvl4Playing;
    private boolean endPlaying;

    /**
     * Holds the player's health
     */

    public int playerHealth = 5;


    public int getPlayerHealth() {
        return playerHealth;
    }

    /**
     * Decreases the player's heath, and causes the game to exit if the variable reaches 0, and changes label
     */
    public void decrementPlayerHealth() {
        playerHealth--;
        System.out.println("Player health = " + playerHealth);
        label1.setText("Player health = " + playerHealth);
        if (playerHealth == 0) {
            reset();
        }
    }

    /**
     * Increases the player health variable, and changes the label accordingly
     */
    public void incrementPlayerHealth() {
        playerHealth++;
        System.out.println("Player health = " + playerHealth);
        label1.setText("Player health = " + playerHealth);

    }

    /**
     * Controls the variable for ship parts, which is what allows the levels to register as complete
     */

    public int shipParts;

    public int getShipParts() {
        return shipParts;
    }

    public void incrementShipParts() {
        shipParts++;
        System.out.println("ship parts = " + shipParts);


    }

    /**
     * Acts as the  score counter, must be above 5 to pass the third level
     */
    private int planetCount;

    public int getPlanetCount() {
        return planetCount;
    }

    public void incrementPlanetCount() {
        planetCount++;
        System.out.println("Planet count = " + planetCount);
        label2.setText("Planets Collected: " + planetCount);
    }

    /**
     * Creates the labels and buttons for the GUI
     */
    JLabel label1 = new JLabel("");
    JLabel label2 = new JLabel("");
    JLabel label3 = new JLabel("");
    JButton button1 = new JButton("Quit");
    JButton button2 = new JButton("");
    JButton button3 = new JButton("");
    JButton button4 = new JButton("");

    /**
     * Controls button 2's initial state, to go to the instruction page
     */
    ActionListener button2v1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            instructions();
        }
    };
    /**
     * Controls button 3's initial state, moving the game to start level 1
     */
    ActionListener button3v1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lvl1();
            updateGUI();
        }
    };

    /**
     * Controls button 4, to load the last save
     */
    ActionListener button4v1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameLoad();
        }
    };


    /**
     * Initialise a new Game.
     */
    public Game() {
        level = 0;
        world = new Level0MM(this);
        world.populate(this);
        view = new EndText(world, this, 500, 520);
        try {
            menuMusic = new SoundClip("data/menu.wav");
            menuMusic.loop();
            menuPlaying = true;

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }

        // display the view in a frame
        JFrame frame = new JFrame("Orange's Adventures");

        JPanel labelContain = new JPanel();
        labelContain.setBackground(Color.darkGray);
        frame.add(labelContain, BorderLayout.NORTH);

        JPanel buttonContain = new JPanel();
        buttonContain.setBackground(Color.darkGray);
        frame.add(buttonContain, BorderLayout.SOUTH);
        buttonContain.setSize(5, 7);

        //Quit button
        buttonContain.add(button1);
        button1.setForeground(Color.GREEN);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        // Instruction button
        buttonContain.add(button2);
        button2.setForeground(Color.GREEN);
        button2.setText("Instructions");
        button2.addActionListener(button2v1);


        // Game start button
        buttonContain.add(button3);
        button3.setForeground(Color.GREEN);
        button3.setText("Start Game");
        button3.addActionListener(button3v1);

        //Game load button
        buttonContain.add(button4);
        button4.setForeground(Color.GREEN);
        button4.setText("Load Last Save");
        button4.addActionListener(button4v1);

        //Adds icons to the Jpanel
        ImageIcon pic = new ImageIcon("data/Planet3.png");
        ImageIcon pic2 = new ImageIcon("data/heart.png");
        ImageIcon pic3 = new ImageIcon("data/icon.png");
        label1.setIcon(pic2);
        label1.setForeground(Color.green);


        label2.setIcon(pic);
        label2.setForeground(Color.green);


        label3.setIcon(pic3);
        label3.setForeground(Color.green);


        labelContain.add(label1);
        labelContain.add(label2);
        labelContain.add(label3);


        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new PlayerController(world.getPlayer());
        frame.addKeyListener(controller);

        // setting background color
        view.setBackground(Color.black);
        // makes laser fire work
        view.addMouseListener(new LaserFire(view, world, this));

        controller2 = new EnemyController(world.getEnemy());
        frame.addKeyListener(controller2);


        // start!
        world.start();


    }


    /**
     * The player and enemy in the current level.
     */
    public Robot getPlayer() {
        return world.getPlayer();
    }

    public Enemy getEnemy() {
        return world.getEnemy();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Saves the gamestate, storing the player's position in x and y
     */
    public void gameSave() {
        float x = getPlayer().getPosition().x;
        float y = getPlayer().getPosition().y;


        HighScoreWriter saveGame = new HighScoreWriter("game.hs");
        try {
            saveGame.writeHighScore(planetCount, level, x, y, playerHealth, shipParts);
            System.out.println("saved");
        } catch (IOException ja) {
            System.out.println("no");

        }
    }

    /**
     * Loads the game state from file, updating the variables, level, and player position to reflect it
     */

    public void gameLoad() {
        HighScoreReader getGameState = new HighScoreReader("game.hs");
        try {
            getGameState.readScores();
            planetCount = getGameState.getScore();
            level = getGameState.getLevel();
            playerHealth = getGameState.getHealth();
        } catch (IOException ja) {
            System.out.println("lol nope");
        }

        world.stop();
        if (level == 1) {
            lvl1();
            updateGUI();
            shipParts = 0;

        } else if (level == 2) {
            updateGUI();
            goLvl2();
            shipParts = 1;
        } else if (level == 3) {
            updateGUI();
            goLvl3();
            shipParts = 1;
        } else if (level == 4) {
            updateGUI();
            goLvl4();
            shipParts = 2;
        }
        getPlayer().setPosition(new Vec2(getGameState.positionx, getGameState.positiony));
    }

    /**
     * Button 2's second state, to save the game
     */
    ActionListener button2v2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            gameSave();

        }
    };

    /**
     * Button 3's second state, to return to the main menu
     */
    ActionListener button3v2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset();
        }
    };


    /**
     * Resets the game to the state it was in when initially opened, returning to the main menu
     */
    public void reset() {
        world.stop();
        level = 0;
        playerHealth = 5;
        shipParts = 0;
        planetCount = 0;
        label1.setText("");
        label2.setText("");
        label3.setText("");


        button2.setText("Instructions");
        button2.addActionListener(button2v1);
        button2.removeActionListener(button2v2);

        button3.setText("Start Game");
        button3.removeActionListener(button3v2);
        button3.addActionListener(button3v1);


        world = new Level0MM(this);
        world.populate(this);
        try {
            menuMusic = new SoundClip("data/menu.wav");
            menuMusic.loop();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }
        // switch the keyboard control to the new player
        controller.setBody(world.getPlayer());
        controller2.setBody(world.getEnemy());
        // show the new world in the view
        view.setWorld(world);
        world.start();

    }

    /**
     * Updates GUI to in-game State
     */
    public void updateGUI() {
        label1.setText("Health Remaining: " + getPlayerHealth());
        label2.setText("Planets Collected: " + getPlanetCount());
        label3.setText("Level: " + level + "/4");

        button2.setText("Save");
        button2.removeActionListener(button2v1);
        button2.addActionListener(button2v2);


        button3.setText("Main Menu");
        button3.removeActionListener(button3v1);
        button3.addActionListener(button3v2);

    }

    /**
     * Ensures music from previous levels isn't running
     */
    public void musicStop() {
        if (menuPlaying == true) {
            menuMusic.stop();
            menuPlaying = false;
        } else if (lvl1Playing == true) {
            lvl1Music.stop();
            lvl1Playing = false;
        } else if (lvl2Playing == true) {
            lvl2Music.stop();
            lvl2Playing = false;
        } else if (lvl3Playing == true) {
            lvl3Music.stop();
            lvl3Playing = false;
        } else if (lvl4Playing == true) {
            lvl4Music.stop();
            lvl4Playing = false;
        } else if (endPlaying == true) {
            endMusic.stop();
            endPlaying = false;
        }
    }

    /**
     * Sets the game to level one, and changes the GUI to reflect
     */
    public void lvl1() {


        level = 1;
        label3.setText("Level: " + level + "/4");
        // get a new world
        world = new Level1(this);
        world.populate(this);
        try {
            musicStop();
            lvl1Music = new SoundClip("data/lvl1.wav");
            lvl1Music.loop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }
        // switch the keyboard control to the new player
        controller.setBody(world.getPlayer());
        controller2.setBody(world.getEnemy());

        // show the new world in the view
        view.setWorld(world);
        //JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();
    }

    /**
     * Moves from main menu to the instructions page
     */

    public void instructions() {

        level = 6;
        world = new Level6Instruction(this);
        world.populate(this);
        try {
            musicStop();
            menuMusic = new SoundClip("data/menu.wav");
            menuMusic.loop();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }


        button3.setText("Main Menu");
        button3.removeActionListener(button3v1);
        button3.addActionListener(button3v2);

        view.setWorld(world);
      //  JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();

    }

    /**
     * Second Game level
     */
    public void goLvl2() {
        label3.setText("Level: " + level + "/4");
        // get a new world
        world = new Level2(this);
        world.populate(this);


        try {
            musicStop();
            lvl2Music = new SoundClip("data/lvl2.wav");
            lvl2Music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }
        controller.setBody(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);
      //  JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();
    }

    /**
     * Third game level
     */
    public void goLvl3() {
        label3.setText("Level: " + level + "/4");
        world = new Level3(this, world);

        //  nextLevel();
        // fill it with bodies
        world.populate(this);

        try {
            musicStop();
            lvl3Music = new SoundClip("data/lvl3.wav");
            lvl3Music.loop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }
        // switch the keyboard control to the new player
        controller.setBody(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);
        //JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();
    }

    /**
     * Fourth game level
     */
    public void goLvl4() {
        label3.setText("Level: " + level + "/4");
        // get a new world
        world = new Level4(this);
        //nextLevel();

        // fill it with bodies
        world.populate(this);
        try {
            musicStop();
            lvl4Music = new SoundClip("data/lvl4.wav");
            lvl4Music.loop();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("no music");
        }
        // switch the keyboard control to the new player
        controller.setBody(world.getPlayer());
        // show the new world in the view
        view.setWorld(world);
      //  JFrame debugView = new DebugViewer(world, 500, 500);
        world.start();
    }

    /**
     * Moves game between levels when being played (when the level is marked as completed)
     */
    public void goNextLevel() {


        world.stop();

        if (level == 1) {
            level++;
            goLvl2();

        } else if (level == 2) {
            level++;
            goLvl3();

        } else if (level == 3) {
            level++;
            goLvl4();

        } else if (level == 4) {
            level++;
            world = new LevelEnd5(this);
            button2.setText("Instructions");
            button2.removeActionListener(button2v2);
            button2.addActionListener(button2v1);
            world.populate(this);
            try {
                musicStop();
                endMusic = new SoundClip("data/end.wav");
                endMusic.loop();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("no music");
            }
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            // JFrame debugView = new DebugViewer(world, 500, 500);
            world.start();

        }


    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }

}
