package presentacion.GUICliente;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaCliente extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private String[] _headers;

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getColumnName(int col) {
		return this._headers[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
