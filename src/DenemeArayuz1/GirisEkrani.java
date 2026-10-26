package DenemeArayuz1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GirisEkrani {
	public static void main(String[]args) {
					JFrame jf=new JFrame("GİRİŞ EKRANI");
					jf.setSize(800,800);//pencere boyutu
					jf.setLocation(200,200);//pencere konumu
					
					//Flowlayout yerine null kullanarak elemanları istediğimiz konuma koyuyoruzz
					jf.getContentPane().setLayout(null);
					
					
					//jf.getContentPane().setLayout(new FlowLayout());//bileşenlerin eklenme düzenini belirler
					//JTextField text1=new JTextField(20);// girilen değer genişliğinde metin giriş kutusu oluşturur
					
					
					//KULLANICI ADI ALMA KISMI
					JLabel label1=new JLabel();
					label1.setText("KULLANICI ADI GİRİNİZ:");
					label1.setBounds(30,30,200,25);//x koordinatı,y koordinatı,genişlik, yükseklik
					jf.getContentPane().add(label1);
					JTextField text1=new JTextField(20);
					text1.setBounds(30,60,300,25);
					jf.getContentPane().add(text1);
					
					//ŞİFRE ALMA KISMI
					//JTextField text2=new JTextField(35);// girilen değer genişliğinde metin giriş kutusu oluşturur
					JLabel label5=new JLabel();
					label5.setText("ŞİFRE: ");
					label5.setBounds(30,100,200,25);
					jf.getContentPane().add(label5);
					
					//ŞİFRE KUTUSUNA JPassWordField KULLANIMI
					JPasswordField text2=new JPasswordField(20);
					text2.setBounds(30, 130, 300, 25);
					jf.getContentPane().add(text2);
					
					//GİRİŞ BUTONU
					JButton buton1=new JButton("GİRİŞ");//gönder yazılı bir buton oluşturur
					buton1.setBounds(30,170,100,30);
					jf.getContentPane().add(buton1);
					
					//KAYIT OL BUTONU
					JButton buton2=new JButton("KAYIT OL");//gönder yazılı bir buton oluşturur
					buton2.setBounds(200,170,100,30);
					jf.getContentPane().add(buton2);
					buton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// Uyarı mesajı yerine doğrudan KayitEkrani'ni açıyoruz:
							new KayıtEkrani().setVisible(true);
					    }
					});
					
					//BUTONA TIKLANINCA NE OLACAK??
					buton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String kullaniciAdi=text1.getText();
							JOptionPane.showMessageDialog(null,"MERHABA"+kullaniciAdi);
						}
					});
					buton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null,"Kayıt Ekranına Yönlendiriliyorsunuz...");
						}
					});
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.setVisible(true);}}
					
					
					
					
			          