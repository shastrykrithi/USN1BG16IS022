package cms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Collections; 

/**
 *
 * @author Neha
 */
public class display extends JFrame implements ActionListener
{
    public display() throws  FileNotFoundException, IOException
    {
        records []recs=new records[100];
        records []temp=new records[1];
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
       
       // String sql = "SELECT * FROM "+tab_name;

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
       // try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","organic","organic") ){;
         //   Statement stmt = con.createStatement();
           // ResultSet rs = stmt.executeQuery( sql );
       // {
         //   ResultSetMetaData md = rs.getMetaData();
           // int columns = md.getColumnCount();

            //  Get column names
            //for (int i = 1; i <= columns; i++)
            //{
                columnNames.add("customer id" );
                columnNames.add("name");
                columnNames.add("Adhar details");
                columnNames.add("Email");
                columnNames.add("phone");
                columnNames.add("Date");
                columnNames.add("Bill");
                columnNames.add("Address");
                         int columns=8;
               BufferedReader f3=new BufferedReader(new FileReader("G:\\6th  sem\\FS\\CyberManagement\\bpluss.txt")); 	//   3.open("bplus.txt",std::ios::in);
		String lineRead;
                int i=0;
                while((lineRead=f3.readLine())!=null)
		{
//String lineRead=f3.readLine();
//System.out.println(lineRead);
                //String [] tokens = lineRead.split("#");
		String [] t=lineRead.split("\\|");
                
		recs[i].keyf=t[0];//f3.getline(recs[i].keyf,5,'|');
		recs[i].name=t[1];//f3.getline(recs[i].name,50,'|');
		recs[i].adhar=t[2];//f3.getline(recs[i].fee,50,'|');
		recs[i].email_id=t[3];//f3.getline(recs[i].spec,50,'|');
		recs[i].phone=t[4];//f3.getline(recs[i].phone,50,'|');
                recs[i].dat=t[5];
                recs[i].bill=t[6];
		recs[i].addr=t[7];
                
                i++;
                
            //}

            //  Get row data
           // while (rs.next())
            //{
           /* int k=0;
            for(int j=0;j<i;j++){
                if((recs[j+1].keyf).compareTo(recs[j].keyf)<0){
                    temp[k]=recs[j];
                    recs[j]=recs[j+1];
                    recs[j+1]=temp[k];
                    
                    
                }
                
            }*/
                ArrayList row = new ArrayList(columns);
                

                for ( i = 1; i <= columns; i++)
                {
                    
                    row.add( recs[i].keyf );
                    row.add( recs[i].name );
                    row.add( recs[i].adhar);
                    row.add( recs[i].email_id );
                    row.add( recs[i].phone );
                    row.add( recs[i].dat );
                    row.add( recs[i].bill );
                     row.add( recs[i].addr);
                    
                }
                //Collections.sort(row);
                data.add( row );
                //Collections.sort(data);
                
    }
            
        

   
       // catch (SQLException e)
        //{
          //  System.out.println( e.getMessage() );
        //}

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for ( i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        //table.setGridColor(Color.DARK_GRAY);
        //table.setBackground(Color.cyan);
        //table.setLayout();

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        
        JButton Home=new JButton("Back");
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(Home);
        Home.addActionListener(this);
    }
        
    



        
        
       
        
        
    
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
            // TODO add your handling code here:
            new home().setVisible(true);
            new display().setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(display.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.setVisible(false);
    }                               

    public static void main(String[] args) throws SQLException
    {
       
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
        ew Homepage().setVisible(true);
       this.setVisible(false);//To change body of generated methods, choose Tools | Templates.
    }*/

    
}
