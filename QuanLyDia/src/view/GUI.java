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
import javax.swing.table.DefaultTableModel;

import dao.CDDVDdao;
import model.CDDVD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTable tbCD;
	private static ArrayList<CDDVD> arrayList;
	static int row;
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
		setBounds(100, 100, 559, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTiu = new JLabel("Tiêu Đề");
		lblTiu.setBounds(10, 36, 46, 14);
		contentPane.add(lblTiu);
		
		JLabel lblLoia = new JLabel("Loại Đĩa");
		lblLoia.setBounds(10, 61, 46, 14);
		contentPane.add(lblLoia);
		
		JLabel lblNmXutBn = new JLabel("Năm Xuất Bản");
		lblNmXutBn.setBounds(10, 86, 46, 14);
		contentPane.add(lblNmXutBn);
		
		textField = new JTextField();
		textField.setBounds(80, 8, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 33, 190, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 58, 190, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(80, 83, 190, 20);
		contentPane.add(textField_3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.requestFocus();
			}
		});
		btnThem.setBounds(10, 111, 89, 23);
		contentPane.add(btnThem);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CDDVD cddvd = new CDDVD();
				cddvd.setMa(textField.getText());
				cddvd.setTieude(textField_1.getText());
				cddvd.setLoaidia(textField_2.getText());
				cddvd.setNam(Integer.parseInt(textField_3.getText()));
				CDDVDdao ddao = new CDDVDdao();
				  if (ddao.luuDia(cddvd)>0 )
				     {    
				      JOptionPane.showMessageDialog(null, "lưu thành công");
				      hienthi();
				      }
				      else
				           JOptionPane.showMessageDialog(null, "lưu that bại");
			}
		});
		btnLuu.setBounds(109, 111, 89, 23);
		contentPane.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = tbCD.getSelectedRow();     
			     CDDVDdao ddao = new CDDVDdao();
			     ddao.xoaDia(tbCD.getValueAt(index,0).toString());
			     hienthi();
			}
		});
		btnXoa.setBounds(208, 111, 89, 23);
		contentPane.add(btnXoa);
		
		JButton btnTK = new JButton("Tìm Kiếm");
		btnTK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timkiem tk = new timkiem();
				tk.setVisible(true);
			}
		});
		btnTK.setBounds(307, 111, 89, 23);
		contentPane.add(btnTK);
		
		tbCD = new JTable();
		tbCD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		tbCD.addMouseListener(new MouseListener() {
			
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
		tbCD.setBounds(20, 145, 513, 216);
		contentPane.add(tbCD);
	}
	public static void hienthi() {
		CDDVDdao ddao = new CDDVDdao();
		arrayList = ddao.docCD();
		DefaultTableModel dftbl = (DefaultTableModel)tbCD.getModel();
	    dftbl.setRowCount(0);
	    for(int i=0;i<arrayList.size(); i++)
	    {
	    	Vector<Object> vec = new Vector<>();
	        vec.add(arrayList.get(i).getMa());
	        vec.add(arrayList.get(i).getTieude());
	        vec.add(arrayList.get(i).getLoaidia());
	        vec.add(arrayList.get(i).getNam());
	        dftbl.addRow(vec);   
	    }
	}
	public static void vitriTable() {
		row = tbCD.getSelectedRow();
		if(row == -1) {
			return;
		}
	     CDDVD cd = arrayList.get(row);
	     textField_1.setText(cd.getTieude()); 
	     textField.setText(arrayList.get(row).getMa());
	     textField_2.setText(cd.getLoaidia());
	     textField_3.setText(String.valueOf(cd.getNam()));
	}
}
