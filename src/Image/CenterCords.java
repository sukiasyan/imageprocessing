package Image;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


@SuppressWarnings("serial")
public class CenterCords  extends JFrame
{
    JToolBar t1;
    JLabel textOut = new JLabel("0");

    public CenterCords(int x , int y)
    {
        createAndShowGUI(x, y);

    }
    private void createAndShowGUI(int w, int h)
    {
        setTitle("Coordinates");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        t1=new JToolBar(JToolBar.VERTICAL);
        textOut.setText("Horizon.- " + Integer.toString(w) + "  Vertical- " +Integer.toString(h));
        t1.add(textOut);


        t1.setRollover(false);

        t1.setFloatable(false);

        add(t1);

        setSize(200,200);
        setLocation(600, 400);
        setVisible(true);


    }

}

























