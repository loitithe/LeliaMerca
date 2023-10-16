import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Principal extends JFrame implements ActionListener {

    public Principal() {
        super("LeliaMerca");
        setLayout(new GridLayout());
        JButton btn_login = new JButton("Login");
        btn_login.addActionListener(this);
        add(btn_login);

        JButton btn_exit = new JButton("Exit ");
        btn_exit.addActionListener(this);
        add(btn_exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Login l = new Login(this);
        l.pack();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setSize(400, 200);
        l.setLocationRelativeTo(null);
        l.setVisible(true);
    }
}
