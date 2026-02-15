import javax.swing.*;
import java.awt.event.*;

class FilePackerGUI
{
    public static void main(String A[])
    {
        JFrame fobj = new JFrame("Secure File Packer & Unpacker");

        fobj.setSize(500,400);
        fobj.setLayout(null);

        JLabel l1 = new JLabel("Folder Name:");
        l1.setBounds(50,50,120,30);
        fobj.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(180,50,200,30);
        fobj.add(t1);

        JLabel l2 = new JLabel("Packed File Name:");
        l2.setBounds(50,100,150,30);
        fobj.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(180,100,200,30);
        fobj.add(t2);

        JButton b1 = new JButton("Pack Files");
        b1.setBounds(100,170,120,40);
        fobj.add(b1);

        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String folder = t1.getText();
                    String packfile = t2.getText();

                    FilePacker.Pack(folder, packfile);

                    JOptionPane.showMessageDialog(fobj, "Packing Successful");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(fobj, "Error:"+ ex.getMessage());
                }
            }
        });

        JButton b2 = new JButton("Unpack Files");
        b2.setBounds(250,170,140,40);
        fobj.add(b2);

        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    String packfile = t2.getText();

                    ExtractedFiles.Unpack(packfile);

                    JOptionPane.showMessageDialog(fobj, "Unpacking Successful");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(fobj, "Error: "+ex.getMessage());
                }
            }
        });
        

        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fobj.setVisible(true);
    }
}