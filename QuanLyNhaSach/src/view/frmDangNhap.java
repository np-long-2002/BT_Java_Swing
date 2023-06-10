package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class frmDangNhap extends JDialog{
	private final JPanel contentPanel = new JPanel();
	private JTextField txttk;
	private JTextField txtmk;
	
	private String tendn;
	private String mk;
	public String getTendn() {
		return tendn;
	}

	public void setTendn(String tendn) {
		this.tendn = tendn;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getTennd() {
		return tennd;
	}

	public void setTennd(String tennd) {
		this.tennd = tennd;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	private String tennd;
	private boolean check;
	/**
	 * Create the dialog.
	 * @param b 
	 * @param actionListener 
	 */
	public frmDangNhap(Frame parent , boolean model) {
		super(parent,model);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0110\u0103ng Nh\u1EADp");
		lblNewLabel.setBounds(51, 76, 84, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt Kh\u1EA9u");
		lblNewLabel_1.setBounds(51, 113, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		txttk = new JTextField();
		txttk.setBounds(145, 73, 162, 20);
		contentPanel.add(txttk);
		txttk.setColumns(10);
		
		txtmk = new JTextField();
		txtmk.setBounds(145, 110, 162, 20);
		contentPanel.add(txtmk);
		txtmk.setColumns(10);
		
		JButton btndn = new JButton("\u0110\u0103ng Nh\u1EADp");
		btndn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection conn = null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;databaseName=quanlynhasach;integratedSecurity=true;trustServerCertificate=true;");
					Statement statement = conn.createStatement();
					String sql = "select * from NguoiDung where " +"TenDN = '"+txttk.getText()+"'"+"and MatKhau = '"+txtmk.getText()+"'";
					ResultSet set = statement.executeQuery(sql);
					while(set.next()) {
						tendn = set.getString("TenDN");
						mk = set.getString("MatKhau");
						tennd = set.getString("HoTen");
						check = true;
					}
					conn.close();
					if(check==true) {
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(btndn, "Sai tên tài khoản hoặc mật khẩu" );
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btndn.setBounds(58, 158, 124, 23);
		contentPanel.add(btndn);
		
		JButton btnexit = new JButton("Tho\u00E1t");
		btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btnexit.setBounds(215, 158, 89, 23);
		contentPanel.add(btnexit);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
