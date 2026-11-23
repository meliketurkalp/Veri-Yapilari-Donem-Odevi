package DenemeArayuz1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GirisEkrani {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame jf = new JFrame("GİRİŞ EKRANI");
                jf.setSize(800, 800);
                jf.setLocation(200, 200);
                jf.getContentPane().setLayout(null);

                // KULLANICI ADI
                JLabel label1 = new JLabel("KULLANICI ADI GİRİNİZ:");
                label1.setBounds(30, 30, 200, 25);
                jf.getContentPane().add(label1);

                JTextField text1 = new JTextField(20);
                text1.setBounds(30, 60, 300, 25);
                jf.getContentPane().add(text1);

                // ŞİFRE
                JLabel label5 = new JLabel("ŞİFRE: ");
                label5.setBounds(30, 100, 200, 25);
                jf.getContentPane().add(label5);

                JPasswordField text2 = new JPasswordField(20);
                text2.setBounds(30, 130, 300, 25);
                jf.getContentPane().add(text2);

                // GİRİŞ BUTONU
                JButton buton1 = new JButton("GİRİŞ");
                buton1.setBounds(30, 170, 100, 30);
                jf.getContentPane().add(buton1);

                // KAYIT OL BUTONU
                JButton buton2 = new JButton("KAYIT OL");
                buton2.setBounds(200, 170, 100, 30);
                jf.getContentPane().add(buton2);

                // KAYIT OL: kayıt ekranını açar
                buton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new KayitEkrani().setVisible(true);
                    }
                });

                // GİRİŞ: dosyadan kontrol eder, role göre panel açar
                buton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String kullaniciAdi = text1.getText().trim();
                        String sifre = new String(text2.getPassword()).trim();

                        if (kullaniciAdi.isEmpty() || sifre.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Kullanıcı adı ve şifre boş bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String rol = girisKontrol(kullaniciAdi, sifre);

                        if (rol == null) {
                            JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı!", "Hata", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        jf.dispose(); // giriş ekranını kapat
                        if (rol.equals("Yönetici")) {
                        	JOptionPane.showMessageDialog(null, "Yönetici paneline giriş başarılı!");
                        } else {
                        	JOptionPane.showMessageDialog(null, "Öğranci paneline giriş başarılı!");
                        }
                    }
                });

                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.setVisible(true);
            }
        });
    }

    // kullanicilar.txt dosyasında kullanıcıyı arar, bulursa rolünü döndürür
    private static String girisKontrol(String kAdi, String sifre) {
        try (BufferedReader br = new BufferedReader(new FileReader("kullanicilar.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] p = satir.split(":");
                if (p.length == 3 && p[0].equals(kAdi) && p[1].equals(sifre)) {
                    return p[2];
                }
            }
        } catch (IOException ex) {
            // dosya yoksa hiç kayıt yok demektir
        }
        return null;
    }
}
