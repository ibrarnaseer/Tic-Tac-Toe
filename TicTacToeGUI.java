import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI extends JFrame { // Deklarasjoner.
  private Container pane;
  private String spiller;
  private JButton [][] brett;
  private boolean harVunnet;
  private JMenuBar menyBar;
  private JMenu meny;
  private JMenuItem avslutt;
  private JMenuItem nyttSpill;

  public TicTacToeGUI() {
    super();
    pane = getContentPane();
    // Kosmetisk alt under her. Kan endres som ønsket.
    pane.setLayout(new GridLayout(3, 3));
    setTitle("Tic Tac Toe");
    setSize(500, 500);
    setResizable(false);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);
    spiller = "X";
    brett = new JButton [3][3];
    harVunnet = false;
    initialisereBrett();
    initialisereMenyBar();
  }

  private void initialisereMenyBar() { // Metode for å gjøre klar meny baren.
    menyBar = new JMenuBar();
    meny = new JMenu("Fil"); // Skal stå "fil" så kommer en dropdown meny hvis man trykker.

    nyttSpill = new JMenuItem("Nytt Spill");
    nyttSpill.addActionListener(new ActionListener() { /* I dropdown menyen
    skal det være en knapp hvor det står "Nytt Spill". Denne knappen skal,
    når trykket på, kjøre metoden resetBrett(). */

      @Override
      public void actionPerformed(ActionEvent e) {
        resetBrett();
      }
    });
    avslutt = new JMenuItem("Avslutt");
    avslutt.addActionListener(new ActionListener() { /* Andre knappen i dropdown
    menyen. Denne heter "Avslutt" og skal, når trykket på, avslutte.
    Dvs. lukke GUI'en og avslutte programmet i terminal. */

      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    meny.add(nyttSpill);
    meny.add(avslutt);
    menyBar.add(meny);
    setJMenuBar(menyBar);
  }

  private void resetBrett() { // Metode for å gjøre klart brettet for nytt spill.
    spiller = "X";
    harVunnet = false;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        brett[i][j].setText("");
      }
    }
  }

  private void initialisereBrett() {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        JButton knapp = new JButton();
        // For å fikse knappen (X'ene og O'ene):
        knapp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
        brett[i][j] = knapp;
        knapp.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) { /* For å få knappen til å
          gjøre noe. (Knapp uten ActionEvent er ubrukelig). */
            if(((JButton)e.getSource()).getText().equals("") &&
            harVunnet == false) {
              knapp.setText(spiller);
              // Endre farge basert på spiller. 
              if(spiller.equals("X")) {
                knapp.setForeground(Color.BLUE);
              }
              else if (spiller.equals("O")) {
                knapp.setForeground(Color.RED);
              }
              harVunnet();
              velgeSpiller();
            }
          }
        });
        pane.add(knapp);
      }
    }
  }

  private void velgeSpiller() { // Metoden som bytter mellom spillere.
    if(spiller.equals("X")) {
      spiller = "O";
    }
    else {
      spiller = "X";
    }
  }

  private void harVunnet() { /* Metoden bruker if/else løkker for å sjekke om visse
    ruter er valgt samtidig av samme spiller. Hvis det er tre på rad, så printer
    den ut en melding om at den spilleren har vunnet. */
    if(brett[0][0].getText().equals(spiller) && brett[1][0].getText().equals(spiller)
    && brett[2][0].getText().equals(spiller)) { /* Så her hvis øverst til venstre,
    midten venstre, og nederst til venstre er valgt av samme spiller, så
    vinner den spilleren. */
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[0][1].getText().equals(spiller) && brett[1][1].getText().equals(spiller)
    && brett[2][1].getText().equals(spiller)) { // Øverst midten, midten midten, nederst midten.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[0][2].getText().equals(spiller) && brett[1][2].getText().equals(spiller)
    && brett[2][2].getText().equals(spiller)) { // Øverst høyre, midten høyre, nederst høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[0][0].getText().equals(spiller) && brett[1][1].getText().equals(spiller)
    && brett[2][2].getText().equals(spiller)) { // Øverst venstre, midten midten, nederst høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[2][0].getText().equals(spiller) && brett[1][1].getText().equals(spiller)
    && brett[0][2].getText().equals(spiller)) { // Nederst venstre, midten midten, øverst høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[0][0].getText().equals(spiller) && brett[0][1].getText().equals(spiller)
    && brett[0][2].getText().equals(spiller)) { // Øverst venstre, øverst midten, øverst høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[1][0].getText().equals(spiller) && brett[1][1].getText().equals(spiller)
    && brett[1][2].getText().equals(spiller)) { // Midten venstre, midten midten, midten høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
    else if(brett[2][0].getText().equals(spiller) && brett[2][1].getText().equals(spiller)
    && brett[2][2].getText().equals(spiller)) { // Nederst venstre, nederst midten, nederst høyre.
      JOptionPane.showMessageDialog(null, "Spiller " + spiller + " har vunnet!");
      harVunnet = true;
    }
  }
}
