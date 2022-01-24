
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raju
 */
public class DataB2 {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
          int roll,marks,ch,i;
            do{
                Scanner sc=new Scanner(System.in);
                System.out.println("press 1\tFor Select all data from Table\n"+"press 2\tFor Select all data from Table Order by Marks in Ascending Order\n"+"press 3\tFor Select all data from Table Order by Roll No. in Descending Order");
                System.out.println("press 4\tFor Find Maximum Marks Of Student");
                System.out.println("press 5\tFor Find Minimum Marks Of Student");
                System.out.println("press 6\tFor Calculate Average Marks Of Student");
                System.out.println("Press 7\tfor Select Second Largest Marks Of Student");
                System.out.println("press 8\tFor Exit");     
                ch =sc.nextInt(); 
               if(ch<=8 && ch>=1)
                   { 
                        if(ch==1){

                                    String sql="select * from student";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                    while(rs.next())
                                        {
                                            System.out.print("\t\t"+rs.getString(1));
                                            System.out.print("\t\t"+rs.getString(2));
                                            System.out.println("\t\t"+rs.getString(3));
  
                                        }    
                               }
                        else if(ch==2){

                                    String sql="select * from student order by marks";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                    while(rs.next())
                                        {
                                            System.out.print("\t\t"+rs.getString(1));
                                            System.out.print("\t\t"+rs.getString(2));
                                            System.out.println("\t\t"+rs.getString(3));
  
                                        }    
                               }
                        else if(ch==3){

                                    String sql="select * from student order by roll desc";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                    while(rs.next())
                                        {
                                            System.out.print("\t\t"+rs.getString(1));
                                            System.out.print("\t\t"+rs.getString(2));
                                            System.out.println("\t\t"+rs.getString(3));
  
                                        }    
                               }
                         else if(ch==4){

                                    String sql="select max(marks) as 'Maximum Marks Of Student' from student ";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1));
                                    while(rs.next())
                                        {
                                            System.out.println("\t\t"+rs.getString(1));
//                                            System.out.print("\t\t"+rs.getString(2));
//                                            System.out.println("\t\t"+rs.getString(3));
//  
                                        }    
                               }
                        else if(ch==5){

                                    String sql="select  min(marks) as 'Minimum Marks Of Student' from student ";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1));
                                    while(rs.next())
                                        {
                                            System.out.println("\t\t"+rs.getString(1));
//                                            System.out.print("\t\t"+rs.getString(2));
//                                            System.out.println("\t\t"+rs.getString(3));
//  
                                        }    
                               }
                        else if(ch==6){

                                    String sql="select  avg(marks) as 'Abverage Marks Of Student' from student ";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1));
                                    while(rs.next())
                                        {
                                            System.out.println("\t\t"+rs.getString(1));
//                                            System.out.print("\t\t"+rs.getString(2));
//                                            System.out.println("\t\t"+rs.getString(3));
//  
                                        }    
                               }
                        else if(ch==7){

                                    String sql="select * from student  where marks=(select max(marks) from student where marks !=(select max(marks) from student))";
                                    Statement st = con.createStatement();
                                    ResultSet rs = st.executeQuery(sql);
                                    ResultSetMetaData rsdm = rs.getMetaData();
                                    System.out.println("\t\t"+rsdm.getColumnName(1)+"\t\t"+rsdm.getColumnName(2)+"\t\t"+rsdm.getColumnName(3));
                                    while(rs.next())
                                        {
                                            System.out.print("\t\t"+rs.getString(1));
                                            System.out.print("\t\t"+rs.getString(2));
                                            System.out.println("\t\t"+rs.getString(3));
//  
                                        }    
                               }
                 
                   }else{ System.out.println("Plese Enter Right Choise Like -> 1,2,3,4,5,6,7,8\n"); }    
            }while(ch!=8);
    
        } catch (ClassNotFoundException ex) {
            System.out.println(""+ex);
//            Logger.getLogger(DataB2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(""+e);
//            Logger.getLogger(DataB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
