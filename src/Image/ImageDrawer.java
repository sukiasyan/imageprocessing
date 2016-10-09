package Image;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class ImageDrawer extends JFrame implements ActionListener {

    Graphics myg = null;
    private ImageIcon image;
    private BufferedImage buffer;
    private BufferedImage myImage;
    //  private BufferedImage tempPic;
    private JLabel label2;
    private Colors col;
    private JButton drawframe;
    JLabel jl;
    JButton copy;
    public static Color background_color;
    public static Color forground_color;
    JButton filter;
    JButton openFile;
    String imageSourceName;
    boolean isClicked = false;
    public static AddFilters FaceLayor;




    public ImageDrawer() {

        setLocation(100, 100);
        setVisible(true);
        setLayout(new FlowLayout());

        copy = new JButton();
        filter = new JButton();
        openFile = new JButton();
        drawframe = new JButton();
        col = new Colors();


        FaceLayor = new AddFilters();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        copy.setSize(10, 10);
        copy.setText("SaveState");

        filter.setSize(10, 10);
        filter.setText("Filter");
        openFile.setText("Load Image");
        drawframe.setText("Frame");
        jl = new JLabel();

        add(jl);
        add(openFile);
        add(copy);
        add(filter);
        add(drawframe);




        drawframe.addActionListener(this);
        copy.addActionListener(this);
        filter.addActionListener(this);

        add(col, BorderLayout.SOUTH);

        openFile.addActionListener(this);
        repaint();
        pack();


    }

    @Override
    public void paint(Graphics g) {


        Graphics2D g2d = null;
        myg = g;
        super.paint(myg);
        if (isClicked) {


            int w = buffer.getWidth();
            int h = buffer.getHeight();
            myImage = new BufferedImage(buffer.getWidth(), buffer.getHeight(), BufferedImage.TYPE_INT_RGB);
            g2d = myImage.createGraphics();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(buffer.getRGB(j, i));


                    int R = c.getRed();
                    int G = c.getGreen();
                    int B = c.getBlue();
                    if (FaceLayor.CalcFilter(R, B, G)) {
                        if (forground_color == null) {
                            myg.setColor(Color.WHITE);
                            g2d.setColor(Color.WHITE);
                        } else {
                            myg.setColor(forground_color);
                            g2d.setColor(forground_color);
                        }

                        myg.fillRect(j + 13, i + 35, 1, 1);
                        g2d.fillRect(j, i, 1, 1);
                        myg.drawRect(j + 13, i + 35, 1, 1);
                        g2d.drawRect(j, i, 1, 1);

                    } else {
                        if (background_color == null) {
                            myg.setColor(Color.BLACK);
                            g2d.setColor(Color.BLACK);
                        } else
                            myg.setColor(background_color);
                        g2d.setColor(background_color);
                        myg.fillRect(j + 13, i + 35, 1, 1);
                        myg.drawRect(j + 13, i + 35, 1, 1);
                        g2d.fillRect(j, i, 1, 1);
                        g2d.drawRect(j, i, 1, 1);
                    }
                }

            }

            myg.dispose();
            isClicked = false;
        }

    }

    public BufferedImage readImage(String fileName) {
        buffer = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        File f = new File(fileName);
        try {
            buffer = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public void setImage(BufferedImage bi) {
        ImageIcon icon = new ImageIcon(bi);
        label2 = new JLabel(icon);
        add(label2);
    }


    public void save(String name) {
        File f = new File(name);
        String suffix = name.substring(name.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        try {
            if (myImage != null) {
                ImageIO.write(myImage, suffix, f);
            } else {
                ImageIO.write(readImage(name), suffix, f);
            }
            setImage(readImage(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Browse the folder to process");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {


            image = new ImageIcon(chooser.getSelectedFile().toString());
            imageSourceName = chooser.getSelectedFile().toString();
            buffer = readImage(imageSourceName);
            jl.setIcon(image);

            invalidate();
            pack();

        } else {
            System.out.println("No Selection ");
        }
    }

    public void drawFrame() {

        GeometryIm geo = new GeometryIm(buffer);
        myg = getGraphics();
        int w = (int) geo.getMeanX();
        int h = (int) geo.getMeanY();
        CenterCords cords = new CenterCords(w,h);
        int dX = (int) geo.deviationX();
        int dY = (int) geo.deviationY();
        myg.setColor(Color.RED);
        myg.fillOval(w + 9, h + 30, 10, 10);
        myg.drawOval(w + 9, h + 30, 10, 10);
        myg.drawRect(w - dX + 9, h - dY + 30, dX * 2, dY * 2);
        myg.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == openFile) {
            chooseFile();
        }
        if (e.getSource() == filter) {
            Graphics g = getGraphics();
            isClicked = true;
            paint(g);
        } else if (e.getSource() == copy) {
            String pictureName = JOptionPane.showInputDialog("Name of New picture and format png/gif/bmp");
            save(pictureName);
        } else if (e.getSource() == drawframe) {
            drawFrame();
        }

    }

    public static void main(String[] args) {
        new ImageDrawer();

    }

}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  