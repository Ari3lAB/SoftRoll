/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DAO.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ariel AB
 */
public class VstTableItemModel extends AbstractTableModel {

    private List<Producto> productos;

    public VstTableItemModel(List<Producto> productos) {

        this.productos = new ArrayList<Producto>(productos);

    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = producto.getId();
                break;
            case 1:
                value = producto.getNombre();
                break;
            case 2:
                value = producto.getPrecio();
                break;
        }

        return value;

    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return // Return the class that best represents the column...
//    }

    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
     */
    /**
     * This will return the producto at the specified row...
     *
     * @param row
     * @return
     */
    public Producto getProductoAt(int row) {
        return productos.get(row);
    }
}
