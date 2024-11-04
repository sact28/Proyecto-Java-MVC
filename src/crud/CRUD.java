
package crud;

import Controlador.CtrlPelicula;
import Modelo.ConsultasPeliculas;
import Modelo.Peliculas;
import Vista.frmPelicula;

/**
 *
 * @author DELL-5400
 */
public class CRUD {

   
    public static void main(String[] args) {
        
        Peliculas mod = new Peliculas();
        ConsultasPeliculas modC = new ConsultasPeliculas();
        frmPelicula frm = new frmPelicula();
        
        CtrlPelicula ctrl = new CtrlPelicula(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
