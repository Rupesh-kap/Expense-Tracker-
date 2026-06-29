import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pro {
    static void expense() {
        JFrame f = new JFrame("EXPENSE TRACKER");
        f.setSize(500, 700);
        f.setLayout(null);
        ImageIcon img=new ImageIcon("ronaldo.jpg");
        f.setIconImage(img.getImage());

        ImageIcon bgImg = new ImageIcon("img.png"); 
        JLabel bgLabel = new JLabel(bgImg);
        bgLabel.setBounds(0, 0, 500, 700);
        f.setContentPane(bgLabel); 
        bgLabel.setLayout(null);   

        JLabel l1 = new JLabel("EXPENSE TRACKER", JLabel.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.setBounds(100, 10, 200, 30);

        JLabel l2 = new JLabel("Description:");
        l2.setBounds(30, 60, 70, 30);
        JTextField t1 = new JTextField();
        t1.setBounds(110, 65, 150, 20);

        JLabel l3 = new JLabel("Amount:");
        l3.setBounds(30, 100, 70, 30);
        JTextField t2 = new JTextField();
        t2.setBounds(110, 105, 150, 20);

        JLabel l4 = new JLabel("Category:");
        l4.setBounds(30, 145, 70, 30);
        String[] cat = {"None","Housing", "Food", "Transport", "HealthCare", "Saving"};
        JComboBox<String> cb = new JComboBox<>(cat);
        cb.setBounds(110, 145, 150, 25);
        cb.setSelectedIndex(0);

        JLabel l5 = new JLabel("DATE(D-M-Y):");
        l5.setBounds(20, 195, 90, 30);
        JTextField t5 = new JTextField();
        t5.setBounds(110, 200, 150, 20);

        JButton add = new JButton("ADD_EXP");
        add.setBounds(90, 230, 110, 30);

        // Creating table
        String[] col = {"Date","Descrciption","Category","Amount"};
        DefaultTableModel model = new DefaultTableModel(col,0);
        JTable tbl = new JTable(model);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(70,270,300,250);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String data1 = t5.getText();
                String data2 = t1.getText();
                String data3 = (String)cb.getSelectedItem();
                String data4 = t2.getText();
                if (data1.isEmpty() || data2.isEmpty() || data3.equals("None") || data4.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Please enter valid data for track");
                       return; 
}

                model.addRow(new Object[]{data1,data2,data3,data4});
                // clear input fields after adding
                t5.setText("");
                t1.setText("");
                t2.setText("");
                cb.setSelectedIndex(0);
            }
        });

        JButton del = new JButton("Delete");
        del.setBounds(220,230,110,30);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int row = tbl.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog(null,"Select valid row");
                }
                else{
                    model.removeRow(row);
                }
            }
        });

        JButton tot = new JButton("total Expense");
        tot.setBounds(320, 600, 150, 30);
        tot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int row = tbl.getRowCount();
                int sum = 0;
                for(int i=0; i<row; i++){
                    Object val = tbl.getValueAt(i,3);
                    sum = sum + Integer.parseInt(val.toString());
                }
                JOptionPane.showMessageDialog(null,"total expence you did is:- "+sum);
            }
        });

        bgLabel.add(l1);
        bgLabel.add(l2);
        bgLabel.add(t1);
        bgLabel.add(l3);
        bgLabel.add(t2);
        bgLabel.add(l4);
        bgLabel.add(cb);
        bgLabel.add(l5);
        bgLabel.add(t5);
        bgLabel.add(add);
        bgLabel.add(scroll);
        bgLabel.add(del);
        bgLabel.add(tot);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        expense();
    }
}
