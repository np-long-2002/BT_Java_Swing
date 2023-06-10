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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import dao.SachDAO;
import model.Sach;

import javax.swing.JTable;
import javax.swing.JButton;

public class frmSach extends JInternalFrame {
	private JTextField txtMa;
	private JTextField txtTieuDe;
	private JTextField txtTacGia;
	private JTextField txtnam;
	private JTextField txtLoai;
	private JTextField txtmota;
	private static JTable tbSach;
	private  static ArrayList<Sach> arrayList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSach frame = new frmSach();
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
	public frmSach() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("M\u00E3");
		lblNewLabel.setBounds(10, 171, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTiu = new JLabel("Ti\u00EAu \u0110\u1EC1");
		lblTiu.setBounds(10, 196, 46, 14);
		getContentPane().add(lblTiu);
		
		JLabel lblTcGi = new JLabel("T\u00E1c Gi\u1EA3");
		lblTcGi.setBounds(10, 221, 46, 14);
		getContentPane().add(lblTcGi);
		
		JLabel lblNmIn = new JLabel("N\u0103m In");
		lblNmIn.setBounds(222, 171, 46, 14);
		getContentPane().add(lblNmIn);
		
		JLabel lblThLoi = new JLabel("Th\u1EC3 Lo\u1EA1i");
		lblThLoi.setBounds(222, 196, 46, 14);
		getContentPane().add(lblThLoi);
		
		JLabel lblMT = new JLabel("M\u00F4 T\u1EA3");
		lblMT.setBounds(222, 221, 46, 14);
		getContentPane().add(lblMT);
		
		txtMa = new JTextField();
		txtMa.setBounds(66, 168, 146, 20);
		getContentPane().add(txtMa);
		txtMa.setColumns(10);
		
		txtTieuDe = new JTextField();
		txtTieuDe.setColumns(10);
		txtTieuDe.setBounds(66, 193, 146, 20);
		getContentPane().add(txtTieuDe);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(66, 218, 146, 20);
		getContentPane().add(txtTacGia);
		
		txtnam = new JTextField();
		txtnam.setColumns(10);
		txtnam.setBounds(278, 168, 146, 20);
		getContentPane().add(txtnam);
		
		txtLoai = new JTextField();
		txtLoai.setColumns(10);
		txtLoai.setBounds(278, 193, 146, 20);
		getContentPane().add(txtLoai);
		
		txtmota = new JTextField();
		txtmota.setColumns(10);
		txtmota.setBounds(278, 218, 146, 20);
		getContentPane().add(txtmota);
		
		tbSach = new JTable();
		tbSach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tbSach.addMouseListener(new MouseListener() {
			
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
				int row = tbSach.getSelectedRow();
				txtMa.setText(String.valueOf(tbSach.getValueAt(row, 0)));;
				txtTieuDe.setText(String.valueOf(tbSach.getValueAt(row, 1)));
				txtTacGia.setText(String.valueOf(tbSach.getValueAt(row, 2)));
				txtnam.setText(String.valueOf(tbSach.getValueAt(row, 3)));
				txtLoai.setText(String.valueOf(tbSach.getValueAt(row, 4)));
				txtmota.setText(String.valueOf(tbSach.getValueAt(row, 5)));
			}
		});
		tbSach.setBounds(10, 11, 414, 149);
		getContentPane().add(tbSach);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Sach sach = new Sach();
					sach.setId(Integer.parseInt(txtMa.getText()));
					sach.setTieuDe(txtTieuDe.getText());
					sach.setTacGia(txtTacGia.getText());
					sach.setNamSX(Integer.parseInt(txtnam.getText()));
					sach.setTheLoai(Integer.parseInt(txtLoai.getText()));
					sach.setMoTa(txtmota.getText());
					SachDAO dao = new SachDAO();
					if (dao.luuSP(sach)>0 )
				     {    
				      JOptionPane.showMessageDialog(null, "lưu thành công");
				      hienthi();
				      }
				      else
				           JOptionPane.showMessageDialog(null, "lưu that bại");
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnThem.setBounds(39, 246, 89, 23);
		getContentPane().add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					int index = tbSach.getSelectedRow();     
				     SachDAO dao = new SachDAO();
				    dao.xoaSP(tbSach.getValueAt(index,0).toString());
					hienthi();
				}catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnXoa.setBounds(179, 246, 89, 23);
		getContentPane().add(btnXoa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sach sach = new Sach();
				sach.setTieuDe(txtTieuDe.getText());
				sach.setTacGia(txtTacGia.getText());
				sach.setNamSX(Integer.parseInt(txtnam.getText()));
				sach.setMoTa(txtmota.getText());
				sach.setId(Integer.parseInt(txtMa.getText()));
				SachDAO dao = new SachDAO();
				if (dao.capnhapSP(sach)>0 )
			       {    
			    	   JOptionPane.showMessageDialog(null, "câp nhật thành công");
			    	   hienthi();
			       }
			       else
			           JOptionPane.showMessageDialog(null, "cập nhật that bại,khong duoc sua ma");
			}
		});
		btnSa.setBounds(323, 246, 89, 23);
		getContentPane().add(btnSa);
		hienthi();

	}
	public static void hienthi() {
		SachDAO dao = new SachDAO();
		arrayList = dao.docLS();
		DefaultTableModel model = (DefaultTableModel) tbSach.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
	        vec.add(arrayList.get(i).getId());
	        vec.add(arrayList.get(i).getTieuDe());
	        vec.add(arrayList.get(i).getTacGia());
	        vec.add(arrayList.get(i).getNamSX());
	        vec.add(arrayList.get(i).getTheLoai());
	        vec.add(arrayList.get(i).getMoTa());
	        model.addRow(vec); 
		}
	}
}
