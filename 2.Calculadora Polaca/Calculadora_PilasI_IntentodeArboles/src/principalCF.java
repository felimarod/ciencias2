
public class principalCF {

    public static void main(String[] args) {
        
        Leer dat1 = new Leer(); 
        System.out.println("Ingrese la expresion aritmetica por favor ");
        String expreAr = dat1.datoStr();
        listaSimNor exArit = new listaSimNor();
        String preparado = exArit.preparaCadena(expreAr);
        exArit.llenaLista(preparado);
       
        boolean a = exArit.valida();//valida la operaci�n retorna un dato booleano
        
        String res = exArit.resolver(a);
        System.out.println(" = " + res);

    }

}
