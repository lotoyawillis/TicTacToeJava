import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TicTacToe {
    //I created a panel for every part of the display: the fsu header,
    // the grid, the winner display, the reset button, and my name
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel mainPanel = new JPanel();

    JPanel fsuPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    // array of buttons to save the values for later use
    JButton[] button = new JButton[9];
    JPanel gridPanel = new JPanel();

    JPanel winnerPanel = new JPanel();
    JLabel winner = new JLabel();
    JPanel resetPanel = new JPanel();
    JButton reset = new JButton();
    boolean firstPlayer = true;
    int turn = 0;
    TicTacToe()
    {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sets the size
        mainPanel.setPreferredSize(new Dimension(400, 400));


        JLabel label = new JLabel("FSU", SwingConstants.CENTER);

        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 50));
        fsuPanel.add(label);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        //nested for loop to create the grid
        int k = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                button[k] = new JButton("");
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.5;
                c.ipady = 20;
                c.gridx = j;
                c.gridy = i;
                button[k].setFocusable(false);
                button[k].addActionListener(this::actionPerformed);

                panel.add(button[k], c);
                k++;
            }
        }

        //adds it to the grid panel
        gridPanel.add(panel);


        //creates the reset button and calls the "resetActionPerformed"
        // function when clicked
        reset = new JButton("Reset");
        reset.setFocusable(false);
        reset.addActionListener(this::resetActionPerformed);
        //adds it to the reset button panel
        resetPanel.add(reset);


        //creates the winner display
        JLabel winnerLabel = new JLabel("", SwingConstants.CENTER);

        winnerLabel.setFont(new Font(winnerLabel.getFont().getName(), winnerLabel.getFont().getStyle(), 20));
        winnerPanel.add(winnerLabel);


        //creates the display for my name
        JLabel nameLabel = new JLabel("Lotoya Willis", SwingConstants.CENTER);

        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 50));

        //adds it to the name panel
        bottomPanel.add(nameLabel);


        // adds all panels to the main panel
        mainPanel.add(fsuPanel);
        mainPanel.add(gridPanel);
        mainPanel.add(winnerPanel);
        mainPanel.add(resetPanel);
        mainPanel.add(bottomPanel);

        //adds main panel to the frame
        frame.add(mainPanel);

        frame.setSize(400, 400);

        frame.setVisible(true);

    }

    //displays x wins
    public void xWinner()
    {
        winner.setText("X Wins!!!");
        winnerPanel.add(winner);
    }

    //displays o wins
    public void oWinner()
    {
        winner.setText("O Wins!!!");
        winnerPanel.add(winner);
    }

    //determines if a player has one either horizontally, diagonally, or vertically
    public void winnerCheck()
    {
        if ((Objects.equals(button[0].getText(), "X")) && (Objects.equals(button[1].getText(), "X")) && (Objects.equals(button[2].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[0].getText(), "X")) && (Objects.equals(button[4].getText(), "X")) && (Objects.equals(button[8].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[0].getText(), "X")) && (Objects.equals(button[3].getText(), "X")) && (Objects.equals(button[6].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[1].getText(), "X")) && (Objects.equals(button[4].getText(), "X")) && (Objects.equals(button[7].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[2].getText(), "X")) && (Objects.equals(button[4].getText(), "X")) && (Objects.equals(button[6].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[2].getText(), "X")) && (Objects.equals(button[5].getText(), "X")) && (Objects.equals(button[8].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[3].getText(), "X")) && (Objects.equals(button[4].getText(), "X")) && (Objects.equals(button[5].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[6].getText(), "X")) && (Objects.equals(button[7].getText(), "X")) && (Objects.equals(button[8].getText(), "X")))
        {
            xWinner();
        }
        else if ((Objects.equals(button[0].getText(), "O")) && (Objects.equals(button[1].getText(), "O")) && (Objects.equals(button[2].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[0].getText(), "O")) && (Objects.equals(button[3].getText(), "O")) && (Objects.equals(button[6].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[0].getText(), "O")) && (Objects.equals(button[4].getText(), "O")) && (Objects.equals(button[8].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[1].getText(), "O")) && (Objects.equals(button[4].getText(), "O")) && (Objects.equals(button[7].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[2].getText(), "O")) && (Objects.equals(button[4].getText(), "O")) && (Objects.equals(button[6].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[2].getText(), "O")) && (Objects.equals(button[5].getText(), "O")) && (Objects.equals(button[8].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[3].getText(), "O")) && (Objects.equals(button[4].getText(), "O")) && (Objects.equals(button[5].getText(), "O")))
        {
            oWinner();
        }
        else if ((Objects.equals(button[6].getText(), "O")) && (Objects.equals(button[7].getText(), "O")) && (Objects.equals(button[8].getText(), "O")))
        {
            oWinner();
        }
        else if (turn == 9) //if no one wins after 9 turns
        {
            winner.setText("It's a Tie!!!");
            winnerPanel.add(winner);
        }
    }

    //sets text to either "X" or "O" based on whose turn it is, preps the next player
    //, increments turn, and displays whose turn it is
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == button[i])
            {
                if (firstPlayer)
                {
                    if (Objects.equals(button[i].getText(), ""))
                    {
                        button[i].setText("X");
                        firstPlayer = false;
                        turn++;
                        winner.setText("O's turn");
                        winnerPanel.add(winner);
                        winnerCheck();
                    }
                }
                else
                {
                    if (Objects.equals(button[i].getText(), ""))
                    {
                        button[i].setText("O");
                        firstPlayer = true;
                        turn++;
                        winner.setText("X's turn");
                        winnerPanel.add(winner);
                        winnerCheck();
                    }
                }
            }
        }
    }

    //resets the game
    public void resetActionPerformed(ActionEvent e)
    {
        if (e.getSource() == reset)
        {
            frame.dispose();
            new TicTacToe();
        }
    }


}
