package Pencere;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CokluSuDalgasi extends JPanel implements ActionListener, MouseListener, KeyListener{

	Cember[] cemberler;
	int cemberMevcut= 0;
	int cemberEleman = 0;
	int cemberMax = 5;						//Maksimum çember miktarı sayısı
	int increase = 2;						//Artış miktarı daha hızlı hareket etmesi için
	Timer t; 								//Tüm class'ın timer'ı kullanabilmesi için constructor dışında tanımlanmalı

	public CokluSuDalgasi(){
			super();						//Class extend ettiği için costructor'da üst class'ı çağırmalıdır 
			
			addMouseListener(this);			//this = bulunduğu class'da harekete geçmesi için
			
			cemberler = new Cember[cemberMax]; 	//cemberMax sayısı kadar çember oluşturmayak için
			
			t = new Timer(40, this);
			t.start();						//t zaman parametresi her 40 ms'de 1 yineleyecek
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < cemberEleman; i++)
		{			
		cemberler[i].ekranaCiz(g);		//ÇEMBERLER SERİSİNİN İ. ELEMANINI Cember 									
		}								//CLASS'INDAKİ ekranaCiz METODUNU KULLANDIRMAK İÇİN
	}

	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i < cemberEleman; i++)
		{	
		cemberler[i].genisle(increase);
		}
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

		Cember yeniCember = new Cember(e.getX(), e.getY(), 0);
		
		cemberler [cemberMevcut] = yeniCember;					
		cemberMevcut = (cemberMevcut + 1) % cemberMax;		//Bölümünden kalanı eşitler,10 için 11. çember 1. olur; 12. 2...
		
		if(cemberEleman < cemberMax) {
			cemberEleman = cemberEleman + 1;
		}
	}
	public void mousePressed(MouseEvent e) {
/*
		if(cemberMevcut < cemberMax - 1) {
			
		
				Cember yeniCember = new Cember(e.getX(), e.getY(), 0); //Tıklanan yerin yeni oluşturulan çemberin merkezi için
				
		cemberler [cemberMevcut] = yeniCember;					//Yeni çemberin sayısı yeni eklenecek çemberin sıra sayısı
		cemberMevcut++;
		}*/
		}
	public void mouseReleased(MouseEvent e) {

	}	
	public void mouseEntered(MouseEvent e) {
		t.start();							//Mouse pencere içindeyken başlatır.					
	}
	public void mouseExited(MouseEvent e) {
		t.stop();							//Mouse pencere dışındayken durdurur.
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {

	//	System.out.println(e.getKeyCode());
		
		if(e.getKeyCode() == e.VK_UP) {
		increase++;	
		}
		else if(e.getKeyCode() == e.VK_DOWN) {
		increase--;	
		}		
	}
	public void keyReleased(KeyEvent e) {
	}
}