package Image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Colors extends JPanel implements ActionListener {

    JPanel jp;


    //    ComboBox
    String[] messageStrings = {"Please choose color scheme", "Black White", "Template1 BlueOrange", "Template2 RedGreen", "Template3 YellowBlue", "Template4 WhiteGray"};
    JComboBox cmdMessageList = new JComboBox(messageStrings);
    JLabel lblText = new JLabel();

    public Colors() {

//        ComboBox
        cmdMessageList.setSelectedIndex(0);
        cmdMessageList.addActionListener(this);
        add(cmdMessageList);
        add(lblText);


        //b_green = new JButton();


        setPreferredSize(new Dimension(250, 50));
        setLayout(new GridLayout(1, 6));
    }

    public static void main(String[] args) {
        new Colors();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub


        if (e.getSource() == cmdMessageList){
            JComboBox cb = (JComboBox)e.getSource();

            String msg = (String)cb.getSelectedItem();

            switch (msg) {
                case "Template1 BlueOrange" : ImageDrawer.background_color = Color.blue; ImageDrawer.forground_color = Color.orange;
                    break;
                case "Template2 RedGreen" : ImageDrawer.background_color = Color.red; ImageDrawer.forground_color = Color.GREEN;
                    break;
                case "Template3 YellowBlue" : ImageDrawer.background_color = Color.yellow; ImageDrawer.forground_color = Color.blue;
                    break;
                case "Template4 WhiteGray" : ImageDrawer.background_color = Color.white; ImageDrawer.forground_color = Color.darkGray;
                    break;
                default:  ImageDrawer.background_color = Color.black; ImageDrawer.forground_color = Color.white;
            }
        }
    }


}
