import java.awt.*;
import java.awt.event.*;
public class SchoolManagerUI {
    public static void main(String[] args) {
        Frame f = new Frame("School Manager");
        Button imp=new Button("Import Data");
        Button exp=new Button("Export Data");
        Button pur=new Button("Purge");
        Button help=new Button("Help");
        imp.setBounds(30,90,80,30);
        exp.setBounds(30,45,80,30);
        pur.setBounds(30,135,80,30);
        help.setBounds(30,400,80,30);
        Choice view = new Choice();

        view.setBounds(30,180,80,30);
        view.add("Select");
        view.add("Teacher");
        view.add("Student");
        view.add("Course");
        view.add("Section");

        // action listeners
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        f.add(imp);
        f.add(exp);
        f.add(view);
        f.add(pur);
        f.add(help);
        f.setBackground(new Color(235,225,225));
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}