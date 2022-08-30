/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import myJDBC.MyJDBC;
/**
 *
 * @author kavila
 */
public class App {
    public static MyJDBC myJDBC;
    
     public static void main(String[]args){
         myJDBC = new MyJDBC("reto5","root","karen_182");
         System.out.println(myJDBC.ConnectionMyDB());
         //Create();
         Read();
         Update();
         Read();
         Delete();
         Read();
         
}
public static void Create(){
   /* Llenando la tabla persona*/
    
    myJDBC.CREATE("INSERT INTO persona VALUES ('123456','Ronald','Koeman','1963-03-21');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('123457','Carlo','Ancelotti','1959-06-10');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('123458','Diego','Simeone','1970-04-28');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('123459','José','Bordalás','1964-03-05');");   
    myJDBC.CREATE("INSERT INTO persona VALUES ('0000','Marc-Andre','ter Stegen','1992-04-30');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0001','Gerard','Piqué','1987-02-02');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0002','Sergio','Busquets','1988-07-16');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0003','Antoine','Griezmann','1991-03-21');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0004','Thibaut','Courtois','1992-05-11');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0005','Dani','Carvajal','1992-01-11');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0006','Toni','Kroos','1990-01-04');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0007','Karim','Benzema','1987-12-19');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0008','Jan','Oblak','1993-01-07');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0009','Santiago','Arias','1992-01-13');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0010','Koke','Resurrección','1992-01-08');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0011','Luis','Suarez','1987-01-24');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0012','Jasper','Cillesen','1989-04-22');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0013','Gabriel','Paulista','1990-11-26');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0014','Carlos','Soler','1997-01-02');");
    myJDBC.CREATE("INSERT INTO persona VALUES ('0015','Maximiliano','Gómez','1996-08-14');");
    
    /* Llenando la tabla equipo*/
    myJDBC.CREATE("INSERT INTO equipo VALUES (1,'Barcelona','Barcelona','Camp Nou','1899');");
    myJDBC.CREATE("INSERT INTO equipo VALUES (2,'Real Madrid','Madrid','Santiago Bernabeu','1902');");
    myJDBC.CREATE("INSERT INTO equipo VALUES (3,'Atlético de Madrid','Madrid','Wanda','1903');");
    myJDBC.CREATE("INSERT INTO equipo VALUES (4,'Valencia','Valencia','Mestalla','1919');");
    
    /* Llenando la tabla jugador*/
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0000','Portero',1);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0001','Defensa',1);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0002','Mediocampista',1);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0003','Delantero',1);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0004','Portero',2);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0005','Defensa',2);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0006','Mediocampista',2);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0007','Delantero',2);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0008','Portero',3);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0009','Defensa',3);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0010','Mediocampista',3);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0011','Delantero',3);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0012','Portero',4);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0013','Defensa',4);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0014','Mediocampista',4);");
    myJDBC.CREATE("INSERT INTO jugador VALUES ('0015','Delantero',4);");
    
    /* Llenando la tabla director_tecnico*/
    myJDBC.CREATE("INSERT INTO director_tecnico VALUES ('123456',8,2020);");
    myJDBC.CREATE("INSERT INTO director_tecnico VALUES ('123457',6,2021);");
    myJDBC.CREATE("INSERT INTO director_tecnico VALUES ('123458',1,2012);");
    myJDBC.CREATE("INSERT INTO director_tecnico VALUES ('123459',6,2021);");
    
    /* Llenando la tabla partido*/
    myJDBC.CREATE("INSERT INTO partido VALUES (0,1,2,'2021-03-25 20:00:00');");
    myJDBC.CREATE("INSERT INTO partido VALUES (1,2,0,'2021-03-26 20:00:00');");
    myJDBC.CREATE("INSERT INTO partido VALUES (2,1,0,'2021-03-27 18:00:00');");
    myJDBC.CREATE("INSERT INTO partido VALUES (3,2,1,'2021-03-28 20:00:00');");
    myJDBC.CREATE("INSERT INTO partido VALUES (4,0,0,'2021-03-26 16:00:00');");
    
    /* Llenando la tabla partidos_equipo*/
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (0,1,1);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (0,2,0);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (1,3,1);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (1,4,0);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (2,4,1);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (2,2,0);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (3,1,1);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (3,3,0);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (4,2,1);");
    myJDBC.CREATE("INSERT INTO partidos_equipo VALUES (4,3,0);");
    
    /* Llenando la tabla gol*/
    myJDBC.CREATE("INSERT INTO gol VALUES (1,15,'Penalti',0,'0003');");
    myJDBC.CREATE("INSERT INTO gol VALUES (2,20,'Tiro libre',0,'0007');");
    myJDBC.CREATE("INSERT INTO gol VALUES (3,85,'Cabeza',0,'0006');");
    myJDBC.CREATE("INSERT INTO gol VALUES (1,70,'Remate larga distancia',1,'0011');");
    myJDBC.CREATE("INSERT INTO gol VALUES (2,84,'Penalti',1,'0011');");
    myJDBC.CREATE("INSERT INTO gol VALUES (1,50,'Tiro libre',2,'0015');");
    myJDBC.CREATE("INSERT INTO gol VALUES (1,43,'Penalti',3,'0010');");
    myJDBC.CREATE("INSERT INTO gol VALUES (2,55,'Remate larga distancia',3,'0002');");
    myJDBC.CREATE("INSERT INTO gol VALUES (3,81,'Tiro libre',3,'0003');");  

}
public static void Read(){
    String query;
    String []listaCaberas;
    /*PRIMER CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t PRIMER CONSULTA");
    query = "SELECT nombre,nombre_estadio,anio_fundacion FROM equipo;";
    listaCaberas = new String[]{"nombre","nombre_estadio","anio_fundacion"};
    myJDBC.READ(query,listaCaberas,3);
    
    /*SEGUNDA CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t SEGUNDA CONSULTA");
    query = "SELECT nombres, fecha_nacimiento, posicion FROM jugador LEFT JOIN persona on persona.identificacion = jugador.identificacion WHERE codigo_equipo = 3;";
    listaCaberas = new String[]{"nombres", "fecha_nacimiento", "posicion"};
    myJDBC.READ(query,listaCaberas,3);
    
    /*TERCER CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t TERCER CONSULTA");
    query = "SELECT codigo, codigo_partido, minuto, descripcion FROM gol WHERE minuto > 70 ORDER BY minuto DESC;";
    listaCaberas = new String[]{"codigo", "codigo_partido", "minuto", "descripcion"};
    myJDBC.READ(query,listaCaberas,4);
    
     /*CUARTA CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t CUARTA CONSULTA");
    query = "SELECT nombres, apellidos FROM persona, gol WHERE persona.identificacion = gol.id_jugador AND gol.codigo_partido = 3 ORDER BY minuto ASC;";
    listaCaberas = new String[]{"nombres", "apellidos"};
    myJDBC.READ(query,listaCaberas,2);
    
    /*QUINTA CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t QUINTA CONSULTA");
    query = "SELECT COUNT(codigo) FROM partido INNER JOIN partidos_equipo ON partido.codigo = partidos_equipo.partido_codigo WHERE partidos_equipo.equipo_codigo = 3 AND partidos_equipo.es_local = 0;";
    listaCaberas = new String[]{"COUNT(codigo)"};
    myJDBC.READ(query,listaCaberas,1);
    
    /*SEXTA CONSULTA*/
    System.out.println("/n/n+++++++++++++++++++++++++++++++/n/t SEXTA CONSULTA");
    query = "SELECT goles_local, goles_visitante FROM partido WHERE fecha < '2021-03-27' ORDER BY fecha DESC;";
    listaCaberas = new String[]{"goles_local","goles_visitante"};
    myJDBC.READ(query,listaCaberas,2);
    
    
}

public static void Update(){
    String query;
    /*ACTUALIZACION 1*/
    query = "UPDATE equipo SET nombre_estadio='Wanda' WHERE codigo=3;";
    myJDBC.UPDATE(query);
    
    /*ACTUALIZACION 2*/
    query = "UPDATE partido SET fecha='2021-04-01 20:00:00' WHERE codigo=4;";
    myJDBC.UPDATE(query);
    
}
public static void Delete(){
    /*DELETE 1*/
    String query;
    query = "DELETE FROM jugador WHERE identificacion='0009' AND codigo_equipo=3;";
    myJDBC.DELETE(query);
}
}

