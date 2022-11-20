//==================================
//Foundations of Computer Science
//Student: qingyan yang
//id: a1865304
//Semester: s01
//Year: 2022
//Practical Number: 04
//===================================
import javax.swing.*;
class Demo extends JFrame{
    //create objects
    JPanel jpl;
    JLabel jlb ;
    ImageIcon img;
    //default constructor
    public Demo(){
        //create components
        this.setTitle("Hanoi Tower");
        this.setSize(1000, 608);
        jpl = new JPanel();
        jlb = new JLabel();
        img = new ImageIcon("1moves.gif");
        jlb.setIcon(img);
        jpl.add(jlb);
        this.add(jpl);
        //X button can close window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //parametric constructor
    public Demo(String image) {
        this();
        img = new ImageIcon(image);
        jlb.setIcon(img);
        jpl.add(jlb);
        this.add(jpl);
        //X button can close window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}