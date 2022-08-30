/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myJDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
/**
 *
 * @author kavila
 */
public class MyJDBC {
    
    
         private String urlbase;
         private String puerto;
         private String dataBaseName;
         private String Url;
         private String userName;
         private String userPassword;
         private Connection connection;
         private Statement statement;
         private ResultSet resultSet;
         
public MyJDBC(String dataBaseName, String userName, String userPassword){
    urlbase = "jdbc:mysql://localhost:";
    puerto = "3306";
    this.dataBaseName = "/" + dataBaseName;
    Url = urlbase + puerto + this.dataBaseName;
    this.userName = userName;
    this.userPassword = userPassword;
    
}
public boolean ConnectionMyDB(){
    boolean salida=false;
    try{
        connection = DriverManager.getConnection(Url,userName,userPassword);
        statement = connection.createStatement();
        salida = true;
    }catch (Exception e){e.printStackTrace();}
      return salida;
    }
public boolean CREATE(String myQuery){
    boolean salida = true;
    try{
        statement.executeUpdate(myQuery);
    }catch (Exception e){
        e.printStackTrace();
        salida = false;
    }
    return salida;
}   

public void READ(String myQuery, String[] listaCabeceras, int cantidadCabeceras){
        if (cantidadCabeceras == 1){
        try{
            resultSet = statement.executeQuery(myQuery);
            while(resultSet.next()){
                System.out.println(resultSet.getString(listaCabeceras[0]));
            }
            
        }catch (Exception e){e.printStackTrace();}
        }else if(cantidadCabeceras == 2){
        try{
            resultSet = statement.executeQuery(myQuery);
            while(resultSet.next()){
                System.out.print(resultSet.getString(listaCabeceras[0])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[1]));
            }
            
        }catch (Exception e){e.printStackTrace();}
    }else if(cantidadCabeceras == 3){
     try{
            resultSet = statement.executeQuery(myQuery);
            while(resultSet.next()){
                System.out.print(resultSet.getString(listaCabeceras[0])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[1])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[2]));
            }
            
        }catch (Exception e){e.printStackTrace();}
    }else if(cantidadCabeceras == 4){
     try{
            resultSet = statement.executeQuery(myQuery);
            while(resultSet.next()){
                System.out.print(resultSet.getString(listaCabeceras[0])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[1])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[2])+"\t");
                System.out.println(resultSet.getString(listaCabeceras[3]));
            }
            
        }catch (Exception e){e.printStackTrace();}
     
}
}
   public boolean UPDATE(String myQuery){
       return CREATE(myQuery);
       
   }
   public boolean DELETE(String myQuery){
       return CREATE(myQuery);
   }
}

