import javax.swing.*;
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


        String[] columns = new String[] {
                "Id", "Name", "Hourly Rate", "Part Time"
        };

        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
        };
        JTable table = new JTable(data, columns);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,50,450,400);
        f.add(sp);
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