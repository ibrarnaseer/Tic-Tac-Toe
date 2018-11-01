import javax.swing.SwingUtilities;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() { /* Uten invokeLater ville ikke
    meny baren på toppen komme inn før en spiller allerede hadde valgt
    en rute, siden det er da den ble oppdatert. */

      @Override
      public void run() {
        new TicTacToeGUI();
      }
    });
  }
}
