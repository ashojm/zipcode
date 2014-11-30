import javax.swing.table.AbstractTableModel;

public class ZipSerchModel extends AbstractTableModel {

	

	public int iRowCnt;
	public int iColCnt;



	// private static String[][] datas = new String[][]{
	//
	//
	// {"1", "2", "3", "4"},
	// {"5", "6", "7", "8"},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	// {null, null, null, null},
	//
	// };

	private String[] columns = { "우편번호", "구군", "동", "리","SEQ","기타" };
	private String[] strdDtas;
	
	public void setDatas(String strData[]){
		strdDtas = strData;
		
		
	}

	public ZipSerchModel() {
		// TODO Auto-generated constructor stub
		
		// System.out.println(datas.length);
	}

	public int getRowCount() {
		
		 return 15;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}
	
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
