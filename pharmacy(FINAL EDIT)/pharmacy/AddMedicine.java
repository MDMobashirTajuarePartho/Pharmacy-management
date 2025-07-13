import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddMedicine extends JFrame implements ActionListener {
    
    private JTable table;
    private DefaultTableModel model; 
    private JScrollPane scroll;
    private Container c;
    private JLabel titleLabel,iLabel,mnLabel,cuLabel,cnLabel,tLabel;
    private JTextField iTf,mnTf,cuTf,cnTf,tTf;
    private JButton addButton,updateButton,deleteButton,clearButton,saveButton,cancelButton;
    private String[] columns = {"ID","Medicine Name","Cost","Company","Type"};
    private String[] rows = new String[6];
    
                               
    
    AddMedicine(){
        initComponents();
    }
    public void initComponents(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Aiub Pharmacy");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
       
        
        Font font = new Font("Arial",Font.BOLD,16);
        
        titleLabel = new JLabel("Aiub Pharmacy");
        titleLabel.setFont(font );
        titleLabel.setBounds(2,-50,250,150);
        c.add(titleLabel);
        
        iLabel = new JLabel("ID   ");
        iLabel.setBounds(10,80,140,30);
        iLabel.setFont(font);
        c.add(iLabel);
        
        
        iTf = new JTextField();
        iTf.setBounds(150,80,350,30);
        iTf.setFont(font);
        c.add(iTf);

        mnLabel = new JLabel("Medicine Name    ");
        mnLabel.setBounds (10,130,150,30);
        mnLabel.setFont(font);
        c.add(mnLabel);

        mnTf = new JTextField();
        mnTf.setBounds(150,130,350,30);
        mnTf.setFont(font);
        c.add(mnTf);

        cuLabel = new JLabel("Cost Per Unit    ");
        cuLabel.setBounds(10,180,150,30);
        cuLabel.setFont(font);
        c.add(cuLabel);
        
        cuTf = new JTextField();
        cuTf.setBounds(150,180,350,30);
        cuTf.setFont(font);
        c.add(cuTf);

        cnLabel = new JLabel("Company Name    ");
        cnLabel.setBounds(10,230,150,30);
        cnLabel.setFont(font);
        c.add(cnLabel);
        
        cnTf = new JTextField();
        cnTf.setBounds(150,230,350,30);
        cnTf.setFont(font);
        c.add(cnTf);
        
        tLabel = new JLabel("Type    ");
        tLabel.setBounds(10,280,150,30);
        tLabel.setFont(font);
        c.add(tLabel); 
                
        tTf = new JTextField();
        tTf.setBounds(150,280,350,30);
        tTf.setFont(font);
        c.add(tTf);

        addButton = new JButton("Add");
        addButton.setBounds(550,130,100,30);
        addButton.setFont(font);
        c.add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(550,280,100,30);
        clearButton.setFont(font);
        c.add(clearButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(550,230,100,30);
        deleteButton.setFont(font);
        c.add(deleteButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(550,180,100,30);
        updateButton.setFont(font);
        c.add(updateButton);

        saveButton = new JButton("Save Medicine");
        saveButton.setBounds(150,330,150,30);
        saveButton.setFont(font);
        c.add(saveButton);
        
        
        cancelButton = new JButton("Back");
        cancelButton.setBounds(350,330,150,30);
        cancelButton.setFont(font);
        cancelButton.addActionListener(this);
        c.add(cancelButton);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);

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
        scroll.setBounds(40,400,800,255);
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

        }
        catch (Exception ex) {
            return;
        }
        
        table.addMouseListener(new MouseAdapter(){
        
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
          
          });
    }
   
    public void actionPerformed(ActionEvent e){
        
         if (e.getSource()==addButton){

             String textField1 = iTf.getText().toLowerCase(); //ID
             String textField2 = mnTf.getText(); // Medicine Name
             String textField3 = cuTf.getText(); // Cost
             String textField4 = cnTf.getText(); //Company
             String textField5 = tTf.getText(); // Type

             if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                     || textField5.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                         JOptionPane.WARNING_MESSAGE);
             } else {

                 try {
                     File file = new File("Medicine.txt");
                     if (!file.exists()) {
                         file.createNewFile();
                     }
                     FileWriter fw = new FileWriter(file, true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);

                     pw.println("ID            : " + textField1);
                     pw.println("Medicine Name : " + textField2);
                     pw.println("Cost          : " + textField3);
                     pw.println("Company       : " + textField4);
                     pw.println("Type          : " + textField5);
                     pw.println("===============================================");
                     pw.close();

                 } catch (Exception ex) {
                     System.out.print(ex);
                 }

                 try {
                     File files = new File("names.txt");
                     if (!files.exists()) {
                         files.createNewFile();
                     }

                     FileWriter fw = new FileWriter(files, true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter pw = new PrintWriter(bw);

                     pw.println(textField2);
                     pw.close();
                 }

                 catch (Exception ex) {
                     System.out.print(ex);
                 }

                 JOptionPane.showMessageDialog(null, "Medicine has been added.");
                 setVisible(false);
                 MedicineReport frame = new MedicineReport();
                 frame.setVisible(true);
             }
         }  
        else if(e.getSource()==clearButton){
                
                iTf.setText("");
                mnTf.setText("");
                cuTf.setText("");
                cnTf.setText("");
                tTf.setText("");
                JOptionPane.showMessageDialog(null,"Clear Successful","Info",  JOptionPane.INFORMATION_MESSAGE);
                }
        else if (e.getSource()==deleteButton){
            
            int numberofRow = table.getSelectedRow();
            if(numberofRow>=0){
                String id = model.getValueAt(numberofRow, 0).toString();
                model.removeRow(numberofRow);
                JOptionPane.showMessageDialog(null,"Delete Successful","Info",  JOptionPane.INFORMATION_MESSAGE);

                try {
                    String file = "Medicine.txt";
                    String tempFile ="temp.txt";

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.startsWith("ID            : " + id)) {
                            writer.write(line + System.lineSeparator());
                        }
                    }

                    writer.close();
                    reader.close();

                    Files.delete(Paths.get(file));
                    Files.move(Paths.get(tempFile), Paths.get(file));
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"no row exist");
                
            
            }

        }
         else if(e.getSource()==updateButton){
             int numberofRow = table.getSelectedRow();

             String i = iTf.getText();
             String m_name = mnTf.getText();
             String c_unit = cuTf.getText();
             String c_name = cnTf.getText();
             String t = tTf.getText();

             model.setValueAt(i,numberofRow,0);
             model.setValueAt(m_name,numberofRow,1);
             model.setValueAt(c_unit,numberofRow,2);
             model.setValueAt(c_name,numberofRow,3);
             model.setValueAt(t,numberofRow,4);

             JOptionPane.showMessageDialog(null,"Update Successful","Info",  JOptionPane.INFORMATION_MESSAGE);
         }
         else if (e.getSource() == cancelButton) {
             dispose();
             Dashboard d = new Dashboard();
             d.setVisible(true);

         }


        this.saveButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null,"Save Successful");
          }
    
    
    });                
   
}    
}

