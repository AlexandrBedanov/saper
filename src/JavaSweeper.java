import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class JavaSweeper extends JFrame {
    private JPanel panel;
    private final int COLS = 15;  // столбцы
    private final int Rows = 1;   // строчки
    private final int IMAGE_SIZE=50;
    public static void main(String[] args)
    {
       new JavaSweeper();

    }
    private JavaSweeper(){
        initPanel();
        initFrame();
    }



    private  void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"),0,0,this);
                g.drawImage(getImage("num1"),IMAGE_SIZE,0,this);
            }
        };

         panel.setPreferredSize(new

            Dimension(COLS*IMAGE_SIZE, Rows*IMAGE_SIZE));   //размер окна

            add(panel);
        }


    private void initFrame(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //возможность закрывать окно
        setTitle("Java Sweeper");  // название игры
        setLocationRelativeTo(null);  // окно по центру
        setResizable(false);  // не изменять размер окна
        setVisible(true);

    }

    private Image getImage(String name){
        String filename = "img/" + name.toLowerCase()+ ".png";    //имя файла для каждой картинки
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));  // обращаться по имени файла
        return  icon.getImage();
    }
}
