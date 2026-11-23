package DenemeArayuz1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class KayitEkrani extends JFrame {
    private JTextField txtKullaniciAdi;
    private JPasswordField txtSifre;
    private JComboBox<String> cmbRol;

    public KayitEkrani() {
        setTitle("METADS - Yeni Kullanıcı Kaydı");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı:");
        lblKullaniciAdi.setBounds(50, 50, 100, 25);
        getContentPane().add(lblKullaniciAdi);

        txtKullaniciAdi = new JTextField();
        txtKullaniciAdi.setBounds(150, 50, 160, 25);
        getContentPane().add(txtKullaniciAdi);

        JLabel lblSifre = new JLabel("Şifre:");
        lblSifre.setBounds(50, 100, 100, 25);
        getContentPane().add(lblSifre);

        txtSifre = new JPasswordField();
        txtSifre.setBounds(150, 100, 160, 25);
        getContentPane().add(txtSifre);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(50, 150, 100, 25);
        getContentPane().add(lblRol);

        String[] roller = { "Öğrenci", "Yönetici" };
        cmbRol = new JComboBox<>(roller);
        cmbRol.setBounds(150, 150, 160, 25);
        getContentPane().add(cmbRol);

        JButton btnKayitOl = new JButton("Kayıt Ol");
        btnKayitOl.setBounds(150, 200, 160, 30);
        getContentPane().add(btnKayitOl);

        btnKayitOl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kAdi = txtKullaniciAdi.getText().trim();
                String sifre = new String(txtSifre.getPassword()).trim();
                String rol = (String) cmbRol.getSelectedItem();

                if (kAdi.isEmpty() || sifre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı ve şifre boş bırakılamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (kAdi.contains(":") || sifre.contains(":")) {
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı ve şifre ':' içeremez!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (kullaniciVarMi(kAdi)) {
                    JOptionPane.showMessageDialog(null, "Bu kullanıcı adı zaten alınmış!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (PrintWriter out = new PrintWriter(new FileWriter("kullanicilar.txt", true))) {
                    out.println(kAdi + ":" + sifre + ":" + rol);
                    JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Oluşturuldu: " + kAdi);
                    dispose();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Dosya kaydedilirken hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }

    // Aynı kullanıcı adı daha önce kaydedilmiş mi?
    private boolean kullaniciVarMi(String kAdi) {
        try (BufferedReader br = new BufferedReader(new FileReader("kullanicilar.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                if (satir.split(":")[0].equals(kAdi)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            // dosya yoksa kullanıcı da yok
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KayitEkrani().setVisible(true);
        });
    }
}
