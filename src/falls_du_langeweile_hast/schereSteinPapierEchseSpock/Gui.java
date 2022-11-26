package falls_du_langeweile_hast.schereSteinPapierEchseSpock;

import falls_du_langeweile_hast.utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Gui extends JFrame {

    private final int ROCK = 0;
    private final int PAPER = 1;
    private final int SCISSORS = 2;
    private final int LIZARD = 3;
    private final int SPOCK = 4;

    private final int PLAYER = 0;
    private final int COMPUTER = 1;

    private final String PATH = "/schereSteinPapierEchseSpock/";

    private int chosen = -1;
    private int computerChoice = -1;
    private final int[] counter = new int[2];

    private final Icon[] images = new Icon[5];

    private final JButton bRock = new JButton();
    private final JButton bPaper = new JButton();
    private final JButton bScissors= new JButton();
    private final JButton bLizard = new JButton();
    private final JButton bSpock = new JButton();
    private final JButton bRules = new JButton("RULES");
    private final JLabel lPlayerChoice = new JLabel();
    private final JLabel lComputerChoice = new JLabel();
    private final JLabel lVS = new JLabel();
    private final JLabel lRules = new JLabel();
    private final JLabel lCounterPlayer = new JLabel("0");
    private final JLabel lCounterComputer = new JLabel("0");

    public Gui(){
        super();
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("rock-paper-scissors-lizard-Spock");
        setLocationRelativeTo(null);
        setBackground(Color.CYAN);
        setResizable(false);
        setLayout(null);

        for (int i = 0; i < images.length; i++) {
            images[i] = ImageLoader.getIcon(PATH,i+".jpg");
        }

        initializeLabels();
        initializeButtons();
        addAll();

        setVisible(true);
    }

    private void addAll() {
        add(lRules);
        add(bRock);
        add(bPaper);
        add(bScissors);
        add(bLizard);
        add(bSpock);
        add(bRules);
        add(lComputerChoice);
        add(lPlayerChoice);
        add(lCounterPlayer);
        add(lCounterComputer);
        add(lVS);
    }

    private void initializeButtons() {
        bRules.setBounds(getWidth()-100,getHeight()-85,80,40);
        bRules.addActionListener(e-> lRules.setVisible(!lRules.isVisible()));

        bRock.setBounds(10,10,100,100);
        bRock.setBackground(Color.LIGHT_GRAY);
        bRock.setIcon(images[ROCK]);
        bRock.addActionListener(e -> {
            chosen = ROCK;
            buttonAction();
        });

        bPaper.setBounds(10,120,100,100);
        bPaper.setBackground(Color.LIGHT_GRAY);
        bPaper.setIcon(images[PAPER]);
        bPaper.addActionListener(e -> {
            chosen = PAPER;
            buttonAction();
        });

        bScissors.setBounds(10,230,100,100);
        bScissors.setBackground(Color.LIGHT_GRAY);
        bScissors.setIcon(images[SCISSORS]);
        bScissors.addActionListener(e -> {
            chosen = SCISSORS;
            buttonAction();
        });

        bLizard.setBounds(10,340,100,100);
        bLizard.setBackground(Color.LIGHT_GRAY);
        bLizard.setIcon(images[LIZARD]);
        bLizard.addActionListener(e -> {
            chosen = LIZARD;
            buttonAction();
        });

        bSpock.setBounds(10,450,100,100);
        bSpock.setBackground(Color.LIGHT_GRAY);
        bSpock.setIcon(images[SPOCK]);
        bSpock.addActionListener(e -> {
            chosen = SPOCK;
            buttonAction();
        });
    }

    private void buttonAction() {
        lPlayerChoice.setIcon(images[chosen]);
        computerChoice = computer();
        lComputerChoice.setIcon(images[computerChoice]);
        rules();
    }

    private void initializeLabels() {
        Font font = new Font("Consolas",Font.PLAIN,40);
        lCounterPlayer.setBounds(200,50,50,50);
        lCounterPlayer.setOpaque(true);
        lCounterPlayer.setBackground(Color.LIGHT_GRAY);
        lCounterPlayer.setFont(font);
        lCounterPlayer.setHorizontalTextPosition(JLabel.CENTER);
        lCounterPlayer.setHorizontalAlignment(JLabel.CENTER);

        lCounterComputer.setBounds(500,50,50,50);
        lCounterComputer.setOpaque(true);
        lCounterComputer.setBackground(Color.LIGHT_GRAY);
        lCounterComputer.setFont(font);
        lCounterComputer.setHorizontalTextPosition(JLabel.CENTER);
        lCounterComputer.setHorizontalAlignment(JLabel.CENTER);

        lPlayerChoice.setBounds(200,230,100,100);
        lPlayerChoice.setOpaque(true);
        lPlayerChoice.setBackground(Color.LIGHT_GRAY);

        lVS.setBounds(350,230,100,100);
        lVS.setIcon(ImageLoader.getIcon(PATH,"VS.png"));

        lComputerChoice.setBounds(500,230,100,100);
        lComputerChoice.setOpaque(true);
        lComputerChoice.setBackground(Color.LIGHT_GRAY);

        lRules.setBounds(150,25,500,500);
        lRules.setIcon(ImageLoader.getIcon(PATH,"rules.jpg"));
        lRules.setVisible(false);
    }

    private int computer(){
        return (int) (Math.random()*4);
    }


    private void rules(){
        if(chosen == ROCK && (computerChoice == SCISSORS || computerChoice == LIZARD)){
            counter[PLAYER]++;
        } else if(computerChoice == ROCK && (chosen == SCISSORS || chosen == LIZARD)){
            counter[COMPUTER]++;
        } else if(chosen == PAPER && (computerChoice == SPOCK || computerChoice == ROCK)){
            counter[PLAYER]++;
        } else if(computerChoice == PAPER && (chosen == SPOCK || chosen == ROCK)){
            counter[COMPUTER]++;
        } else if(chosen == SCISSORS && (computerChoice == PAPER || computerChoice == LIZARD)){
            counter[PLAYER]++;
        } else if(computerChoice == SCISSORS && (chosen == PAPER || chosen == LIZARD)){
            counter[COMPUTER]++;
        } else if(chosen == LIZARD && (computerChoice == PAPER || computerChoice == SPOCK)){
            counter[PLAYER]++;
        } else if(computerChoice == LIZARD && (chosen == PAPER || chosen == SPOCK)){
            counter[COMPUTER]++;
        } else if(chosen == SPOCK && (computerChoice == ROCK || computerChoice == SCISSORS)){
            counter[PLAYER]++;
        } else if(computerChoice == SPOCK && (chosen == ROCK || chosen == SCISSORS)){
            counter[COMPUTER]++;
        }

        printStats();

        if(counter[PLAYER] == 5){
            JOptionPane.showMessageDialog(null,"YOU WIN!");
            reset();
        } else if(counter[COMPUTER] == 5){
            JOptionPane.showMessageDialog(null,"YOU LOSE!");
            reset();
        }

    }

    private void printStats() {
        lCounterPlayer.setText(""+counter[PLAYER]);
        lCounterComputer.setText(""+counter[COMPUTER]);
    }

    private void reset() {
        Arrays.fill(counter,0);
        lPlayerChoice.setIcon(null);
        lComputerChoice.setIcon(null);
        printStats();
    }


    public static void main(String[] args) {
        new Gui();
    }
}
