import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class SchoolManagerUI {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connectionName = DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","password");

        Statement stmt = connectionName.createStatement();

        stmt.execute("CREATE TABLE IF NOT EXISTS teacher(\n" +
                "teacher_id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "first_name TEXT NOT NULL,\n" +
                "last_name TEXT NOT NULL,\n" +
                "PRIMARY KEY(teacher_id)\n" +
                ");\n");

        stmt.execute("CREATE TABLE IF NOT EXISTS student(\n" +
                "student_id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "first_name TEXT NOT NULL,\n" +
                "last_name TEXT NOT NULL,\n" +
                "section TEXT, \n" +
                "PRIMARY KEY(student_id)\n" +
                ");\n");

        stmt.execute("CREATE TABLE IF NOT EXISTS course(\n" +
                "course_id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "course_title TEXT NOT NULL,\n" +
                "type INTEGER NOT NULL, \n" +
                "PRIMARY KEY(course_id)\n" +
                ");\n");

        stmt.execute("CREATE TABLE IF NOT EXISTS section(\n" +
                "id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "course_id INTEGER NOT NULL,\n" +
                "teacher_id INTEGER NOT NULL, \n" +
                "PRIMARY KEY(id)\n" +
                ");\n");

        stmt.execute("SHOW TABLES;");

        stmt.execute("INSERT INTO teacher (first_name, last_name) VALUES ('Jim', 'Smith');\n");
        stmt.execute("INSERT INTO teacher (first_name, last_name) VALUES ('Phillip', 'Chin');\n");
        stmt.execute("INSERT INTO teacher (first_name, last_name) VALUES ('Jackson', 'Wang');\n");


        stmt.execute("INSERT INTO student (first_name, last_name) VALUES ('Bill', 'Smith');\n");
        stmt.execute("INSERT INTO student (first_name, last_name) VALUES ('Will', 'Chin');\n");
        stmt.execute("INSERT INTO student (first_name, last_name) VALUES ('Phil', 'Wang');\n");


        ResultSet rs = stmt.executeQuery("select * from teacher");

        while(rs!=null && rs.next())
            System.out.println(rs.getString(1) + " " + rs.getString(2));


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
                {1, "John", 40.0, true },
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
                System.out.println("Export Data");

            }
        });

        imp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Import Data");

            }
        });

        pur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Purge");

            }
        });

        view.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(view.getSelectedItem());
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
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowClosingDemo.windowClosing");
                System.exit(0);
            }
        });

        connectionName.close();
        connectionName.close();
    }
}