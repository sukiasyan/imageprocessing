package Image;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
@SuppressWarnings("serial")
public class Tools  extends JFrame
{
    JToolBar t1;
    JCheckBox ch0 = new JCheckBox(" - NOT");
    JCheckBox ch1 = new JCheckBox(" - Filter 1");
    JCheckBox ch2 = new JCheckBox(" - Filter 2");
    JCheckBox ch3 = new JCheckBox(" - Filter 3");
    JCheckBox ch4 = new JCheckBox(" - Filter 4");
    JButton resetFilter = new JButton("Reset Filter");
    boolean isCheckedCh0 = false, isCheckedCh1 = false, isCheckedCh2 = false, isCheckedCh3 = false, isCheckedCh4 = false;

    public Tools()
    {
        createAndShowGUI();
        event e = new event();
        ch0.addItemListener(e);
        ch1.addItemListener(e);
        ch2.addItemListener(e);
        ch3.addItemListener(e);
        ch4.addItemListener(e);
        resetFilter.addItemListener(e);

    }
public class event implements ItemListener{
    public void itemStateChanged(ItemEvent e){
        if (ch0.isSelected()) {
                isCheckedCh0 = true;
            } else {
                isCheckedCh0 = false;
            }
            if (ch1.isSelected()) {
                isCheckedCh1 = true;
            } else {
                isCheckedCh1 = false;
            }
            if (ch2.isSelected()) {
                isCheckedCh2 = true;
            } else {
                isCheckedCh2 = false;
            }
            if (ch3.isSelected()) {
                isCheckedCh3 = true;
            } else {
                isCheckedCh3 = false;
            }
            if (ch4.isSelected()) {
                isCheckedCh4 = true;
            } else {
                isCheckedCh4 = false;
            }
    }
}
    private void createAndShowGUI()
    {
        setTitle("Filters");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        t1=new JToolBar(JToolBar.VERTICAL);

        t1.add(ch0);
        t1.add(ch1);
        t1.add(ch2);
        t1.add(ch3);
        t1.add(ch4);

        t1.add(resetFilter);

        t1.setRollover(false);

        t1.setFloatable(false);

        add(t1);

        setSize(200,400);
        setLocation(100, 400);
        setVisible(true);


    }

}

























