package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import model.KhachHang;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtMaKH;
	private static JTextField txtTenKH;
	private static JTextField txtnamSinh;
	private static JTable table;
	static ArrayList<KhachHang> dskh;
	static int row ;
	static int toi =0;
	static int lui;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					hienthi();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng");
		lblNewLabel.setBounds(10, 273, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setBounds(10, 306, 94, 14);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblNmSinh = new JLabel("Năm Sinh");
		lblNmSinh.setBounds(10, 337, 94, 14);
		contentPane.add(lblNmSinh);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(114, 270, 140, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(114, 303, 140, 20);
		contentPane.add(txtTenKH);
		
		txtnamSinh = new JTextField();
		txtnamSinh.setColumns(10);
		txtnamSinh.setBounds(114, 334, 140, 20);
		contentPane.add(txtnamSinh);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = table.getSelectedRow();     
			     KhachHangDAO khdao = new KhachHangDAO();
			     khdao.xoaSP(table.getValueAt(index,0).toString());
			     hienthi();
			}
		});
		btnXoa.setBounds(10, 373, 89, 23);
		contentPane.add(btnXoa);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KhachHang kh = new KhachHang();
			     kh.setMaKH(txtMaKH.getText());
			     kh.setTenKH(txtTenKH.getText());
			     kh.setNamSinh(Integer.parseInt(txtnamSinh.getText()));
			     KhachHangDAO khdao =new KhachHangDAO() ;
			     if (khdao.luuSP(kh)>0 )
			     {    
			      JOptionPane.showMessageDialog(null, "lưu thành công");
			      hienthi();
			      }
			      else
			           JOptionPane.showMessageDialog(null, "lưu that bại");
			}
		});
		btnLuu.setBounds(114, 373, 89, 23);
		contentPane.add(btnLuu);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtnamSinh.setText("");
				txtMaKH.requestFocus();
			}
		});
		btnThem.setBounds(213, 373, 89, 23);
		contentPane.add(btnThem);
		
		JButton btnLui = new JButton("<");
		btnLui.setBounds(44, 11, 60, 44);
		btnLui.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lui = table.getSelectedRow();
				lui--;
				if(lui<dskh.size()) {
					lui=0;
				}
				table.setRowSelectionInterval(lui, lui);
				duyet(lui);
			}
		});
		contentPane.add(btnLui);
		
		JButton btnTien = new JButton(">");
		btnTien.setBounds(340, 11, 60, 44);
		btnTien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				toi = table.getSelectedRow();
				toi++;
				if(toi==dskh.size()) {
					toi=0;
				}
				table.setRowSelectionInterval(toi, toi);
				duyet(toi);
			}
		});
		contentPane.add(btnTien);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "N\u0103m Sinh"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setPreferredWidth(62);
		table.addMouseListener(new MouseListener() {
			
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
				vitriTable();
			}
		});
		table.setBounds(10, 59, 441, 203);
		contentPane.add(table);
	}
	public static void hienthi() {
		KhachHangDAO khDAO  = new KhachHangDAO();
		dskh = khDAO.docKhachHang();
		DefaultTableModel dftbl = (DefaultTableModel)table.getModel();
	    dftbl.setRowCount(0);
	    for(int i=0;i<dskh.size(); i++)
	    {
	    	Vector<Object> vec = new Vector<>();
	        vec.add(dskh.get(i).getMaKH());
	        vec.add(dskh.get(i).getTenKH());
	        vec.add(dskh.get(i).getNamSinh());
	        dftbl.addRow(vec);   
	    }
	}
	public static void vitriTable() {
		row = table.getSelectedRow();
		if(row == -1) {
			return;
		}
	     KhachHang kh = dskh.get(row);
	     txtTenKH.setText(kh.getTenKH()); 
	     txtMaKH.setText(dskh.get(row).getMaKH());
	     txtnamSinh.setText(String.valueOf(kh.getNamSinh()));
	}
	public static void duyet(int toi) {
		txtMaKH.setText(dskh.get(toi).getMaKH());
		txtTenKH.setText(dskh.get(toi).getTenKH());
		txtnamSinh.setText(String.valueOf(dskh.get(toi).getNamSinh()));
	}
}
