import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddSalesReport extends JFrame{
	Container c;
       
    JLabel label;
    JPanel panel;
    JButton button;
	 Color c1=new Color(211,211,211);
	Font font = new Font("cambria", Font.PLAIN ,25);
        Font ff= new Font("Arial",Font.BOLD,16);
	JTable table;
	JScrollPane scroll;
	
	String [] cols={"ID","Customer Name ", "Medicine Name","Quantity","Date","Total"};
	String [] [] rows={{"201","Salam","Acitretin","3","02.01.22","100"},
		          {"202","Kalam","Acarbose","5","02.02.22","400"}, 
		          {"203","Rakin","Azathioprine","1","02.02.22","200"},   
		          {"204","Salman","Benzocaine","4","06.01.22","370"},
                          {"205","Farrukh","Busulfan","6","09.01.22","285"},
                          {"206","Ramisa","Cabergoine","2","15.01.22","600"},
                          {"207","Rafiq","Bumetanide","7","21.01.22","345"},
		          {"208","Samia","Calcitriol","1","26.01.22","300"},
                          {"209","Samiha","Carboplatin","8","28.01.22","256"},
                          {"210","Jubaida","Cefdinir","5","30.01.22","325"},
                          {"211","Jawad","Deferiprone","4","01.02.22","415"},
                          {"212","Mahima","Desonide","7","05.02.22","115"},
                          {"213","Raya","Ebastine","1","07.02.22","235"},
                          {"214","Jim","Febuxostat","5","08.02.22","50"},
                          {"215","Tanvir","Gliclazide","9","10.02.22","450"},
                          {"216","Omeo","Halcinonide","6","11.01.22","365"},
                          {"217","Eftekhar","Ibrutinib","5","15.02.22","55"},
                          {"218","Nodi","Ketamine","8","20.02.22","1000"},
                          {"219","Farzil","Lacidipine","4","26.02.22","612"},
                          {"220","Maimuna","Mannitol","5","01.03.22","733"},
                          {"221","Zaima","Magnesium Salfet","6","06.03.22","467"},
                          {"222","Sumon","Natamycin","5","09.03.22","990"},
                          {"223","Raju","Orlistat","8","12.03.22","873"},
                          {"224","Rahat","Paracetamol","7","16.03.22","50"},
                          {"225","Sumaiya","Rivavirin","5","20.03.22","545"},
                          {"226","Azmain","Salbutamol","8","25.03.22","678"},
                          {"227","Nurul","Tibolone","5","27.04.22","666"},
                          {"228","Namira","Zinc Oxide","6","15.05.22","516"},
                          {"229","Maisha","Adenosine","1","24.06.22","290"},
                          {"230","Faija","Aspirin","2","26.07.22","190"},
                          };
	
	AddSalesReport(){
		
		initComponents();
		

	}
	public void initComponents()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,300,750,500);
                this.setLocationRelativeTo(null);
		this.setTitle("Add Sales Report");
                
                this.panel = new JPanel(null);
    panel.setBounds(100, 100, 600, 400);
    panel.setBackground(c1);
		 ff=new Font("Arial",Font.BOLD,16);
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(c1);
            
               this.setVisible(true);
		
		label=new JLabel("ALL SALES REPORT");
		label.setBounds(250,30,400,50);
		label.setFont(font);
		c.add(label);
		
		table=new JTable(rows,cols);
		
		scroll=new JScrollPane(table);
		scroll.setBounds(50,80,650,280);
		c.add(scroll);
                
                              this.button = new JButton("Close");
            
              this.button.setBounds(500, 300, 100, 30);
   
    this.panel.add(this.button);
   
     
    this.add(this.panel);
    
     this.button.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
               setVisible(false);
          new Dashboard();
      
          }
   
    });
   		
	}
	
}