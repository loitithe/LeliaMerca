import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulario secundario para iniciar sesion
 */

public class Login extends JDialog implements ActionListener {
    private static JLabel label_password, label_username;
    private static JTextField jtextfield_username;
    private static JButton btn_login, btn_exit;
    private static JPasswordField Password;

    JPanel panel;

    public Login(Principal principal) {
        super(principal);
        setLayout(new GridLayout(4, 3));
        setTitle("Login");

        label_password = new JLabel("Password");
        this.add(label_password);

        jtextfield_username = new JTextField("Nombre de usuario");
        this.add(jtextfield_username);

        label_username = new JLabel("Username");
        this.add(label_username);

        Password = new JPasswordField();
        this.add(Password);

        btn_login = new JButton("Login");
        this.add(btn_login);

        btn_exit = new JButton("Salir ");
        this.add(btn_exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Principal f = (Principal) this.getOwner();

    }

}
