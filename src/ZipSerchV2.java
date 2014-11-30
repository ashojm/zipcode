import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ZipSerchV2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfDongName;
	private JTable tbResult;
	private JLabel lblFilePath;
	
	private String strDongName;
	private String strResult;
	private CZipSearch objzipSearch;
	
	public ArrayList arrResult;
	private int iRow;
	private int iRowCnt;
	private JButton btnSearch;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSerchV2 frame = new ZipSerchV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZipSerchV2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		arrResult = new ArrayList<String>();
		//iRowSize = 0;
		
		JButton btnFileOpen = new JButton("파일 열기");
		btnFileOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser("F:\\JavaExam\\ZipSearch");
				
				int result = fileChooser.showOpenDialog(ZipSerchV2.this);
				if(result == JFileChooser.APPROVE_OPTION){
					String path = fileChooser.getSelectedFile().getAbsolutePath();
					lblFilePath.setText(path);
					btnSearch.setEnabled(true);
					
				}else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("취소클릭");
				}
				
				
				//taResult.setText("");
				strDongName = tfDongName.getText();
				objzipSearch = new CZipSearch("./zipCode.txt");
				
				//초기화
				objzipSearch.InitBufferReader();
				
				objzipSearch.setStrDongName(strDongName);
				
				if (objzipSearch.InputValidation() == false){
					return;
				}	
				
			}
		});
		btnFileOpen.setBounds(12, 10, 97, 23);
		contentPane.add(btnFileOpen);
		
		lblFilePath = new JLabel("경로:");
		lblFilePath.setBackground(Color.GREEN);
		lblFilePath.setBounds(327, 12, 304, 19);
		contentPane.add(lblFilePath);
		
		tfDongName = new JTextField();
		tfDongName.setBounds(81, 101, 229, 21);
		contentPane.add(tfDongName);
		tfDongName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("동 이름:");
		lblNewLabel_1.setBounds(12, 104, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		btnSearch = new JButton("검색");
		btnSearch.setEnabled(false);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				strDongName = tfDongName.getText();
				objzipSearch = new CZipSearch("./zipCode.txt");
				
				//초기화
				objzipSearch.InitBufferReader();
				
				objzipSearch.setStrDongName(strDongName);
				
				if (objzipSearch.InputValidation() == false){
					JOptionPane.showMessageDialog(null, "동 이름을 입력하세요");
					return;
				}
				
				while(true){
					
						if (!objzipSearch.ReadZipCode()) {
						
							break;
						}
						objzipSearch.SpliteRowData();
						// 데이터 비교
						if (objzipSearch.CheckDongNameYn()) {
							iRowCnt++;
							
							iRow = objzipSearch.iRowNum;
							
							tbResult.setValueAt(objzipSearch.strArrSpliteData[0],iRow, 0);
							tbResult.setValueAt(objzipSearch.strArrSpliteData[1],iRow, 1);
							tbResult.setValueAt(objzipSearch.strArrSpliteData[2],iRow, 2);
							tbResult.setValueAt(objzipSearch.strArrSpliteData[3],iRow, 3);
							tbResult.setValueAt(objzipSearch.strArrSpliteData[4],iRow, 4);
							tbResult.setValueAt(objzipSearch.strArrSpliteData[5],iRow, 5);
							

						}

					}
				
				arrResult.clear();
				objzipSearch.CloseBuffrerReader();
				
				
			}
		});
		btnSearch.setBounds(327, 100, 97, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 145, 576, 243);
		contentPane.add(scrollPane);
		
		tbResult = new JTable();
		tbResult.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ZIPCODE", "SIDO", "\uAD6C\uAD70", "\uB3D9 \uC774\uB984", "\uB9AC", "\uBC88\uC9C0"
			}
		));
		scrollPane.setViewportView(tbResult);
	}

}
