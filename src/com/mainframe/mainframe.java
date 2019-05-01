package com.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class mainframe extends JFrame implements ActionListener{
	JLabel lbl_north,lbl_p_d,lbl_b_d,lbl_your_age,lbl_year,lbl_month,lbl_day;
	JTextField txt_p_d,txt_year,txt_month,txt_day;
	JButton btn_south;
	JDateChooser chooser;
	JPanel panel;
	GridBagLayout gl;
	GridBagConstraints gr;
	Font font=new Font("Serif",Font.PLAIN,40);
	Font font1=new Font("Serif", Font.PLAIN, 20);
	public mainframe() {
		init();
		cmp();
	}
	public void init() {
		setSize(700,350);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Age Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void cmp() {
		lbl_initialization();
		txt_initialization();
		btn_initialization();
		layout_initialization();
		date_initialization();
		this.add(lbl_north,BorderLayout.NORTH);
		panel=new JPanel();
		panel.setLayout(gl);
		p_c_work();
		this.add(panel,BorderLayout.CENTER);
		this.add(btn_south,BorderLayout.SOUTH);
	}
	public void date_initialization() {
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String sdate=format.format(date);
		txt_p_d.setText(sdate);
	}
	public void p_c_work() {
		GridBagLayoutWork(panel,lbl_p_d,0,0,5,5,5,5);
		GridBagLayoutWork(panel,txt_p_d,1,0,5,5,5,5);
		GridBagLayoutWork(panel,lbl_b_d,0,1,5,5,5,5);
		GridBagLayoutWork(panel,chooser,1,1,5,5,5,5);
		GridBagLayoutWork(panel,lbl_your_age,0,2,5,5,5,5);
		GridBagLayoutWork(panel,txt_year,0,3,5,5,5,5);
		GridBagLayoutWork(panel,txt_month,1,3,5,5,5,5);
		GridBagLayoutWork(panel,txt_day,2,3,5,5,5,5);
		GridBagLayoutWork(panel,lbl_year,0,4,5,5,5,5);
		GridBagLayoutWork(panel,lbl_month,1,4,5,5,5,5);
		GridBagLayoutWork(panel,lbl_day,2,4,5,5,5,5);
	}
	public void GridBagLayoutWork(JPanel panel,JComponent component,int x,int y,int p,int q,int r,int s) {
		gr.gridx=x;
		gr.gridy=y;
		gr.insets=new Insets(p, q, r, s);
		panel.add(component,gr);
	}
	public void layout_initialization() {
		gl=new GridBagLayout();
		gr=new GridBagConstraints();
	}
	public void lbl_initialization() {
		lbl_north=new JLabel("Age Calculator");
		lbl_north.setFont(font);
		lbl_north.setForeground(Color.RED);
		lbl_north.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl_p_d=new JLabel("Present Date");
		lbl_p_d.setFont(font1);
		
		lbl_b_d=new JLabel("Born Date");
		lbl_b_d.setFont(font1);
		
		lbl_your_age=new JLabel("Your Age Is");
		lbl_your_age.setForeground(Color.red);
		lbl_your_age.setFont(font1);
		
		lbl_year=new JLabel("Year ");
		lbl_year.setFont(font1);
		
		lbl_month=new JLabel("Month ");
		lbl_month.setFont(font1);
		
		lbl_day=new JLabel("Day ");
		lbl_day.setFont(font1);
	}
	public void txt_initialization() {
		txt_p_d=new JTextField();
		txt_p_d.setPreferredSize(new Dimension(160, 35));
		txt_p_d.setFont(font1);
		
		txt_year=new JTextField();
		txt_year.setPreferredSize(new Dimension(160, 35));
		txt_year.setFont(font1);
		
		txt_month=new JTextField();
		txt_month.setPreferredSize(new Dimension(160, 35));
		txt_month.setFont(font1);
		
		txt_day=new JTextField();
		txt_day.setPreferredSize(new Dimension(160, 35));
		txt_day.setFont(font1);
		
		chooser=new JDateChooser();
		chooser.setPreferredSize(new Dimension(160, 35));
		chooser.setFont(font1);
	}
	public void btn_initialization() {
		btn_south=new JButton("Age Calculate");
		btn_south.setFont(font1);
		btn_south.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Date date=chooser.getDate();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String b_d=format.format(date);
		String[] balldate=b_d.split("-");
		int b_year=Integer.parseInt(balldate[0]);
		int b_month=Integer.parseInt(balldate[1]);
		int b_day=Integer.parseInt(balldate[2]);
		
		String p_d=txt_p_d.getText().toString();
		String[] palldate=p_d.split("-");
		int p_year=Integer.parseInt(palldate[0]);
		int p_month=Integer.parseInt(palldate[1]);
		int p_day=Integer.parseInt(palldate[2]);
		
		int day=0,month=0,year=0;
		if(p_day<b_day) {
			day=(p_day+30)-b_day;
			p_month--;
			if(p_month<b_month) {
				month=(p_month+12)-b_month;
				p_year--;
			}else {
				month=p_month-b_month;
			}
			year=p_year-b_year;
		}else {
			day=p_day-b_day;
			if(p_month<b_month) {
				month=(p_month+12)-b_month;
				p_year--;
			}else {
				month=p_month-b_month;
			}
			year=p_year-b_year;
		}
		txt_year.setText(Integer.toString(year));
		txt_month.setText(Integer.toString(month));
		txt_day.setText(Integer.toString(day));
	}
}
