
package Datos; 
 
import Modelos.ModVendedor; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.text.DecimalFormat;
import java.util.ArrayList; 
import java.util.List; 
import java.util.Random;
import java.util.Scanner; 
 
 
public class ClsDatos { 
     
    public List<ModVendedor> lista=new ArrayList<ModVendedor>(); 
    public final int NUMVENDEDORES=8; 
    private int nom=0; 
    private Scanner entrada=new Scanner(System.in);  
    private String s; 
     
    public void UltimoMsj(){ 
        System.out.println("\n\nSi desea regresar al Menú, ingrese la palabra 'M' : ");     
        String palabra=entrada.nextLine(); 
        palabra=entrada.nextLine(); 
         
        if(palabra.contains("M")){              
            Menu();             
        } 
    } 
     
    public void MostrarDatos(){ 
        DecimalFormat df = new DecimalFormat("###.##");        
        System.out.println("NOMBRE\t\t\t\tENERO\t\t\t\tFEBRERO\t\t\t\tMARZO\t\t\t\tABRIL\t\t\t\tVENTA TOTAL\t\t\t\tCOMISION\t\t\t\tTOTAL MAS COMISION\t\t\t\tISR\t\t\t\tTOTAL"); 
        for(ModVendedor e:lista){             
            System.out.print(e.nombre+"\t\t\t\tQ."+df.format(e.enero)+"\t\t\t\tQ."+df.format(e.febrero)+"\t\t\t\tQ."+df.format(e.marzo)+"\t\t\t\tQ."+df.format(e.abril)+"\t\t\t\tQ."+df.format(e.totalVentas)+"\t\t\t\tQ."+df.format(e.comision)+"\t\t\t\tQ."+df.format(e.totalMasComision)+"\t\t\t\tQ."+df.format(e.isr)+"\t\t\t\tQ."+df.format(e.granTotal)); 
            System.out.print("\n");                      
        }        
                 
    } 
     
    public void totalMeses(){ 
        System.out.println("NOMBRE DEL VENDEDOR\t\t\t\tTOTAL DE LAS VENTAS DE TODOS LOS MESES:"); 
        for(ModVendedor e:lista){ 
            System.out.print(e.nombre+"\t\t\t\t%.2fQ."+e.totalVentas); 
            System.out.print("\n");          
        }         
                 
    }
    
    public void totalXMeses(){ 
        double enero = 0;
        double febrero = 0;
        double marzo = 0;
        double abril = 0;
        for(ModVendedor e:lista) {
            enero += e.enero;
            febrero += e.febrero;
            marzo += e.marzo;
            abril += e.abril;
        }
        System.out.println("ENERO\t\t\t\tFEBRERO\t\t\t\tMARZO\t\t\t\tABRIL"); 
        System.out.print(enero+"\t\t\t\t%.2fQ."+febrero+"\t\t\t\tQ."+marzo+"\t\t\t\tQ."+abril); 
              
    }
     
    public void IngresoDatos(){ 
        ModVendedor vendedor= new ModVendedor(); 
 
        System.out.println("LA CANTIDAD MAXIMA DE VENDEDORES ES DE 8"); 
        System.out.println("¿Cuantos vendedores se registrarán?"); 
        int opcion=entrada.nextInt(); 
         
        if (opcion <= NUMVENDEDORES) { 
            for (int i = 0; i < opcion; i++) {             
               System.out.println("Ingrese nombre del vendedor "+(++nom)+":"); 
               s=entrada.nextLine(); 
               vendedor.nombre=entrada.nextLine(); 
               vendedor.enero=numRamdom(); 
               vendedor.febrero=numRamdom();
               vendedor.marzo=numRamdom();
               vendedor.abril=numRamdom();
               vendedor.totalVentas=vendedor.enero+vendedor.febrero+vendedor.marzo+vendedor.abril; 
               if(vendedor.totalVentas <= 2000){ 
                   vendedor.comision=vendedor.totalVentas * 0.2; 
               }else{ 
                   vendedor.comision=vendedor.totalVentas * 0.35; 
               } 
               vendedor.totalMasComision = vendedor.totalVentas + vendedor.comision; 
               vendedor.isr = vendedor.totalMasComision * 0.05; 
               vendedor.granTotal = vendedor.totalMasComision - vendedor.isr; 
               lista.add(vendedor);  
               vendedor=new ModVendedor(); 
           }    
        }else { 
            System.out.println("La cantidad no es valida"); 
        }                                               
    } 
     
    public double numRamdom() { 
        double valorMinimo = 100;
        double valorMaximo = 300;
        Random rand = new Random();
        double x = valorMinimo + ( valorMaximo - valorMinimo ) * rand.nextDouble();
        return  x;
    }
    
    public void NumMax(){ 
        double mayor=0; 
        double num=0;         
        double total=0; 
        String vendedor = "";          
         
        for(ModVendedor e: lista){            
            total=e.granTotal;         
            if (total > num ) 
            { 
                mayor=total;  
                vendedor = e.nombre; 
            } 
            num=mayor;                           
        }        
         
        System.out.println("EL VENDEDOR QUE RECIBIO MAS FUE: "+ vendedor+" Y LA CANTIDAD FUE DE: Q."+mayor+"\n\n"); 
         
    } 
    
    public void NumMin(){ 
        double num=0; 
        double menor=0; 
        double total=0; 
        String nombre = "";         
         
        for (ModVendedor e: lista) {             
            menor=e.granTotal; 
            for (ModVendedor x: lista) {             
                num=x.granTotal; 
                if(num<menor){ 
                    menor=num; 
                    nombre = x.nombre; 
                } 
 
            }
            }             
 
        System.out.println("EL VENDEDOR QUE RECIBIO MENOS FUE: "+ nombre+" Y LA CANTIDAD FUE DE: Q."+menor+"\n\n"); 
         
    } 
     
    
    public void Menu(){                
        System.out.print("\n\t\t\t\tSelecciona una Opcion"); 
        System.out.println("\n\t\t1. INGRESAR DATOS "); 
        System.out.println("\n\t\t2. VENTA MAXIMA"); 
        System.out.println("\n\t\t3. VENTA MINIMA"); 
        System.out.println("\n\t\t4. VENTAS TOTALES POR TODOS LOS MESES"); 
        System.out.println("\n\t\t5. VENTAS TOTALES POR CADA MES"); 
        System.out.println("\n\t\t6. MOSTRAR DATOS"); 
        int op=entrada.nextInt(); 
 
        try{                         
             
            switch(op){ 
            case 1: 
                IngresoDatos();                 
                UltimoMsj(); 
                break;           
            case 2: 
                NumMax(); 
                UltimoMsj(); 
                break; 
            case 3: 
                NumMin(); 
                UltimoMsj(); 
                break; 
            case 4:
                totalMeses();
                UltimoMsj();
            case 5:
                totalXMeses();
                UltimoMsj();
            case 6: 
                MostrarDatos(); 
                UltimoMsj(); 
                break; 
        } 
        }catch (Exception e){ 
            System.out.println(""+e); 
        } 
                
 
    } 
 
     
}