import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MedicineReport extends JFrame implements ActionListener {

    private Container c;
    private JLabel titleLabel, label1;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JPanel panel;
    private Font font = new Font("Arial", Font.BOLD, 16);
    ;
    private JButton closeButton;

    private String[] columns = {"ID", "Medicine Name", "Cost", "Company", "Type"};
    private String[] rows = new String[6];

    MedicineReport() {

        this.initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null);
        this.setTitle("MedicineReport : Medical Shop Management System");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        titleLabel = new JLabel(" All Medicine Report");
        titleLabel.setFont(font);
        titleLabel.setBounds(2, -50, 250, 150);
        c.add(titleLabel);

        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.setModel(model);
        table.setFont(font);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);

        scroll = new JScrollPane(table);
        scroll.setBounds(50, 80, 800, 450);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = "Medicine.txt";
        String temp = "temp.txt";

        // To input data in the table
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 16);
                if (x.equals("ID            : ")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(16); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(16); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(16); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(16); // Security Question
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(16); // Answer
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }

        closeButton = new JButton("Close");
        closeButton.setBounds(630, 580, 100, 30);
        closeButton.setFont(font);
        closeButton.addActionListener(this);
        c.add(closeButton);


        /*table.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent me){

                int numberofRow = table.getSelectedRow();

                String i = model.getValueAt(numberofRow,0).toString();
                String m_name = model.getValueAt(numberofRow,1).toString();
                String c_unit = model.getValueAt(numberofRow,2).toString();
                String c_name= model.getValueAt(numberofRow,3).toString();
                String t = model.getValueAt(numberofRow,4).toString();


                iTf.setText(i);
                mnTf.setText(m_name);
                cuTf.setText(c_unit);
                cnTf.setText(c_name);
                tTf.setText(t);

            }

        });*/
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == closeButton) {

            setVisible(false);
            new Dashboard();
        }

    }
}
  /*public void  initcomponents(){
      
    this.panel = new JPanel(null);
    panel.setBounds(100, 100, 750, 450);
    panel.setBackground(Color.LIGHT_GRAY);
    font=new Font("Arial",Font.BOLD,20);
      
      c = this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
      label=new JLabel(" All Medicine Report");
      label.setBounds(100, 50, 400, 500);
      this.setBounds(100,100,900,550);
      this.setTitle("MedicineReport : Medical Shop Management System");
      label.setBounds(250,20,200,50);
      this.add(label);
      label.setFont(font);


         table = new JTable(rows,cols);
         scroll = new JScrollPane(table);
         scroll.setBounds(50,80,800,350);
         c.add(scroll);
         table.setSelectionBackground(Color.green);


         this.button = new JButton("Close");
         this.button.setBounds(630, 350, 100, 30);
         button.setFont(font);
         this.panel.add(this.button);
   
     
         this.add(this.panel);
       
    
     this.add(this.panel);
     this.button.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
          new Dashboard();
      
          }
    
    
    });
  
   }*/



      
    


