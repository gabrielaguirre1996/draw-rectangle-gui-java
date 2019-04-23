/*
    Gabriel Aguirre
    November 28, 2018
    Desc: Simple GUI application in Java. Allows user to
          enter coordinates and draw a rectangle with them
          made-up of the characters entered. Makes use of
          Java drop-down menus.
*/

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DrawRectanglesGUI extends JFrame {

    // Menu GUI
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    private JMenu optionsMenu;
    private JMenuItem printAreaItem;
    private JMenuItem printPerimeterItem;
    private JMenuItem printRectItem;

    // panels
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    // radio buttons
    private JCheckBox outerChars;
    private JCheckBox innerChars;
    private ButtonGroup cg;

    //checkboxes
    private JRadioButton blue;
    private JRadioButton red;
    private JRadioButton green;

    // input GUI
    private JLabel coordinate_input_label_1, coordinate_input_label_2, coordinate_input_label_3, coordinate_input_label_4, rectChar_1_label, rectChar_2_label;
    private JTextField rectangleCoordinate_1_TF, rectangleCoordinate_2_TF, rectangleCoordinate_3_TF, rectangleCoordinate_4_TF, rectChar_1_TF, rectChar_2_TF;
    //private JButton clickBtn_1, clickBtn_2, clickBtn_3;

    // output GUI
    private JTextArea outputTA;

    // scroller
    private JScrollPane scroller;

    public static void main(String[] args) {
        DrawRectanglesGUI ldRectGUI = new DrawRectanglesGUI();
    }

    public DrawRectanglesGUI() {
        setTitle ("Draw Rectangle");
        setSize (1250, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildMenuBar();
        buildPanel();
        add(mainPanel);
        setVisible(true);
    }

     private void buildPanel(){

        // input panel
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.cyan);

        coordinate_input_label_1 = new JLabel("x1");
        rectangleCoordinate_1_TF = new JTextField(3);
        coordinate_input_label_2 = new JLabel("x2");
        rectangleCoordinate_2_TF = new JTextField(3);
        coordinate_input_label_3 = new JLabel("y1");
        rectangleCoordinate_3_TF = new JTextField(3);
        coordinate_input_label_4 = new JLabel("y2");
        rectangleCoordinate_4_TF = new JTextField(3);

        rectChar_1_label = new JLabel("Enter outer character: ");
        rectChar_1_TF = new JTextField(3);
        rectChar_2_label = new JLabel("Enter inner character: ");
        rectChar_2_TF = new JTextField(3);

//        clickBtn_1 = new JButton("Print Rectangle Area");
//        clickBtn_1.addActionListener(new printAreaListener());
//        clickBtn_2 = new JButton("Print Rectangle Perimeter");
//        clickBtn_2.addActionListener(new printPerimeterListener());
//        clickBtn_3 = new JButton("Draw Rectangle");
//        clickBtn_3.addActionListener(new drawRectangleListener());

        inputPanel.add(coordinate_input_label_1);
        inputPanel.add(rectangleCoordinate_1_TF);
        inputPanel.add(coordinate_input_label_2);
        inputPanel.add(rectangleCoordinate_2_TF);
        inputPanel.add(coordinate_input_label_3);
        inputPanel.add(rectangleCoordinate_3_TF);
        inputPanel.add(coordinate_input_label_4);
        inputPanel.add(rectangleCoordinate_4_TF);
        inputPanel.add(rectChar_1_label);
        inputPanel.add(rectChar_1_TF);
        inputPanel.add(rectChar_2_label);
        inputPanel.add(rectChar_2_TF);
//        inputPanel.add(clickBtn_1);
//        inputPanel.add(clickBtn_2);
//        inputPanel.add(clickBtn_3);

        // output panel
        outputPanel = new JPanel();
        outputPanel.setBackground(Color.black);

        // button panel
        buttonPanel = new JPanel();
        outerChars = new JCheckBox("Show Outer Characters", true);
        innerChars = new JCheckBox("Show Inner Characters");
        blue = new JRadioButton("Blue", true);
        red = new JRadioButton("Red");
        green = new JRadioButton("Green");

        //cg = new ButtonGroup();
        buttonPanel.add(outerChars);
        buttonPanel.add(innerChars);
        buttonPanel.add(blue);
        buttonPanel.add(red);
        buttonPanel.add(green);

        outputTA = new JTextArea(25, 50);
        JScrollPane scroller = new JScrollPane(outputTA);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        //outputPanel.add(outputTA);
        outputPanel.add(scroller);

        // main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);
    }

    private void buildMenuBar()
    {
        menuBar = new JMenuBar();

        buildFileMenu();
        buildOptionsMenu();

        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);
    }

    private void buildFileMenu()
    {
        fileMenu=new JMenu("File");

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener (new ExitListener());

        fileMenu.add(exitItem);
    }

    private void buildOptionsMenu()
    {
        optionsMenu=new JMenu("Options");

        printAreaItem = new JMenuItem("Print Area");
        printAreaItem.addActionListener(new printAreaListener());

        printPerimeterItem = new JMenuItem("Print Perimeter");
        printPerimeterItem.addActionListener(new printPerimeterListener());

        printRectItem = new JMenuItem("Print Rectangle");
        printRectItem.addActionListener (new drawRectangleListener());

        optionsMenu.add(printAreaItem);
        optionsMenu.addSeparator();
        optionsMenu.add(printPerimeterItem);
        optionsMenu.addSeparator();
        optionsMenu.add(printRectItem);
    }

    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
     
    private class printAreaListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            String inputStr_1, inputStr_2, inputStr_3, inputStr_4;
            int x1, x2, y1, y2;
            int area;
            
            inputStr_1=rectangleCoordinate_1_TF.getText();
            inputStr_2=rectangleCoordinate_2_TF.getText();
            inputStr_3=rectangleCoordinate_3_TF.getText();
            inputStr_4=rectangleCoordinate_4_TF.getText();
            x1 = Integer.parseInt(inputStr_1);
            x2 = Integer.parseInt(inputStr_2);
            y1 = Integer.parseInt(inputStr_3);
            y2 = Integer.parseInt(inputStr_4);

            area = (Math.abs((x2 - x1)) * Math.abs((y2 - y1)));
            System.out.println("Area: " + area);
            outputTA.append("Area: " + area + "\n");
        }
    }
    
    private class printPerimeterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String inputStr_1, inputStr_2, inputStr_3, inputStr_4;
            int x1, x2, y1, y2;
            int perimeter;
            
            inputStr_1=rectangleCoordinate_1_TF.getText();
            inputStr_2=rectangleCoordinate_2_TF.getText();
            inputStr_3=rectangleCoordinate_3_TF.getText();
            inputStr_4=rectangleCoordinate_4_TF.getText();
            x1 = Integer.parseInt(inputStr_1);
            x2 = Integer.parseInt(inputStr_2);
            y1 = Integer.parseInt(inputStr_3);
            y2 = Integer.parseInt(inputStr_4);

            perimeter = ((Math.abs((x2 - x1)) + Math.abs((y2 - y1))) * 2);
            System.out.println("Perimeter: " + perimeter);
            outputTA.append("Perimeter: " + perimeter + "\n");
        }
    }
    
    private class drawRectangleListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String inputStr_1;
            String inputStr_2;
            String inputStr_3;
            String inputStr_4;
            String inputStr_5;
            String inputStr_6;
            String rectangleChar_1, rectangleChar_2;

            int x1, x2, y1, y2;
            
            inputStr_1 = rectangleCoordinate_1_TF.getText();
            inputStr_2 = rectangleCoordinate_2_TF.getText();
            inputStr_3 = rectangleCoordinate_3_TF.getText();
            inputStr_4 = rectangleCoordinate_4_TF.getText();
            inputStr_5 = rectChar_1_TF.getText();
            inputStr_6 = rectChar_2_TF.getText();

            x1 = Integer.parseInt(inputStr_1);
            x2 = Integer.parseInt(inputStr_2);
            y1 = Integer.parseInt(inputStr_3);
            y2 = Integer.parseInt(inputStr_4);

            rectangleChar_1 = inputStr_5;
            rectangleChar_2 = inputStr_6;
            
            drawRectangle(x1, x2, y1, y2, rectangleChar_1, rectangleChar_2);
            
        }
    }
    
    public void drawRectangle(int x1, int x2, int y1, int y2, String char1, String char2) {

            for (int i = 0; i < 25; i++) {
                System.out.print(i + "\t");
                outputTA.append(i + "\t");
            }
            System.out.print("\n");
            outputTA.append("\n");


            for (int row = 1; row < 25; row++)
            {
                System.out.print(row + "\t");
                outputTA.append(row + "\t");
                for (int column = 1; column < 25; column++)
                {
                    if (((row == y1) || (column == x1) || (row == y2) || (column == x2)) && ((row >= y1 && row <= y2) && (column >= x1 && column <= x2)) && outerChars.isSelected())
                    {
                        if (blue.isSelected()) {
                            outputTA.setForeground(Color.BLUE);
                        }
                        if (red.isSelected()) {
                            outputTA.setForeground(Color.RED);
                        }
                        if (green.isSelected()) {
                            outputTA.setForeground(Color.GREEN);
                        }
//                        if(outerChars.isSelected()) {
                            System.out.print(char1 + "\t");
                            outputTA.append(char1 + "\t");
//                        }

                    }

                    else if (((row >= y1 && row <= y2) && (column >= x1 && column <= x2)) && innerChars.isSelected())
                    {
                        if (blue.isSelected()) {
                            outputTA.setForeground(Color.BLUE);
                        }
                        if (red.isSelected()) {
                            outputTA.setForeground(Color.RED);
                        }
                        if (green.isSelected()) {
                            outputTA.setForeground(Color.GREEN);
                        }

                            System.out.print(char2 + "\t");
                            outputTA.append(char2 + "\t");


                    }

                    else
                    {
                        System.out.print(".\t");
                        outputTA.append(".\t");
                    }
                }

                System.out.print("\n");
                outputTA.append("\n");
            }
        }
}
