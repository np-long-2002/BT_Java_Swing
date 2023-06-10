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
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;

public class frmHoaDon extends JInternalFrame {
	private JTextField txtMa;
	private JTextField txtNgay;
	private JTextField txtNV;
	private JTextField txtKH;
	private JTextField txtGC;
	private static JTable tbHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHoaDon frame = new frmHoaDon();
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
	public frmHoaDon() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3");
		lblNewLabel.setBounds(10, 156, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNgy = new JLabel("Ng\u00E0y");
		lblNgy.setBounds(10, 181, 46, 14);
		getContentPane().add(lblNgy);
		
		JLabel lblNhnVin = new JLabel("Nh\u00E2n Vi\u00EAn");
		lblNhnVin.setBounds(10, 206, 46, 14);
		getContentPane().add(lblNhnVin);
		
		JLabel lblTnKhchHng = new JLabel("T\u00EAn Kh\u00E1ch H\u00E0ng");
		lblTnKhchHng.setBounds(188, 156, 46, 14);
		getContentPane().add(lblTnKhchHng);
		
		JLabel lblGhiCh = new JLabel("Ghi Ch\u00FA");
		lblGhiCh.setBounds(188, 181, 46, 14);
		getContentPane().add(lblGhiCh);
		
		txtMa = new JTextField();
		txtMa.setBounds(66, 153, 112, 20);
		getContentPane().add(txtMa);
		txtMa.setColumns(10);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(66, 178, 112, 20);
		getContentPane().add(txtNgay);
		
		txtNV = new JTextField();
		txtNV.setColumns(10);
		txtNV.setBounds(66, 203, 112, 20);
		getContentPane().add(txtNV);
		
		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setBounds(244, 153, 112, 20);
		getContentPane().add(txtKH);
		
		txtGC = new JTextField();
		txtGC.setColumns(10);
		txtGC.setBounds(244, 178, 112, 20);
		getContentPane().add(txtGC);
		
		JButton btnThem = new JButton("Th\u00EAm ");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					String sql = "insert into HoaDon values (?,?,?,?,?)";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, Integer.parseInt(txtMa.getText().toString().trim()));
					statement.setString(2, txtNgay.getText().toString().trim());
					statement.setString(3,txtNV.getText().toString().trim());
					statement.setString(4,txtKH.getText().toString().trim());
					statement.setString(5,txtGC.getText().toString().trim());
					statement.executeUpdate();
					conn.close();
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnThem.setBounds(10, 236, 89, 23);
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
					String sql = "delete from HoaDon where HD_ID = ? ";
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
		btnXoa.setBounds(145, 234, 89, 23);
		getContentPane().add(btnXoa);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					String sql = "update HoaDon set Ngay = ? , NhanVien = ? , TenKH = ? ,GhiChu = ? where HD_ID = ? ";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, txtNgay.getText().toString().trim());
					statement.setString(2,txtNV.getText().toString().trim());
					statement.setString(3,txtKH.getText().toString().trim());
					statement.setString(4,txtGC.getText().toString().trim());
					statement.setInt(5, Integer.parseInt(txtMa.getText().toString().trim()));
					statement.executeUpdate();
					conn.close();
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnSua.setBounds(278, 236, 89, 23);
		getContentPane().add(btnSua);
		
		tbHD = new JTable();
		tbHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbHD.getSelectedRow();
				txtMa.setText(String.valueOf(tbHD.getValueAt(row, 0)));;
				txtNgay.setText(String.valueOf(tbHD.getValueAt(row, 1)));
				txtNV.setText(String.valueOf(tbHD.getValueAt(row, 2)));
				txtKH.setText(String.valueOf(tbHD.getValueAt(row, 3)));
				txtGC.setText(String.valueOf(tbHD.getValueAt(row, 4)));
			}
		});
		tbHD.setBounds(10, 11, 414, 131);
		getContentPane().add(tbHD);
		hienthi();
	}
	public static void hienthi() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
			Statement statement = conn.createStatement();
			String sql = "select * from HoaDon";
			ResultSet set = statement.executeQuery(sql);
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Mã Hóa Đơn");
			model.addColumn("Ngày");
			model.addColumn("Nhân Viên");
			model.addColumn("Khach Hàng");
			model.addColumn("Ghi Chú");
			while(set.next()) {
				Vector vt = new Vector();
				vt.add(set.getInt("HD_ID"));
				vt.add(set.getDate("Ngay"));
				vt.add(set.getString("NhanVien"));
				vt.add(set.getString("TenKH"));
				vt.add(set.getString("GhiChu"));
				model.addRow(vt);
			}
			tbHD.setModel(model);
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
