
package Controlador;

import Modelo.ConsultasPeliculas;
import Modelo.Peliculas;
import Vista.frmPelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CtrlPelicula implements ActionListener {
    private Peliculas mod;
    private ConsultasPeliculas modC;
    private frmPelicula frm;

    public CtrlPelicula(Peliculas mod, ConsultasPeliculas modC, frmPelicula frm){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Catálogo de Películas");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frm.btnAgregar) {
            mod.setTitulo(frm.txtTitulo.getText());
            mod.setGenero(frm.txtGenero.getText());
            mod.setDirector(frm.txtDirector.getText());
            mod.setFecha(convertirFecha(frm.txtFecha.getText()));

            if(modC.agregar(mod)) {
                JOptionPane.showMessageDialog(null, "Agregado correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
                limpiar();
            }
        }

        if(e.getSource() == frm.btnModificar) {
            mod.setTitulo(frm.txtTitulo.getText());
            mod.setGenero(frm.txtGenero.getText());
            mod.setDirector(frm.txtDirector.getText());
           mod.setFecha(convertirFecha(frm.txtFecha.getText()));

            if(modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }

        if(e.getSource() == frm.btnEliminar) {
            mod.setTitulo(frm.txtTitulo.getText());

            if(modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        if(e.getSource() == frm.btnBuscar) {
            mod.setTitulo(frm.txtTitulo.getText());

            if(modC.buscar(mod)) {
                frm.txtTitulo.setText(mod.getTitulo());
                frm.txtGenero.setText(mod.getGenero());
                frm.txtDirector.setText(mod.getDirector());
                frm.txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(mod.getFecha()));
            } else {
                JOptionPane.showMessageDialog(null, "No encontrado");
            }
        }

        if(e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtTitulo.setText(null);
        frm.txtGenero.setText(null);
        frm.txtDirector.setText(null);
        frm.txtFecha.setText(null);
    }

   private Date convertirFecha(String text) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(text);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use dd/MM/yyyy");
            return null;
        }
    }

}