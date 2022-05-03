import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    JPanel northPanel;
    JPanel gamePanel;
    JLabel ticTacToeLabelText;
    JButton[] buttons = new JButton[9];
    boolean XMovement;
    private static int xMovementCounter;
    private static int oMovementCounter;

    TicTacToe() {

        ticTacToeLabelText = new JLabel();
        ticTacToeLabelText.setFont(new Font("SansSerif", Font.ITALIC, 70));
        ticTacToeLabelText.setVerticalAlignment(JLabel.CENTER);
        ticTacToeLabelText.setForeground(Color.green);

        northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(600, 100));
        northPanel.setBackground(Color.black);
        northPanel.add(ticTacToeLabelText);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3, 5, 5));


        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(gamePanel);
        this.addButtons(buttons);

        this.setVisible(true);
        this.countTime();
        this.firstTurn();
    }

    public void addButtons(JButton[] buttons) {   // adding buttons to panel

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.setFocusable(false);
            button.addActionListener(this);
            button.setBackground(Color.gray);
            button.setFont(new Font("SansSerif", Font.ITALIC, 70));
            buttons[i] = button;
            gamePanel.add(button);
        }

    }

    public void countTime() {   //method which counts down the time until beginning of the game

        disableAllButtons();

        try {
            int i = 3;

            while (i >= 0) {
                Thread.sleep(1000);
                ticTacToeLabelText.setText("" + i);
                i--;
            }

            ticTacToeLabelText.setText("Let's start!");
            Thread.sleep(1000);
            enableAllButtons();   // methods that allows pressing the buttons

        } catch (InterruptedException e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {     //when any button is choosen

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {

                if (XMovement) {
                    buttons[i].setText("X");
                    buttons[i].setBackground(Color.yellow);
                    buttons[i].setEnabled(false);
                    ticTacToeLabelText.setText("O movement!");
                    ++xMovementCounter;
                    XMovement = false;
                } else {
                    buttons[i].setText("O");
                    buttons[i].setBackground(Color.yellow);
                    buttons[i].setEnabled(false);
                    ticTacToeLabelText.setText("X movement!");
                    ++oMovementCounter;
                    XMovement = true;
                }

            }
        }

        if (xWins()) {
            ticTacToeLabelText.setText("X WINS!");
            disableAllButtons();                     // methods that prevents pressing the buttons
        } else if (oWins()) {
            ticTacToeLabelText.setText("O WINS!");
            disableAllButtons();
        }

    }

    public void firstTurn() {                   //method who choose who starts ( X or O )
        Random random = new Random();
        int randomFirstMove = random.nextInt(2);

        if (randomFirstMove == 0) {
            XMovement = false;
            ticTacToeLabelText.setText("O movement !");
        } else {
            XMovement = true;
            ticTacToeLabelText.setText("X movement !");
        }
    }

    public boolean xWins() {                    //what happens if X wins
        boolean xWin = false;

        if (xMovementCounter >= 3) {

            if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
                buttons[0].setBackground(Color.green);
                buttons[1].setBackground(Color.green);
                buttons[2].setBackground(Color.green);
                xWin = true;
            } else if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
                buttons[3].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                xWin = true;
            } else if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
                buttons[6].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                xWin = true;
            } else if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
                buttons[0].setBackground(Color.green);
                buttons[3].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                xWin = true;
            } else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
                buttons[1].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                xWin = true;
            } else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
                buttons[2].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                xWin = true;
            } else if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
                buttons[0].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                xWin = true;
            } else if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
                buttons[2].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                xWin = true;
            }

        }


        return xWin;
    }

    public boolean oWins() {                        //what happens if O wins
        boolean oWin = false;

        if (oMovementCounter >= 3) {

            if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
                buttons[0].setBackground(Color.green);
                buttons[1].setBackground(Color.green);
                buttons[2].setBackground(Color.green);
                oWin = true;
            } else if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
                buttons[3].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                oWin = true;
            } else if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
                buttons[6].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                oWin = true;
            } else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
                buttons[0].setBackground(Color.green);
                buttons[3].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                oWin = true;
            } else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
                buttons[1].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[7].setBackground(Color.green);
                oWin = true;
            } else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
                buttons[2].setBackground(Color.green);
                buttons[5].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                oWin = true;
            } else if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
                buttons[0].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[8].setBackground(Color.green);
                oWin = true;
            } else if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
                buttons[2].setBackground(Color.green);
                buttons[4].setBackground(Color.green);
                buttons[6].setBackground(Color.green);
                oWin = true;
            }

        }

        return oWin;
    }

    public void disableAllButtons() {                       //prevents pressing buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void enableAllButtons() {                        //allows pressing buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
        }
    }


}

