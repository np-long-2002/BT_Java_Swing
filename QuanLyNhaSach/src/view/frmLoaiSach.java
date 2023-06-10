package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class frmLoaiSach extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private static JTable tbLoaiSach;
	private JTextField txtMa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoaiSach frame = new frmLoaiSach();
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
	public frmLoaiSach() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn S\u00E1ch");
		lblNewLabel.setBounds(29, 194, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00F4 T\u1EA3");
		lblNewLabel_1.setBounds(29, 219, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(93, 191, 302, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 216, 302, 20);
		getContentPane().add(textField_1);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					String sql = "insert into LoaiSach values (?,?,?)";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, Integer.parseInt(txtMa.getText().toString().trim()));
					statement.setString(2, textField.getText().toString().trim());
					statement.setString(3,textField_1.getText().toString().trim());
					statement.executeUpdate();
					conn.close();
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnThem.setBounds(105, 247, 89, 23);
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					String sql = "delete from LoaiSach where LS_ID = ? ";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, txtMa.getText().toString().trim());
					statement.executeUpdate();
					conn.close();
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(207, 247, 89, 23);
		getContentPane().add(btnXoa);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					String sql = "update LoaiSach set Ten = ? , MoTa = ? where LS_ID = ? ";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, textField.getText().toString().trim());
					statement.setString(2,textField_1.getText().toString().trim());
					statement.setString(3,txtMa.getText().toString().trim());
					statement.executeUpdate();
					conn.close();
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnSa.setBounds(306, 247, 89, 23);
		getContentPane().add(btnSa);
		
		tbLoaiSach = new JTable();
		tbLoaiSach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tbLoaiSach.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbLoaiSach.getSelectedRow();
				txtMa.setText(String.valueOf(tbLoaiSach.getValueAt(row, 0)));;
				textField.setText(String.valueOf(tbLoaiSach.getValueAt(row, 1)));
				textField_1.setText(String.valueOf(tbLoaiSach.getValueAt(row, 2)));
			}
		});
		tbLoaiSach.setBounds(10, 11, 414, 145);
		getContentPane().add(tbLoaiSach);
		
		JLabel lblM = new JLabel("Mã");
		lblM.setBounds(29, 166, 46, 14);
		getContentPane().add(lblM);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(93, 163, 302, 20);
		getContentPane().add(txtMa);
		hienthi();
	}
public static void hienthi() {
	Connection conn = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
		Statement statement = conn.createStatement();
		String sql = "select * from LoaiSach";
		ResultSet set = statement.executeQuery(sql);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Sách");
		model.addColumn("Tên Sách");
		model.addColumn("Mô Tả");
		while(set.next()) {
			Vector vt = new Vector();
			vt.add(set.getInt("LS_ID"));
			vt.add(set.getString("Ten"));
			vt.add(set.getString("MoTa"));
			model.addRow(vt);
		}
		tbLoaiSach.setModel(model);
		conn.close();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
}
