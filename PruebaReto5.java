package reto5;
//import java.sql.Connecton;
import java.util.Scanner;
import java.sql.*;


public class Reto5 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    } 
    public static void menu(){
        try {
            System.out.println("*************************\n" +
                    "**** RETO 5 Julian Felipe Avila Pedraza Grupo 35 ****\n" +
                    "*********************\n" +
                    "1. Crear Tablas.\n"+
                    "---------------------------------------------\n" +
                    "2. Ingresar datos Tabla Persona.\n" +
                    "3. Ingresar datos Tabla Equipo.\n" +
                    "4. Ingresar datos Tabla Jugador.\n" +
                    "5. Ingresar datos Tabla Director Tecnico.\n" +
                    "6. Ingresar datos Tabla Partido.\n" +
                    "7. Ingresar datos Tabla Partidos Equipo.\n" +
                    "8. Ingresar datos Tabla Partidos Gol.\n" +
                    "---------------------------------------------\n" +
                    "9. Modificar el nombre del estadio.\n" +
                    "10. Modificar Fecha del partido.\n" +
                    "11. Eliminar jugador.\n" +
                    "---------------------------------------------\n" +
                    "12. Mostrar el nombre, el nombre del estadio y el año de fundación de los equipos.\n" +
                    "13. Mostrar el nombre, la fecha de nacimiento y la posición de los jugadores del Atlético de Madrid.\n" +
                    "14. Mostrar el código de los goles, el código del partido, el minuto y la descripción que se realizaron después del minuto 70 ordenados descendentemente por minuto.\n" +
                    "15. Mostrar los nombres y apellidos de los jugadores que hicieron los goles en el partido con código 3 ordenados por minuto de gol ascendentemente.\n" +
                    "16. Mostrar cuantos partidos oficio de visitante el Atlético de Madrid.\n"+
                    "17. Mostrar los goles de local y visitante de los partidos efectuados antes del 27 de marzo ordenados por fecha descendentemente.\n" +
                    "---------------------------------------------\n" +
                    "Ingrese otro numero para salir. \n" +
                    "---------------------------------------------\n"
            );    
        System.out.print(">> ");
        String input = sc.nextLine();
        byte opcion = Byte.parseByte(input); 
        
        switch (opcion){
            case 1:
                Consultas.crearTablas();
                break;
            case 2:
                Persona.ingresarPersona();
                break;
            case 3:
                Equipo.ingresarEquipo();
                break;
            case 4:
                Jugador.ingresarJugador();
                break;
            case 5:
                Director_tecnico.ingresarDirector_tecnico();
                break;
            case 6:
                Partido.ingresarPartido();
                break;
            case 7:
                Partidos_equipo.ingresarPartidos_equipo();
                break;
            case 8:
                Gol.ingresarGol();
                break;
            case 9:
                Consultas.modificaEquipo();
                break;
            case 10:
                Consultas.modificaPartido();
                break; 
            case 11:
                Consultas.modificaJugador();
                break;  
            case 12:
                Consultas.consultaConsulA();
                break;    
            case 13:
                Consultas.consultaConsulB();
                break;
            case 14:
                Consultas.consultaConsulC();
                break;
            case 15:
                Consultas.consultaConsulD();
                break; 
            case 16:
                Consultas.consultaConsulE();
                break;   
            case 17:
                Consultas.consultaConsulF();
                break;
            default:
                System.out.println("Hasta Pronto...");
            }    
        } 
        catch (Exception e){
           System.out.println("Hasta Pronto..."); 
        }
    }
    
    public static Connection conectar(){
        String jdbcUr1 ="jdbc:mysql://localhost:3307/reto4";
        String username = "root";
        String password = "123456Fp";
        
        try {
        Connection conn = DriverManager.getConnection(jdbcUr1, username, password);
        if (conn != null)
        {
            System.out.println("Conexion exitosa");
            System.out.println("****************");
        }    
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}  

