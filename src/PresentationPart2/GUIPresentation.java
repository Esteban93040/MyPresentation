package PresentationPart2;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.KeyEvent;

public class GUIPresentation extends JFrame {
    private JButton myPhoto;
    private JButton myHobby;
    private JButton myExpectations;
    private Title title;
    private JPanel containerButtons;
    private JPanel containerImage;
    private Listener listener;
    private JLabel imageLabel;
    private JTextArea expectationsText;


    public GUIPresentation() throws FontFormatException {
        this.initGUI();
        this.setTitle("Hello bitch");
        this.setSize(1080, 720);
        this.setVisible(true);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setBackground(Color.CYAN);

    }

    private void initGUI() throws FontFormatException {
        this.title = new Title("Esteban Espinosa", Color.magenta);
        this.myPhoto = new JButton("This is me");
        this.myHobby = new JButton("This is my hobby");
        this.myExpectations = new JButton("What is my expectations");
        this.imageLabel = new JLabel();
        this.containerImage = new JPanel();
        this.expectationsText = new JTextArea();
        this.containerImage.setBorder(BorderFactory.createTitledBorder((Border)null, "Somethings about me", 2, 0, new Font("Monospaced", 0, 20), Color.blue));
        this.containerImage.add(this.imageLabel);
        this.containerButtons = new JPanel();
        this.containerButtons.setBackground(Color.BLACK);
        this.listener = new Listener();
        this.containerButtons.add(this.myPhoto);
        this.containerButtons.add(this.myHobby);
        this.myPhoto.addActionListener(this.listener);
        this.myPhoto.addKeyListener(this.listener);
        this.myHobby.addActionListener(this.listener);
        this.myHobby.addMouseListener(this.listener);
        this.myHobby.addKeyListener(this.listener);
        this.myExpectations.addActionListener(this.listener);
        this.myExpectations.addMouseListener(this.listener);
        this.myExpectations.addKeyListener(this.listener);
        this.add(this.title, "North");
        this.add(this.containerButtons, "South");
        this.add(this.containerImage, "Center");
        expectationsText.setEditable(false);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new GUIPresentation();
                }

                catch (FontFormatException var2) {

                    throw new RuntimeException(var2);
                }
            }
        });
    }

    private class Listener implements ActionListener, KeyListener,MouseListener {
        private ImageIcon Image;

      public void actionPerformed(ActionEvent e) {

            if (e.getSource() == GUIPresentation.this.myPhoto) {
                containerImage.remove(expectationsText);
                imageLabel.setIcon(null);
                this.Image = new ImageIcon(this.getClass().getResource("/resources/Me.png"));
                GUIPresentation.this.imageLabel.setIcon(this.Image);
            }


        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Inside");
            //System.out.println(e.getKeyChar());
            if(e.getKeyCode() == 77) {
                imageLabel.setIcon(null);
                GUIPresentation.this.expectationsText.setText("I expect to learn Java,Javascript, html and css and more things about this world called software developers   \nMy contact is espinosa.esteban@correounivalle.edu.co\nCod:2181610-2724");
                GUIPresentation.this.expectationsText.setBackground(Color.WHITE);
                GUIPresentation.this.expectationsText.setForeground(Color.DARK_GRAY);
                GUIPresentation.this.containerImage.add(GUIPresentation.this.expectationsText);


            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2){
                containerImage.remove(expectationsText);
                imageLabel.setIcon(null);
                this.Image = new ImageIcon(this.getClass().getResource("/resources/Hobby.png"));
                GUIPresentation.this.imageLabel.setIcon(this.Image);

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
