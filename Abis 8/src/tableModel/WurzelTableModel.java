package tableModel;

import javax.swing.table.*;

class WurzelTableModel extends AbstractTableModel {
	final String[ ] columnNames = {"X", "Wurzel", "3. Wurzel"};
	int[] ersteSpalte = {1,2,3,4,5};
	private static final long serialVersionUID = 930096348695238927L;
	
	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return ersteSpalte.length;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 2:
			return Math.pow(ersteSpalte[rowIndex], (1.0/3));
		case 1:
			return Math.sqrt(ersteSpalte[rowIndex]);
		case 0:
		default:
			return ersteSpalte[rowIndex];
		}
	}
}