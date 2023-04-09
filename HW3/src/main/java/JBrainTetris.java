import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.TimeUnit;

public class JBrainTetris extends JTetris{
    /**
     * Creates a new JTetris where each tetris square
     * is drawn with the given number of pixels.
     *
     * @param pixels
     */
    protected DefaultBrain brain = new DefaultBrain();
    private JCheckBox checkBox = new JCheckBox("Artificial Intelligent",false);
    private JSlider adversary;
    private JLabel label = new JLabel("ok");
    private boolean playAI = false;
    private int pieceNum = -1;
    JBrainTetris(int pixels) {
        super(pixels);
    }
    private void updateCounters() {
        countLabel.setText("Pieces " + count);
        scoreLabel.setText("Score " + score);
    }
    private int current_count = 0;
    private Brain.Move move = null;
    @Override
    public void tick(int verb) {
        super.tick(verb);
        if(verb == DOWN && playAI)
        {
            if(current_count - count !=0 )
            {
                board.undo();
                move = brain.bestMove(board,currentPiece,HEIGHT,move);
                current_count = count;
            }
            if(move != null)
            {
                if(currentX < move.x)
                {
                    tick(RIGHT);
                }
                if(currentX > move.x)
                {
                    tick(LEFT);
                }
                if(!(move.piece == currentPiece))
                {
                    tick(ROTATE);
                }
            }
        }
    }
    public JComponent createControlPanel() {
        JPanel panel = (JPanel) super.createControlPanel();
        JPanel little = new JPanel();

        little.add(new JLabel("adversary"));
        adversary = new JSlider(0, 100, 0); // min, max, current
        adversary.setPreferredSize(new Dimension(100,15));
        little.add(adversary);
        little.add(label);
        panel.add(little);

        panel.add(new JLabel("Play with Artificial Intelligent: "));
        panel.add(checkBox);
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    playAI = true;
                } else {
                    playAI = false;
                }
            }
        });
        return panel;
    }
    public Piece pickNextPiece() {
        Piece piece = null;
        if(adversary.getValue() <= Math.abs(random.nextInt()%99)+1)
        {
            pieceNum = (int) (pieces.length * random.nextDouble());

            piece = pieces[pieceNum];

            label.setText("ok");

        }
        else{
            if(pieceNum == -1)
            {
                pieceNum = (int) (pieces.length * random.nextDouble());
            }
            pieceNum = (pieceNum+1)%7;
            piece = pieces[pieceNum];
            label.setText("ko");
        }
        return (piece);
    }
    public static void main(String[] args) {
        // Set GUI Look And Feel Boilerplate.
        // Do this incantation at the start of main() to tell Swing
        // to use the GUI LookAndFeel of the native platform. It's ok
        // to ignore the exception.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        JBrainTetris tetris = new JBrainTetris(16);
        JFrame frame = JBrainTetris.createFrame(tetris);
        frame.setVisible(true);
    }
}
