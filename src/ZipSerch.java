import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ZipSerch extends JFrame {

	private JPanel contentPane;
	private JTextField tfDongName;
	private String strDongName;
	private String strResult;
	private CZipSearch objzipSearch;
	private JTextArea taResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSerch frame = new ZipSerch();
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
	public ZipSerch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(40, 37, 539, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("동 이름");
		label.setBounds(12, 36, 57, 15);
		panel.add(label);
		
		tfDongName = new JTextField();
		tfDongName.setBounds(81, 33, 254, 21);
		panel.add(tfDongName);
		tfDongName.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taResult.setText("");
				strDongName = tfDongName.getText();
				objzipSearch = new CZipSearch("./zipCode.txt");
				
				//초기화
				objzipSearch.InitBufferReader();
				
				objzipSearch.setStrDongName(strDongName);
				
				if (objzipSearch.InputValidation() == false){
					return;
				}
				
				while(true){
				
				//사용자 입력 값 검증
					if (!objzipSearch.ReadZipCode() == false) {
						break;
					}
					objzipSearch.SpliteRowData();
					// 데이터 비교
					if (objzipSearch.CheckDongNameYn()) {
						// 데이터 출력
						strResult = objzipSearch.DisplayData();
						taResult.append(strResult);

					}

				}

			}
		});
		btnSearch.setBounds(347, 32, 78, 23);
		panel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 129, 539, 258);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}
}
