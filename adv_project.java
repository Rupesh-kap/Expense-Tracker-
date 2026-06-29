import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class adv_project{
    static void expense() {
        JFrame f = new JFrame("EXPENSE TRACKER");
        f.setSize(600, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        ImageIcon img=new ImageIcon("ronaldo.jpg");
        f.setIconImage(img.getImage());
        //Background Image   
        ImageIcon bgImg = new ImageIcon("img.png");
        JLabel bgLabel = new JLabel(bgImg);
        f.setContentPane(bgLabel);
        bgLabel.setLayout(new BorderLayout());
        //Top Title   
        JLabel l1 = new JLabel("EXPENSE TRACKER", JLabel.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(new Color(145,44,84)); // text visible on bg
        bgLabel.add(l1, BorderLayout.NORTH);
        // Input Panel   
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false); // make background transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel l2 = new JLabel("Description:");
        JTextField t1 = new JTextField(15);

        JLabel l3 = new JLabel("Amount:");
        JTextField t2 = new JTextField(15);

        JLabel l4 = new JLabel("Category:");
        String[] cat = {"None","Housing","Food","Transport","HealthCare","Saving"};
        JComboBox<String> cb = new JComboBox<>(cat);

        JLabel l5 = new JLabel("DATE(D-M-Y):");
        JTextField t5 = new JTextField(15);

        JButton add = new JButton("ADD_EXP");
        JButton del = new JButton("Delete");
        JButton tot = new JButton("Total Expense");

        // Add components in grid   
        gbc.gridx = 0; gbc.gridy = 0; inputPanel.add(l2, gbc);
        gbc.gridx = 1; gbc.gridy = 0; inputPanel.add(t1, gbc);

        gbc.gridx = 0; gbc.gridy = 1; inputPanel.add(l3, gbc);
        gbc.gridx = 1; gbc.gridy = 1; inputPanel.add(t2, gbc);

        gbc.gridx = 0; gbc.gridy = 2; inputPanel.add(l4, gbc);
        gbc.gridx = 1; gbc.gridy = 2; inputPanel.add(cb, gbc);

        gbc.gridx = 0; gbc.gridy = 3; inputPanel.add(l5, gbc);
        gbc.gridx = 1; gbc.gridy = 3; inputPanel.add(t5, gbc);

        gbc.gridx = 0; gbc.gridy = 4; inputPanel.add(add, gbc);
        gbc.gridx = 1; gbc.gridy = 4; inputPanel.add(del, gbc);

        bgLabel.add(inputPanel, BorderLayout.WEST);

        //Table Panel   
        String[] col = {"Date","Descrciption","Category","Amount"};
        DefaultTableModel model = new DefaultTableModel(col,0);
        JTable tbl = new JTable(model);
        JScrollPane scroll = new JScrollPane(tbl);
        bgLabel.add(scroll, BorderLayout.CENTER);

        //Bottom Panel   
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.add(tot);
        bgLabel.add(bottomPanel, BorderLayout.SOUTH);

        //Action Listeners   
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
                t5.setText(""); t1.setText(""); t2.setText("");
                cb.setSelectedIndex(0);
            }
        });

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

        tot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int row = tbl.getRowCount();
                int sum = 0;
                for(int i=0; i<row; i++){
                    Object val = tbl.getValueAt(i,3);
                    sum += Integer.parseInt(val.toString());
                }
                JOptionPane.showMessageDialog(null,"Total expense: " + sum);
            }
        });

        f.setVisible(true);
    }

    public static void main(String[] args) {
        expense();
    }
}
