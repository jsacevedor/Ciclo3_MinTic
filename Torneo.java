
package torneo;

import java.sql.*;

/**
 *
 * @author karla
 */
public class Torneo {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/torneo";
        String username = "root";
        String password = "1143156420";
        
        try{
        Connection conn = DriverManager.getConnection(jdbcUrl,username,password);
        if (conn != null){
            System.out.println("Conexión exitosa");
            ModificarEstadio(conn);
            ModificarPartido(conn);
            EliminarJugador(conn);
            Consulta1(conn);
            Consulta2(conn);
            Consulta3(conn);
            Consulta4(conn);
            Consulta5(conn);
            Consulta6(conn);
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void ModificarEstadio(Connection conn) throws SQLException {

        String sql = "UPDATE Equipo SET Nombre_estadio='Wanda' where Codigo=3";

        PreparedStatement stm = conn.prepareStatement(sql);
        
        int filasModificadas = stm.executeUpdate();
            
        if(filasModificadas >0){
        System.out.println("Actualización exitosa");
        }
    }
    
        
        
    public static void ModificarPartido(Connection conn) throws SQLException {
        
        String sql = "UPDATE Partido SET Fecha='2021-04-01 21:00:00' where Codigo=5";

        PreparedStatement stm = conn.prepareStatement(sql);
        
        int filasModificadas = stm.executeUpdate();
            
        if(filasModificadas >0){
        System.out.println("Actualización exitosa");
        }
    }
    
    public static void EliminarJugador(Connection conn) throws SQLException {
        
        String sql = "DELETE FROM Jugador WHERE Persona_Identificacion='0009'";

        PreparedStatement stm = conn.prepareStatement(sql);
        
        int filasModificadas = stm.executeUpdate();
            
        if(filasModificadas >0){
        System.out.println("Actualización exitosa");
        }
    }
    public static void Consulta1(Connection conn) throws SQLException {
        String sql = "SELECT Nombre,Nombre_Estadio,Anio_Fundacion FROM Equipo";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println("Equipos \n" + "***********************************");
        while(rs.next()){
            String nombre = rs.getString(1);
            String nombreEstadio = rs.getString(2);
            int anioFundacion = rs.getInt(3);
            System.out.println("Nombre: " + nombre + "\n" +
                                "Nombre Estadio: " + nombreEstadio + "\n" +
                                "Año fundación: " + anioFundacion + "\n" + 
                                "************************************");
        }
    }
    public static void Consulta2(Connection conn) throws SQLException {
        String sql = "SELECT b.Nombres,b.Fecha_Nacimiento,a.Posicion FROM jugador a INNER JOIN persona b ON a.Persona_Identificacion = b.Identificacion WHERE Codigo_Equipo=3";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println("Jugadores Atlético de Madrid \n" + "***********************************");
        while(rs.next()){
            String nombres = rs.getString(1);
            Date fechaNacimiento = rs.getDate(2);
            String posicion = rs.getString(3);
            System.out.println("Nombres: " + nombres + "\n" +
                                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                                "Posición: " + posicion + "\n" + 
                                "************************************");
        }   
    }

    public static void Consulta3(Connection conn) throws SQLException {
        String sql = "SELECT Codigo,Partido_Codigo,Minuto,Descripcion FROM Gol WHERE Minuto >70 ORDER BY Minuto DESC";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println("Goles luego del minuto 70 \n" + "***********************************");
        while(rs.next()){
            int codigo = rs.getInt(1);
            int partidoCodigo = rs.getInt(2);
            int minuto = rs.getInt(3);
            String descripcion = rs.getString(4);
            System.out.println("Codigo gol: " + codigo + "\n" +
                                "Codigo Partido: " + partidoCodigo + "\n" +
                                "Minuto: " + minuto + "\n" + 
                                "Descripción: " + descripcion + "\n" +
                                "************************************");
        } 
    }

    public static void Consulta4(Connection conn) throws SQLException {
        String sql = "SELECT c.Nombres,c.Apellidos\n" +
        "FROM GOL a\n" +
        "Inner Join jugador b on a.Persona_Identificacion = b.Persona_Identificacion\n" +
        "Inner Join persona c on b.Persona_Identificacion = c.Identificacion\n" +
        "WHERE a.Partido_Codigo=3 ORDER BY Minuto ASC";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println("Goles en el partido 3 \n" + "***********************************");
        while(rs.next()){
            String nombres = rs.getString(1);
            String apellidos = rs.getString(2);
            System.out.println("Nombres: " + nombres + "\n" +
                                "Apellidos: " + apellidos + "\n" +
                                "************************************");
        } 
    }

    public static void Consulta5(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(Partido_Codigo)\n" +
        "FROM Partidos_equipo\n" +
        "WHERE Equipo_Codigo=3 AND Es_Local=0";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            int partidos = rs.getInt(1);
            System.out.println("Partidos de Visitante Atlético de Madrid: " + partidos + "\n" +
                                "************************************");
        } 
    }

    public static void Consulta6(Connection conn) throws SQLException {
        String sql = "SELECT Goles_Local,Goles_Visitante\n" +
        "FROM partido\n" +
        "WHERE Fecha<'2021-03-27'\n" +
        "ORDER BY Fecha DESC";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        System.out.println("Goles de local y visitante antes del 27/mar/2021 \n" + "***********************************");
        while(rs.next()){
            int golesLocal = rs.getInt(1);
            int golesVisitante = rs.getInt(1);
            System.out.println("Goles Local: " + golesLocal + "\n" +
                                "Goles Visitante: " + golesVisitante + "\n" + 
                                "************************************");
        }
    }    
    
}
