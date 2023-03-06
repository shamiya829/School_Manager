import java.awt.*;
import java.awt.event.*;
public class SchoolManagerUI {
    public static void main(String[] args) {
        Frame f = new Frame("Button Example");
        Button imp=new Button("Import Data");
        Button exp=new Button("Export Data");
        imp.setBounds(30,90,80,30);
        exp.setBounds(30,45,80,30);
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        f.add(imp);

        f.add(exp);
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}