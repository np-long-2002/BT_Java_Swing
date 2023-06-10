package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CDDVDdao;
import model.CDDVD;

public class timkiem extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	private static JTable tbtk;
	private static ArrayList<CDDVD> arrayList;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public timkiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập dữ liệu cần tìm");
		lblNewLabel.setBounds(10, 11, 105, 14);
		contentPane.add(lblNewLabel);
		
		txttk = new JTextField();
		txttk.setBounds(125, 8, 218, 20);
		contentPane.add(txttk);
		txttk.setColumns(10);
		
		JButton btntkk = new JButton("Tìm Kiếm");
		btntkk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tuKhoa=txttk.getText();      
		        DefaultTableModel model =(DefaultTableModel)tbtk.getModel();
		        model.setRowCount(0);
		        if(!tuKhoa.equals("")){
		            ArrayList<CDDVD> dsDia=CDDVDdao.timKiemDia(tuKhoa);
		            if(dsDia.size()>0){
		            for(CDDVD dia:dsDia){
		            Object[] row={dia.getMa(),dia.getTieude(),dia.getLoaidia(),dia.getNam()};
		            model.addRow(row);}
		        }else {
		         JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu");
		        
		        }
		        }else{
		                JOptionPane.showMessageDialog(null,"Vui lòng nhập từ khóa");
		        }
			}
		});
		btntkk.setBounds(345, 7, 89, 23);
		contentPane.add(btntkk);
		
		tbtk = new JTable();
		tbtk.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		tbtk.setBounds(10, 52, 414, 198);
		hienthi();
		contentPane.add(tbtk);
	}
	public static void hienthi() {
		CDDVDdao ddao = new CDDVDdao();
		arrayList = ddao.docCD();
		DefaultTableModel dftbl = (DefaultTableModel)tbtk.getModel();
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

}
