/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Ariel AB
 */

public class ControlAcceso {

    String usuario;
    String contraseña;

    public boolean Acceder(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;

        return OtorgarPermiso();
    }

    public boolean OtorgarPermiso() {
        return true;
    }
}
