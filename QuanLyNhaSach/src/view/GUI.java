package view;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class GUI {

	private JFrame frame;
	private static JMenuItem mniDN;
	private static JMenuItem mniDX;
	private static JMenuItem mniThoat;
	private static JMenuItem mniLoai;
	private static JMenuItem mniSach;
	private static JMenuItem mniHD;
	private static JMenuItem mniPN;
	private static JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		this.mniDX.setEnabled(false);
		this.mniHD.setEnabled(false);
		this.mniLoai.setEnabled(false);
		this.mniSach.setEnabled(false);
		this.mniHD.setEnabled(false);
		this.mniPN.setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 575, 408);
		frame.getContentPane().add(desktopPane);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("H\u1EC7 Th\u1ED1ng");
		menuBar.add(mnNewMenu);
		
		mniDN = new JMenuItem("\u0110\u0103ng Nh\u1EADp");
		mniDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDangNhap frmDangNhap = new frmDangNhap(frame, true);
				frmDangNhap.setVisible(true);
				if(frmDangNhap.isCheck()) {
					mniDX.setEnabled(true);
					mniHD.setEnabled(true);
					mniLoai.setEnabled(true);
					mniSach.setEnabled(true);
					mniHD.setEnabled(true);
					mniPN.setEnabled(true);
					mniDN.setEnabled(false);
				}
			}
		});
		mnNewMenu.add(mniDN);
		
		mniDX = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
		mniDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mniDX.setEnabled(false);
				mniHD.setEnabled(false);
				mniLoai.setEnabled(false);
				mniSach.setEnabled(false);
				mniHD.setEnabled(false);
				mniPN.setEnabled(false);
				mniDN.setEnabled(true);
			}
		});
		mnNewMenu.add(mniDX);
		
		mniThoat = new JMenuItem("Tho\u00E1t");
		mniThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mnNewMenu.add(mniThoat);
		
		JMenu mnNewMenu_1 = new JMenu("Qu\u1EA3n L\u00FD");
		menuBar.add(mnNewMenu_1);
		
		mniLoai = new JMenuItem("Lo\u1EA1i S\u00E1ch");
		mniLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				frmLoaiSach frmLoaiSach = new frmLoaiSach();
				frmLoaiSach.setVisible(true);
				desktopPane.add(frmLoaiSach);
			}
		});
		mnNewMenu_1.add(mniLoai);
		
		mniSach = new JMenuItem("S\u00E1ch");
		mniSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				desktopPane.removeAll();
				frmSach frmSach = new frmSach();
				frmSach.setVisible(true);
				desktopPane.add(frmSach);
			}
		});
		mnNewMenu_1.add(mniSach);
		
		mniHD = new JMenuItem("H\u00F3a \u0110\u01A1n");
		mniHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				desktopPane.removeAll();
				frmHoaDon frmHD = new frmHoaDon();
				frmHD.setVisible(true);
				desktopPane.add(frmHD);
			}
		});
		mnNewMenu_1.add(mniHD);
		
		mniPN = new JMenuItem("Phi\u1EBFu Nh\u1EADp S\u00E1ch");
		mniPN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				desktopPane.removeAll();
				frmPhieuNhapSach frmPNS = new frmPhieuNhapSach();
				frmPNS.setVisible(true);
				desktopPane.add(frmPNS);
			}
		});
		mnNewMenu_1.add(mniPN);
		
		JMenu mnNewMenu_2 = new JMenu("H\u01B0\u1EDBng D\u1EABn");
		menuBar.add(mnNewMenu_2);
	}
}
