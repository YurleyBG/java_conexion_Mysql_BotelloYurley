
package concierto_conexion;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Concierto_conexion {

    public static void menuPrincipal(){
        System.out.println("-------MENU-------");
        System.out.println("1. Ver cociertos disponibles. ");
        System.out.println("2. Registrar clientes.");
        System.out.println("3. Comprar ticket.");
        System.out.println("4. Ver tickets por cliente.");
        System.out.println("5. Ver tickets por concierto.");
        System.out.println("6. Cancelar ticket.");
        System.out.println("7. Finalizar");
        System.out.println("-------------------");
    }
     public static void menuZona(){
        System.out.println("-------MENU-------");
        System.out.println("1. General 20.0. ");
        System.out.println("2. centro 15.0.");
        System.out.println("3. lateral_der 10.0.");
        System.out.println("4. lateral_izq 25.0.");
        System.out.println("5. VIP 25.0.");
        System.out.println("-------------------");
    }
    
   public static void main (String[] args) throws SQLException {
       
        conexion Conexion = new conexion();
        Connection obt = Conexion.conectar();
        Scanner scanner = new Scanner(System.in);
        Concierto_conexion abrir =new Concierto_conexion();
        
        System.out.println("--------BIENNVENIDO---------");
        System.out.println("");
        boolean booleanito=true;
        while(booleanito){
            abrir.menuPrincipal();
            System.out.println("");
            int ingresa_id=0;
            System.out.println("Ingrese la id a la que desea entrar:"); 
            ingresa_id=scanner.nextInt();
            switch(ingresa_id){
                case 1:
                    System.out.println("_______CONCIERTOS DISPONIBLES_____");
                    
                    PreparedStatement mostrarconcierto=null;
                    ResultSet verconcierto = null;
                     String sqlinsertc = "INSERT INTO concierto ( Nombre, Artista, Fecha, Lugar, PrecioBase) VALUES (?, ?, ?, ?,?)";
                    String sqlconcierto = "SELECT * FROM concierto ";
                    mostrarconcierto = obt.prepareStatement(sqlconcierto);
                    verconcierto=mostrarconcierto.executeQuery();
                    
                    while(verconcierto.next()){
                        String idecita = verconcierto.getString("id");
                        String Nombre = verconcierto.getString("Nombre");
                        String Artista = verconcierto.getString("Artista");
                        String Fecha = verconcierto.getString("Fecha");
                        String Lugar = verconcierto.getString("Lugar");
                        double PrecioBase = verconcierto.getDouble("PrecioBase");

                        System.out.println("id: " + idecita);
                        System.out.println("Nombre: " + Nombre);
                        System.out.println("Artista: " + Artista);
                        System.out.println("Fecha: " + Fecha);
                        System.out.println("Lugar: " + Lugar);
                        System.out.println("PrecioBase: " + PrecioBase);
                        System.out.println("----------------------------");
                    }  
                    
                break;
                case 2:
                    System.out.println("_______REGISTRAR CLIENTE_____");
                    int idcliente=0;
                    String Nombrecliente="";
                    String Apellido1cliente="";
                    String Apellido2cliente="";
                    String Correocliente="";
                    int Telefonocliente=0;
                   
                    System.out.println("ingrese el nombre:");
                    scanner.nextLine();
                    Nombrecliente=scanner.nextLine();
                    System.out.println("Ingrese el apellido1:");
                 
                    Apellido1cliente=scanner.nextLine();
                    System.out.println("Ingrese el apellido2:");
                    Apellido2cliente=scanner.nextLine();
                    System.out.println("Ingrese el correo electronico:"); 
                    Correocliente=scanner.nextLine();
                    System.out.println("Ingrese el numero de telefono:"); 
                    Telefonocliente=scanner.nextInt();
                    PreparedStatement insertarcliente=null;
                    PreparedStatement mostrarcliente=null;
                    ResultSet vercliente = null;
                    String cinser="INSERT INTO cliente (Nombre, Apellido1,Apellido2, Correo, Telefono) VALUES (?, ?, ?, ?,?)";
                    System.out.println("");
                    System.out.println("----Lista Clientes----");
                    System.out.println("");
                    insertarcliente = obt.prepareStatement(cinser);
                    insertarcliente.setString(1, Nombrecliente);
                    insertarcliente.setString(2, Apellido1cliente);
                    insertarcliente.setString(3, Apellido2cliente);
                    insertarcliente.setString(4, Correocliente);
                    
                    insertarcliente.setInt(5, Telefonocliente);
                    
                    insertarcliente.executeUpdate();
                    String sqlclientes = "SELECT * FROM cliente ";
                    mostrarcliente = obt.prepareStatement(sqlclientes);
                    vercliente=mostrarcliente.executeQuery();
                    
                    while(vercliente.next()){
                        String idecita = vercliente.getString("id");
                        String Nombre = vercliente.getString("Nombre");
                        String Apellido1 = vercliente.getString("Apellido1");
                        String Apellido2 = vercliente.getString("Apellido2");
                        String Correo = vercliente.getString("Correo");
                        int Telefono = vercliente.getInt("Telefono");

                        System.out.println("id: " + idecita);
                        System.out.println("Nombre: " + Nombre);
                        System.out.println("Apellido1: " + Apellido1);
                        System.out.println("Apellido2: " + Apellido2);
                        System.out.println("Correo: " + Correo);
                        System.out.println("Telefono: " + Telefono);
                        System.out.println("----------------------------");

                    }  
                break;
                case 3:
                    System.out.println("_______COMPRAR TICKET_____");
                    System.out.println("");
                    int idnewticket=0;
                    int idnewcliente=0;
                    int idconcierto=0;
                    int Tzona=0;
                    String fecha="";
                    
                    System.out.println("Ingrese la fecha de la compra:"); 
                    scanner.nextLine();
                    fecha=scanner.nextLine();
                    System.out.println("ingrese la id del cliente:");
                    idnewcliente=scanner.nextInt();
                    System.out.println("Ingrese la id del concierto:");
                    idconcierto=scanner.nextInt();
                    abrir.menuZona();
                    System.out.println("Ingrese el id de la zona que quiere:"); 
                    Tzona=scanner.nextInt();
                    
                    if(Tzona==1){
                        PreparedStatement sumaTotalt=null;
                        ResultSet precio=null;
                        String total = "SELECT c.Preciobase + z.PrecioAdicional FROM concierto c inner join ticket t on c.id=t.ID_Concierto"
                                +" "+ " inner join zona z on t.zona=z.NombreZona WHERE ID_Cliente = ? and zona= ?";
                        sumaTotalt = obt.prepareStatement(total);
                        sumaTotalt.setInt(1, idnewcliente);
                        sumaTotalt.setString(2, "General");
                        precio=sumaTotalt.executeQuery();
                        if(precio.next()){
                            double precioFin = precio.getDouble(1);
                            
                            PreparedStatement insertTicket=null;
                            String Tinser="INSERT INTO ticket ( ID_Cliente, ID_Concierto, zona, precioFinal, fechaCompra) VALUES (?, ?, ?, ?,?)";

                            insertTicket = obt.prepareStatement(Tinser);
                            insertTicket.setInt(1, idnewcliente);
                            insertTicket.setInt(2, idconcierto);
                            insertTicket.setString(3, "General");
                            insertTicket.setDouble(4, precioFin);
                            insertTicket.setString(5, fecha);

                            insertTicket.executeUpdate();
                        }
                         
                    }
                    if(Tzona==2){
                        PreparedStatement sumaTotalt=null;
                        ResultSet precio=null;
                        String total = "SELECT Preciobase + PrecioAdicional FROM concierto c inner join ticket t on c.id=t.ID_Concierto"
                                +" "+ " inner join zona z on t.zona=z.NombreZona WHERE ID_Cliente = ? and zona= ?";
                        sumaTotalt = obt.prepareStatement(total);
                        sumaTotalt.setInt(1, idnewcliente);
                        sumaTotalt.setString(2, "Centro");
                        precio=sumaTotalt.executeQuery();
                        if(precio.next()){
                            double precioFin = precio.getDouble(1);
                            
                            PreparedStatement insertTicket=null;
                            String Tinser="INSERT INTO ticket ( ID_Cliente, ID_Concierto, zona, precioFinal, fechaCompra) VALUES (?, ?, ?, ?,?)";

                            insertTicket = obt.prepareStatement(Tinser);
                            insertTicket.setInt(1, idnewcliente);
                            insertTicket.setInt(2, idconcierto);
                            insertTicket.setString(3, "Centro");
                            insertTicket.setDouble(4, precioFin);
                            insertTicket.setString(5, fecha);

                            insertTicket.executeUpdate();
                        }
                       
                    }
                    if(Tzona==3){
                        PreparedStatement sumaTotalt=null;
                        ResultSet precio=null;
                        String total = "SELECT Preciobase + PrecioAdicional FROM concierto c inner join ticket t on c.id=t.ID_Concierto"
                                +" "+ " inner join zona z on t.zona=z.NombreZona WHERE ID_Cliente = ? and zona= ?";
                        sumaTotalt = obt.prepareStatement(total);
                        sumaTotalt.setInt(1, idnewcliente);
                        sumaTotalt.setString(2, "Lateral_der");
                        precio=sumaTotalt.executeQuery();
                        if(precio.next()){
                            double precioFin = precio.getDouble(1);
                            
                            PreparedStatement insertTicket=null;
                            String Tinser="INSERT INTO ticket ( ID_Cliente, ID_Concierto, zona, precioFinal, fechaCompra) VALUES (?, ?, ?, ?,?)";

                            insertTicket = obt.prepareStatement(Tinser);
                            insertTicket.setInt(1, idnewcliente);
                            insertTicket.setInt(2, idconcierto);
                            insertTicket.setString(3, "Lateral_der");
                            insertTicket.setDouble(4, precioFin);
                            insertTicket.setString(5, fecha);

                            insertTicket.executeUpdate();
                        }
                       
                    }
                    if(Tzona==4){
                        PreparedStatement sumaTotalt=null;
                        ResultSet precio=null;
                        String total = "SELECT Preciobase + PrecioAdicional FROM concierto c inner join ticket t on c.id=t.ID_Concierto"
                                +" "+ " inner join zona z on t.zona=z.NombreZona WHERE ID_Cliente = ? and zona= ?";
                        sumaTotalt = obt.prepareStatement(total);
                        sumaTotalt.setInt(1, idnewcliente);
                        sumaTotalt.setString(2, "Lateral_izq");
                        precio=sumaTotalt.executeQuery();
                        if(precio.next()){
                            double precioFin = precio.getDouble(1);
                            
                            PreparedStatement insertTicket=null;
                            String Tinser="INSERT INTO ticket (ID_Cliente, ID_Concierto, zona, precioFinal, fechaCompra) VALUES (?, ?, ?, ?,?)";

                            insertTicket = obt.prepareStatement(Tinser);
                            insertTicket.setInt(1, idnewcliente);
                            insertTicket.setInt(2, idconcierto);
                            insertTicket.setString(3, "Lateral_izq");
                            insertTicket.setDouble(4, precioFin);
                            insertTicket.setString(5, fecha);

                            insertTicket.executeUpdate();
                        }
                     
                    }
                    if(Tzona==5){
                        
                        PreparedStatement sumaTotalt=null;
                        ResultSet precio=null;
                        String total = "SELECT Preciobase + PrecioAdicional FROM concierto c inner join ticket t on c.id=t.ID_Concierto"
                                +" "+ " inner join zona z on t.zona=z.NombreZona WHERE ID_Cliente = ? and zona= ?";
                        sumaTotalt = obt.prepareStatement(total);
                        sumaTotalt.setInt(1, idnewcliente);
                        sumaTotalt.setString(2, "Vip");
                        precio=sumaTotalt.executeQuery();
                        if(precio.next()){
                            double precioFin = precio.getDouble(1);
                            
                            PreparedStatement insertTicket=null;
                            String Tinser="INSERT INTO ticket ( ID_Cliente, ID_Concierto, zona, precioFinal, fechaCompra) VALUES (?, ?, ?, ?,?)";

                            insertTicket = obt.prepareStatement(Tinser);
                            insertTicket.setInt(1, idnewcliente);
                            insertTicket.setInt(2, idconcierto);
                            insertTicket.setString(3, "Vip");
                            insertTicket.setDouble(4, precioFin);
                            insertTicket.setString(5, fecha);

                            insertTicket.executeUpdate();
                        }
                        
                    }
                break;
                case 4:
                    
                      System.out.println("_______LISTAR TICKETS POR CLIENTE_____");
                    System.out.println("");
                    int idClientecito=0;
                    PreparedStatement mostrar1=null;
                    ResultSet ver1 = null;
                    System.out.println("Ingrese la id del cliente: ");
                    idClientecito=scanner.nextInt();
                    
                    String sqlticket1 = "SELECT * FROM ticket WHERE ID_Cliente = ?";
                    mostrar1 = obt.prepareStatement(sqlticket1);
                    mostrar1.setInt(1,idClientecito);
                    
                    ver1=mostrar1.executeQuery();
                    while(ver1.next()){
                        int idTicket = ver1.getInt("id");
                        int idCliente = ver1.getInt("ID_Cliente");
                        int idConcierto = ver1.getInt("ID_Concierto");
                        String zona = ver1.getString("Zona");
                        String fechaCompra = ver1.getString("FechaCompra");
                        double precioFinal = ver1.getDouble("PrecioFinal");

                       
                        System.out.println("ID_Ticket: " + idTicket);
                        System.out.println("ID_Cliente: " + idCliente);
                        System.out.println("ID_Concierto: " + idConcierto);
                        System.out.println("Zona: " + zona);
                        System.out.println("Fecha de Compra: " + fechaCompra);
                        System.out.println("Precio Final: " + precioFinal);
                        System.out.println("----------------------------");

                    }  
                    
                break;
                case 5:
                    System.out.println("_______LISTAR TICKETS POR CONCIERTO_____");
                    System.out.println("");
                    int idCONCIERTICO=0;
                    int contador=0;
                    PreparedStatement mostrar=null;
                    ResultSet ver = null;
                    System.out.println("Ingrese la id del Concierto: ");
                    idCONCIERTICO=scanner.nextInt();
                 
                    
                    String sqlticket = "SELECT * FROM ticket WHERE ID_Concierto = ?";
                    mostrar = obt.prepareStatement(sqlticket);
                    mostrar.setInt(1,idCONCIERTICO);
                    
                    ver=mostrar.executeQuery();
                    while(ver.next()){
                        int idTicket = ver.getInt("id");
                        int idCliente = ver.getInt("ID_Cliente");
                        int idConcierto = ver.getInt("ID_Concierto");
                        String zona = ver.getString("Zona");
                        String fechaCompra = ver.getString("FechaCompra");
                        double precioFinal = ver.getDouble("PrecioFinal");

                       
                        System.out.println("ID_Ticket: " + idTicket);
                        System.out.println("ID_Cliente: " + idCliente);
                        System.out.println("ID_Concierto: " + idConcierto);
                        System.out.println("Zona: " + zona);
                        System.out.println("Fecha de Compra: " + fechaCompra);
                        System.out.println("Precio Final: " + precioFinal);
                        System.out.println("----------------------------");

                    }  
                break;
                case 6:
                    System.out.println("_______CANCELAR TICKET_____");
                    System.out.println("");
                    
                    PreparedStatement eliminarT=null;
                    int idCliente_Ticket=0;
                    int idCon_Ticket=0;
                    
                    System.out.println("Ingrese la id del cliente que desea cacelar su ticket: ");
                    idCliente_Ticket=scanner.nextInt();
                    System.out.println("Ingrese la id del concierto que desea cancelar: ");
                    idCon_Ticket=scanner.nextInt();
                    boolean ticketCancelado = false;

                    String sqlDelete = "DELETE FROM ticket WHERE ID_Cliente = ? and ID_Concierto=? ";
                    eliminarT = obt.prepareStatement(sqlDelete);
                    eliminarT.setInt(1, idCliente_Ticket);
                    eliminarT.setInt(2, idCon_Ticket);
                    
                    int filasEliminadas = eliminarT.executeUpdate();
                    
                break;
                case 7:
                    System.out.println("Haz abandonado el programa Hasta la proxima :)");
                    booleanito=false;
                break;
                
            }
        }
        
    }
}
   