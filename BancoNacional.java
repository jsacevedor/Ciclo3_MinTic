/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banconacional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jccas
 */
public class BancoNacional {

    private Usuario usuarioAutenticado;
    
    private List<Usuario> usuarios;
    
    private Scanner sc;
    
    public BancoNacional() {
        this.usuarios = new ArrayList<>();      
        this.sc = new Scanner(System.in);
    }
    
    public void listarUsuarios() {   
        int cont = 1;
        for(Usuario u : usuarios)
        {
            System.out.println("Usuario " + cont);
            System.out.println(u.mostrar());
            cont++;
        }        
    }
    
    public void mostrarUsuarioAutenticado() {
        
        if(this.usuarioAutenticado != null)
        {
            System.out.println("Usuario Autenticado");
            System.out.println(usuarioAutenticado.mostrar());
        } else {
            System.out.println("No hay ningun usuario autenticado");
        }
        
    }
    
    public void registrarUsuario(String datos) {
        
        String[] sp = datos.split("/");
        Usuario user = new Usuario(sp[1], sp[2], sp[3], sp[4]);
        this.usuarios.add(user);
        System.out.println("Usuario creado exitosamente");        
        
    }    
    
    public void login(String datos) {
        
        if(this.usuarioAutenticado != null)
        {
            System.out.println("Ya hay un usuario autenticado");
            return;
        }
        
        String[] sp = datos.split("/");
        String usuarioIngresado = sp[1];
        String passwordIngresado = sp[2];
        
        for(Usuario u : usuarios)
        {
            if(u.autenticar(usuarioIngresado, passwordIngresado))
            {
                this.usuarioAutenticado = u;
                break;
            }
        }
        
        if(this.usuarioAutenticado == null)
        {
            System.out.println("Datos de acceso incorrectos");
        } else {
            System.out.println("Login exitoso");
        }                
        
    }    
    
    public void verCuentaAhorros() {
        
        if(this.usuarioAutenticado != null)
        {
            System.out.println(this.usuarioAutenticado.getCuentaAhorros().mostrar());
        } else {
            System.out.println("No hay ningun usuario autenticado");
        }        
    }
    
    public void verTarjetaCredito() {
        
        if(this.usuarioAutenticado != null)
        {
            if(this.usuarioAutenticado.getTarjetaCredito() != null)
            {
                System.out.println(this.usuarioAutenticado.getTarjetaCredito().mostrar());
            } else {
                System.out.println("El usuario autenticado no tiene tarjeta de crédito");
            }
        } else {
            System.out.println("No hay ningun usuario autenticado");
        }
        
    }
    
    public void hacerMovimiento(String datos) {
        
        if(this.usuarioAutenticado == null)
        {
            System.out.println("No hay un usuario autenticado");
            return;
        }
        
        String[] sp = datos.split("/");
        String tipoProducto = sp[1];
        double valorMovimiento = Double.parseDouble(sp[2]);
        String descripcion = sp[3];
        
        switch(tipoProducto) {
            case "TC":
                if(this.usuarioAutenticado.getTarjetaCredito() != null)
                {
                    boolean resultadoMovimiento = this.usuarioAutenticado.getTarjetaCredito().hacerMovimiento(descripcion, valorMovimiento);
                    if(resultadoMovimiento) {
                        System.out.println("Movimiento exitoso");
                    } else {
                        System.out.println("Cupo Insuficiente");
                    }
                    
                } else {
                    System.out.println("El usuario autenticado no tiene tarjeta de credito");
                }
                break;
            case "CA":
                boolean resultadoMovimiento = this.usuarioAutenticado.getCuentaAhorros().hacerMovimiento(descripcion, valorMovimiento);
                if(resultadoMovimiento) {
                    System.out.println("Movimiento exitoso");
                } else {
                    System.out.println("Saldo Insuficiente");
                }
                break;
            default:
                System.out.println("Tipo de producto no valido");
        }
        
        
    }
    
    public void crearTarjetaCredito() {
        
        if(this.usuarioAutenticado == null)
        {
            System.out.println("No hay un usuario autenticado");
            return;
        }
        
        if(this.usuarioAutenticado.abrirProducto("TC")) {
            System.out.println("Tarjeta de credito creada exitosamente");
        } else {
            System.out.println("Tipo producto no válido");
        }
        
    }
    
    public void mostrarMovimientos(String datos) {
        
        if(this.usuarioAutenticado == null)
        {
            System.out.println("No hay un usuario autenticado");
            return;
        }
        
        String[] sp = datos.split("/");
        String tipoProducto = sp[1];
        
        switch(tipoProducto) {
            case "CA":
                CuentaAhorros ca = this.usuarioAutenticado.getCuentaAhorros();
                System.out.println("Movimientos de la cuenta de ahorros");
                System.out.println("**************************************");
                for(Movimiento m : ca.getMovimientos()) {                    
                    System.out.println(m.mostrar());
                }
                break;
            case "TC":
                TarjetaCredito tc = this.usuarioAutenticado.getTarjetaCredito();
                
                if (tc == null)
                {
                    System.out.println("El usuario no tiene tarjeta de crédito asociada");
                    return;
                }
                
                System.out.println("Movimientos de la tarjeta de credito");
                System.out.println("**************************************");
                for(Movimiento m : tc.getMovimientos()) {                    
                    System.out.println(m.mostrar());
                }
                break;
            default:
                System.out.println("Tipo de producto no valido");
        }
    }
    
    public void logout() {
        this.usuarioAutenticado = null;
        System.out.println("Logout exitoso");
    }
    
    public boolean procesarComandos() {
        
        String comando = sc.nextLine();
        String[] sp = comando.split("/");
        int opcion = Integer.parseInt(sp[0]);
        
        switch(opcion) {
            
            case 1:
                listarUsuarios();
                break;
            case 2:
                registrarUsuario(comando);
                break;
            case 3:
                login(comando);
                break;
            case 4:
                verCuentaAhorros();
                break;
            case 5:
                verTarjetaCredito();
                break;
            case 6:
                hacerMovimiento(comando);
                break;
            case 7:
                mostrarMovimientos(comando);
                break;
            case 8:
                mostrarUsuarioAutenticado();
                break;
            case 9:
                logout();
                break;
            case 10:
                System.out.println("Muchas gracias por usar el portal del BancoNacional");
                return false;
            case 11:
                crearTarjetaCredito();
                break;
            default:
                System.out.println("Comando no válido, intente de nuevo.");
        }
        return true;
        
    }
    
    
//    public static void main(String[] args) {        
//        
//        BancoNacional banco = new BancoNacional();        
//        boolean seguir;        
//        do {
//            seguir = banco.procesarComandos();
//        } while(seguir);
//        
//    }
    
}
