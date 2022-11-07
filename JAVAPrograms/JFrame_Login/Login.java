import java.util.*;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener
{
    HashMap<String,String> Logininfo = new HashMap<String,String>();
    JFrame frame = new JFrame();
    JFrame frame2 = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton createButton = new JButton("Create Account");
    JButton submit = new JButton("SUBMIT");
    JTextField userID = new JTextField();
    JPasswordField userPass = new JPasswordField();
    JLabel userIDLable = new JLabel("USER ID");
    JLabel userPasswordlable = new JLabel("USER PASSWORD");
    JLabel messageLabel = new JLabel("LOGIN PAGE");    
    JLabel lable = new JLabel("Account Successfully Created");
    public char[] get_Moderator;
    public char[] get_User;


    Login(HashMap<String,String> logininfoOriginal)
    {
        frame2.dispose();
        Logininfo = logininfoOriginal;

        userIDLable.setBounds(50,100,75,25);
        userPasswordlable.setBounds(50,150,75,25);
        
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userID.setBounds(125,100,200,25);
        userPass.setBounds(125,150,200,25);
        
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        createButton.setBounds(125,300,150,25);
        createButton.setFocusable(false);
        createButton.addActionListener(this);


        frame.add(userIDLable);
        frame.add(userPasswordlable);
        frame.add(messageLabel);
        frame.add(userID);
        frame.add(userPass);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(createButton);

      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == resetButton)
        {
            userID.setText("");
            userPass.setText("");
        }

        if(e.getSource() == loginButton)
        {
            String user = userID.getText();
            String pass = String.valueOf(userPass.getPassword());

            if(Logininfo.containsKey(user))
            {
                if(Logininfo.get(user).equals(pass))
                {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successfull");
                    Welcome a = new Welcome(Logininfo,frame);
                    a.activate();
                }
                else
                {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }
            else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("USER NOT FOUND");
            }
        }
        
        if(e.getSource() == createButton)
        {
            newaccount();
        }

        if(e.getSource() == submit)
        {
            Logininfo.put(userID.getText(),String.valueOf(userPass.getPassword()));
            lable.setForeground(Color.green);
            lable.setText("Account Created Successfully");
            
            frame.dispose();
            frame2.dispose();
            new Login(Logininfo);

        }
    }

    void newaccount()
    {
        lable.setBounds(125,220,200,50);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        lable.setText("Create a NEW ACCOUNT");

        userIDLable.setBounds(50,100,75,25);
        userPasswordlable.setBounds(50,150,75,25);
        
        userID.setBounds(125,100,200,25);
        userPass.setBounds(125,150,200,25);
        
        submit.setBounds(125,200,100,25);
        submit.setFocusable(false);
        submit.addActionListener(this);

        frame2.add(lable);
        frame2.add(userIDLable);
        frame2.add(userPasswordlable);
        frame2.add(userID);
        frame2.add(userPass);
        frame2.add(submit);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(420,420);
        frame2.setLayout(null);
        frame2.setVisible(true);

    }

    public boolean activate(HashMap<String, String> logininfo2) {
        return false;
    }

    public void set_Moderator(boolean b) {
    }

    public void set_Moderator() {
    }

    public void set_User() {
    }
}
