import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Main extends JFrame implements ActionListener {
    JLabel title = new JLabel();
    JButton home = new JButton("Home");
    JLabel homJLabel = new JLabel();
    JButton encode = new JButton("Encode Text");
    JButton decode = new JButton("Decode Text");
    JLabel encodeJLabel = new JLabel();
    JLabel decodeJLabel = new JLabel();
    JButton encryptImage = new JButton("Encrypt Image");
    JButton decryptImage = new JButton("Decrypt Image");
    JLabel aboutJLabel = new JLabel();
    JButton about = new JButton("About");
    JLabel aboutText = new JLabel();
    JLabel cR = new JLabel();
    Border border = BorderFactory.createMatteBorder(0, 5, 0, 0, Color.cyan);
    Border borderFull = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
    // ===========encode Text=============//
    JButton open = new JButton("Open");
    JButton embed = new JButton("Encode");
    JButton save = new JButton("Save");
    JButton reset = new JButton("Reset");
    JTextArea message = new JTextArea("Enter Your Message Here...");
    JLabel orgImg = new JLabel();
    JLabel encodedImg = new JLabel();
    BufferedImage sourceImage = null, embeddedImage = null;
    // ====================Decode Text=====================//
    JTextArea dmessage = new JTextArea();
    JLabel decImg = new JLabel();
    JButton dOpen = new JButton("Open");
    JButton dDecode = new JButton("Decode");
    JButton dReset = new JButton("Reset");
    BufferedImage image = null;
    // ==============Encrypt and Decrypt Image=============//
    JLabel encDecJLabel = new JLabel();
    JTextArea pass = new JTextArea();
    JLabel encDecImageView = new JLabel();
    JButton encDecOpen = new JButton("Open");
    JButton encDecStart = new JButton();
    JLabel encDecImageStatus = new JLabel();
    File encDecFile;
    File encDecImage;
    // ===================================================//

    public Main() {

        JLabel constJLabel = new JLabel();
        constJLabel.setOpaque(true);
        constJLabel.setBounds(0, 0, 260, 800);
        constJLabel.setBackground(Color.decode("#17202a"));
        title.setBounds(20, 30, 250, 100);
        title.setText("STEG HIDE");
        title.setForeground(Color.white);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ImageIcon icon = new ImageIcon("assets/search.png");
        Image ico = icon.getImage();
        Image iconScale = ico.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledicon = new ImageIcon(iconScale);
        title.setIcon(scaledicon);
        constJLabel.add(title);

        home.setBounds(0, 150, 260, 40);
        home.setBorder(border);
        home.setFocusable(false);
        home.setBackground(Color.darkGray);
        home.setForeground(Color.cyan);
        constJLabel.add(home);

        encode.setBounds(0, 250, 260, 40);
        encode.setBorder(null);
        encode.setFocusable(false);
        encode.setBackground(null);
        encode.setForeground(Color.white);
        constJLabel.add(encode);

        decode.setBounds(0, 350, 260, 40);
        decode.setBorder(null);
        decode.setFocusable(false);
        decode.setBackground(null);
        decode.setForeground(Color.white);
        constJLabel.add(decode);

        encryptImage.setBounds(0, 450, 260, 40);
        encryptImage.setBorder(null);
        encryptImage.setFocusable(false);
        encryptImage.setBackground(null);
        encryptImage.setForeground(Color.white);
        constJLabel.add(encryptImage);

        decryptImage.setBounds(0, 550, 260, 40);
        decryptImage.setBorder(null);
        decryptImage.setFocusable(false);
        decryptImage.setBackground(null);
        decryptImage.setForeground(Color.white);
        constJLabel.add(decryptImage);

        about.setBounds(0, 650, 260, 40);
        about.setBorder(null);
        about.setFocusable(false);
        about.setBackground(null);
        about.setForeground(Color.white);
        constJLabel.add(about);

        cR.setBounds(0, 700, 260, 60);
        cR.setForeground(Color.gray);
        cR.setText(
                "<html><center><h5>Copyright © 2021 StegHide, All rights reserved. Created By Vishnu Prasad N</h5></center></html>");
        constJLabel.add(cR);

        homJLabel.setOpaque(true);
        homJLabel.setBackground(Color.WHITE);
        homJLabel.setBounds(260, 0, 1130, 800);
        ImageIcon image = new ImageIcon("assets/background.jpg");
        Image img = image.getImage();
        Image imageScale = img.getScaledInstance(homJLabel.getWidth(), homJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imageScale);
        homJLabel.setIcon(scaledIcon);
        homJLabel.setVisible(true);

        encodeJLabel.setOpaque(true);
        encodeJLabel.setBackground(Color.decode("#202020"));
        encodeJLabel.setBounds(260, 0, 1130, 800);
        message.setBounds(5, 5, 1120, 300);
        message.setFont(new Font("monospaced", Font.BOLD, 13));
        message.setLineWrap(true);
        encodeJLabel.add(message);
        encodeJLabel.setVisible(false);
        orgImg.setOpaque(true);
        orgImg.setBackground(Color.white);
        orgImg.setBounds(5, 310, 555, 390);
        JLabel orgStatus = new JLabel("ORGINAL IMAGE");
        orgStatus.setOpaque(true);
        orgStatus.setBounds(0, 0, 130, 20);
        orgStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
        orgStatus.setHorizontalAlignment(JLabel.CENTER);
        orgImg.add(orgStatus);

        encodeJLabel.add(orgImg);
        encodedImg.setOpaque(true);
        encodedImg.setBackground(Color.white);
        encodedImg.setBounds(565, 310, 558, 390);
        JLabel encStatus = new JLabel("STEGNOGRAPHED IMAGE");
        encStatus.setOpaque(true);
        encStatus.setBounds(0, 0, 190, 20);
        encStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
        encStatus.setHorizontalAlignment(JLabel.CENTER);
        encodedImg.add(encStatus);
        encodeJLabel.add(encodedImg);
        open.setBounds(5, 720, 100, 40);
        open.setFocusable(false);
        open.setBackground(null);
        open.setForeground(Color.white);
        open.setBorder(borderFull);
        encodeJLabel.add(open);
        embed.setBounds(110, 720, 100, 40);
        embed.setFocusable(false);
        embed.setBackground(null);
        embed.setForeground(Color.white);
        embed.setBorder(borderFull);
        encodeJLabel.add(embed);
        save.setBounds(920, 720, 100, 40);
        save.setFocusable(false);
        save.setBackground(null);
        save.setForeground(Color.white);
        save.setBorder(borderFull);
        encodeJLabel.add(save);
        reset.setBounds(1025, 720, 100, 40);
        reset.setFocusable(false);
        reset.setBackground(null);
        reset.setForeground(Color.white);
        reset.setBorder(borderFull);
        encodeJLabel.add(reset);

        decodeJLabel.setOpaque(true);
        decodeJLabel.setBackground(Color.decode("#202020"));
        decodeJLabel.setBounds(260, 0, 1130, 800);
        decodeJLabel.setVisible(false);

        decImg.setBounds(5, 5, 1120, 450);
        decImg.setOpaque(true);
        decImg.setBackground(Color.white);
        JLabel decStatus = new JLabel("EMBEDDED IMAGE");
        decStatus.setOpaque(true);
        decStatus.setBounds(0, 0, 130, 20);
        decStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
        decStatus.setHorizontalAlignment(JLabel.CENTER);
        decImg.add(decStatus);
        decodeJLabel.add(decImg);
        dmessage.setBounds(5, 460, 1120, 250);
        dmessage.setEditable(false);
        dmessage.setFont(new Font("Monospaces", Font.BOLD, 13));
        decodeJLabel.add(dmessage);

        dOpen.setBounds(5, 725, 100, 35);
        dOpen.setFocusable(false);
        dOpen.setBackground(null);
        dOpen.setForeground(Color.white);
        dOpen.setBorder(borderFull);
        decodeJLabel.add(dOpen);

        dDecode.setBounds(120, 725, 100, 35);
        dDecode.setFocusable(false);
        dDecode.setBackground(null);
        dDecode.setForeground(Color.white);
        dDecode.setBorder(borderFull);
        decodeJLabel.add(dDecode);

        dReset.setBounds(235, 725, 100, 35);
        dReset.setFocusable(false);
        dReset.setBackground(null);
        dReset.setForeground(Color.white);
        dReset.setBorder(borderFull);
        decodeJLabel.add(dReset);

        encDecJLabel.setBounds(260, 0, 1130, 800);
        encDecJLabel.setOpaque(true);
        encDecJLabel.setBackground(Color.decode("#202020"));
        encDecJLabel.setVisible(false);

        pass.setBounds(5, 5, 1120, 200);
        encDecJLabel.add(pass);

        encDecImageView.setBounds(5, 210, 1120, 500);
        encDecImageView.setOpaque(true);
        encDecImageView.setBackground(Color.white);
        encDecJLabel.add(encDecImageView);

        encDecImageStatus.setBounds(0, 0, 130, 30);
        encDecImageStatus.setOpaque(true);
        encDecImageStatus.setHorizontalAlignment(JLabel.CENTER);
        encDecImageView.add(encDecImageStatus);

        encDecOpen.setBounds(5, 720, 100, 40);
        encDecOpen.setFocusable(false);
        encDecOpen.setBackground(null);
        encDecOpen.setForeground(Color.white);
        encDecOpen.setBorder(borderFull);
        encDecJLabel.add(encDecOpen);

        encDecStart.setBounds(120, 720, 100, 40);
        encDecStart.setFocusable(false);
        encDecStart.setBackground(null);
        encDecStart.setForeground(Color.white);
        encDecStart.setBorder(borderFull);
        encDecJLabel.add(encDecStart);

        aboutJLabel.setOpaque(true);
        aboutJLabel.setBackground(Color.white);
        aboutJLabel.setBounds(260, 0, 1130, 800);
        aboutJLabel.setVisible(true);
        aboutText.setBounds(10, 20, 1110, 560);
        aboutText.setVerticalAlignment(JLabel.TOP);

        aboutText.setText(
                "<html><h1>What is steganography?</h1><br><p>Steganography is the technique of hiding secret data within an ordinary, non-secret, file or message in order to avoid detection; the secret data is then extracted at its destination. The use of steganography can be combined with encryption as an extra step for hiding or protecting data. The word steganography is derived from the Greek words steganos (meaning hidden or covered) and the Greek root graph (meaning to write)</p><p>Steganography can be used to conceal almost any type of digital content, including text, image, video or audio content; the data to be hidden can be hidden inside almost any other type of digital content. The content to be concealed through steganography -- called hidden text -- is often encrypted before being incorporated into the innocuous-seeming cover text file or data stream. If not encrypted, the hidden text is commonly processed in some way in order to increase the difficulty of detecting the secret content</p><br><br><h1>What is image stgnography?</h1><br><p>Image steganography refers to hiding information i.e. text, images or audio files in another image or video files. The current project aims to use steganography for an image with another image using spatial domain technique. This hidden information can be retrieved only through proper decoding technique.</p><br><br><h1>What is LSB</h1><br><p>Least Significant bit also called RightMost Bit is a lowest bit of a binary number. For example in binary number 10010010, 0 is the least significant bit.</p><br<br><h1>What is LSB-Steganography</h1><br><p>LSB-Steganography is a steganography technique in which we hide messages inside an image by replacing Least significant bit of image with the bits of message to be hidden. By modifying only the first most right bit of an image we can insert our secret message and it also make the picture unnoticeable, but if our message is too large it will start modifying the second right most bit and so on and an attacker can notice the changes in picture. </p></html>");
        aboutText.setVisible(false);
        aboutJLabel.add(aboutText);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1400, 800);
        layeredPane.add(constJLabel);
        layeredPane.add(homJLabel);
        layeredPane.add(encodeJLabel);
        layeredPane.add(decodeJLabel);
        layeredPane.add(encDecJLabel);
        layeredPane.add(aboutJLabel);

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(1390, 800);
        frame.setTitle("STEG HIDE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(layeredPane);
        home.addActionListener(this);
        encode.addActionListener(this);
        decode.addActionListener(this);
        encryptImage.addActionListener(this);
        decryptImage.addActionListener(this);
        about.addActionListener(this);
        open.addActionListener(this);
        embed.addActionListener(this);
        save.addActionListener(this);
        reset.addActionListener(this);
        dOpen.addActionListener(this);
        dDecode.addActionListener(this);
        dReset.addActionListener(this);
        encDecOpen.addActionListener(this);
        encDecStart.addActionListener(this);
        frame.setResizable(false);
    }

    private void homeJLabelOpen() {
        homJLabel.setVisible(true);
        encodeJLabel.setVisible(false);
        decodeJLabel.setVisible(false);
        encDecJLabel.setVisible(false);
        aboutJLabel.setVisible(false);
        aboutText.setVisible(false);
        encode.setBorder(null);
        encode.setBackground(null);
        decode.setBorder(null);
        decode.setBackground(null);
        encryptImage.setBorder(null);
        encryptImage.setBackground(null);
        decryptImage.setBorder(null);
        decryptImage.setBackground(null);
        about.setBorder(null);
        about.setBackground(null);
        orgImg.setIcon(null);
        encodedImg.setIcon(null);
        decImg.setIcon(null);
        home.setBorder(border);
        home.setBackground(Color.darkGray);

        encode.setForeground(Color.white);
        decode.setForeground(Color.white);
        encryptImage.setForeground(Color.white);
        decryptImage.setForeground(Color.white);
        about.setForeground(Color.white);
        home.setForeground(Color.cyan);
    }

    private void encodeJLabelOpen() {
        homJLabel.setVisible(false);
        encodeJLabel.setVisible(true);
        decodeJLabel.setVisible(false);
        encDecJLabel.setVisible(false);
        aboutJLabel.setVisible(false);
        aboutText.setVisible(false);
        home.setBorder(null);
        home.setBackground(null);
        decode.setBorder(null);
        decode.setBackground(null);
        encryptImage.setBorder(null);
        encryptImage.setBackground(null);
        decryptImage.setBorder(null);
        decryptImage.setBackground(null);
        about.setBorder(null);
        about.setBackground(null);
        orgImg.setIcon(null);
        encodedImg.setIcon(null);
        decImg.setIcon(null);
        encode.setBorder(border);
        encode.setBackground(Color.darkGray);

        home.setForeground(Color.white);
        decode.setForeground(Color.white);
        encryptImage.setForeground(Color.white);
        decryptImage.setForeground(Color.white);
        about.setForeground(Color.white);
        encode.setForeground(Color.cyan);

    }

    private void decodeJLabelOpen() {
        aboutText.setVisible(false);
        aboutJLabel.setVisible(false);
        homJLabel.setVisible(false);
        encodeJLabel.setVisible(false);
        encDecJLabel.setVisible(false);
        decodeJLabel.setVisible(true);
        home.setBorder(null);
        home.setBackground(null);
        encode.setBorder(null);
        encode.setBackground(null);
        encryptImage.setBorder(null);
        encryptImage.setBackground(null);
        decryptImage.setBorder(null);
        decryptImage.setBackground(null);
        about.setBorder(null);
        about.setBackground(null);
        orgImg.setIcon(null);
        encodedImg.setIcon(null);
        decImg.setIcon(null);
        decode.setBorder(border);
        decode.setBackground(Color.darkGray);

        home.setForeground(Color.white);
        encode.setForeground(Color.white);
        encryptImage.setForeground(Color.white);
        decryptImage.setForeground(Color.white);
        about.setForeground(Color.white);
        decode.setForeground(Color.cyan);
    }

    private void encImageJLabelOpen() {
        aboutText.setVisible(false);
        aboutJLabel.setVisible(false);
        homJLabel.setVisible(false);
        encodeJLabel.setVisible(false);
        decodeJLabel.setVisible(false);
        encDecJLabel.setVisible(true);
        encDecStart.setText("Encrypt");
        pass.setText("Enter Key For Image Encryption Ex: 1234");
        encDecImageView.setIcon(null);
        encDecImageStatus.setText("Orginal Image");
        decImg.setIcon(null);
        home.setBorder(null);
        home.setBackground(null);
        encode.setBorder(null);
        encode.setBackground(null);
        decode.setBorder(null);
        decode.setBackground(null);
        about.setBorder(null);
        about.setBackground(null);
        decryptImage.setBorder(null);
        decryptImage.setBackground(null);
        encryptImage.setBorder(border);
        encryptImage.setBackground(Color.darkGray);
        home.setForeground(Color.white);
        encode.setForeground(Color.white);
        decode.setForeground(Color.white);
        decryptImage.setForeground(Color.white);
        about.setForeground(Color.white);
        encryptImage.setForeground(Color.cyan);
    }

    private void decImageJLabelOpen() {
        aboutText.setVisible(false);
        aboutJLabel.setVisible(false);
        homJLabel.setVisible(false);
        encodeJLabel.setVisible(false);
        decodeJLabel.setVisible(false);
        encDecJLabel.setVisible(true);
        encDecStart.setText("Decrypt");
        pass.setText("Enter Key For Image Decryption Ex: 1234 ");
        encDecImageStatus.setText("Decrypted Image");
        encDecImageView.setIcon(null);
        orgImg.setIcon(null);
        encodedImg.setIcon(null);
        home.setBorder(null);
        home.setBackground(null);
        encode.setBorder(null);
        encode.setBackground(null);
        decode.setBorder(null);
        decode.setBackground(null);
        encryptImage.setBorder(null);
        encryptImage.setBackground(null);
        about.setBorder(null);
        about.setBackground(null);
        decryptImage.setBorder(border);
        decryptImage.setBackground(Color.darkGray);

        home.setForeground(Color.white);
        encode.setForeground(Color.white);
        decode.setForeground(Color.white);
        encryptImage.setForeground(Color.white);
        about.setForeground(Color.white);
        decryptImage.setForeground(Color.cyan);

    }

    private void aboutJLabelOpen() {
        homJLabel.setVisible(false);
        encodeJLabel.setVisible(false);
        decodeJLabel.setVisible(false);
        encDecJLabel.setVisible(false);
        aboutJLabel.setVisible(true);
        aboutText.setVisible(true);
        home.setBorder(null);
        home.setBackground(null);
        encode.setBorder(null);
        encode.setBackground(null);
        decode.setBorder(null);
        decode.setBackground(null);
        encryptImage.setBorder(null);
        encryptImage.setBackground(null);
        decryptImage.setBorder(null);
        decryptImage.setBackground(null);
        about.setBorder(border);
        about.setBackground(Color.DARK_GRAY);

        home.setForeground(Color.white);
        encode.setForeground(Color.white);
        decode.setForeground(Color.white);
        encryptImage.setForeground(Color.white);
        decryptImage.setForeground(Color.white);
        about.setForeground(Color.cyan);
    }

    // ==================Encode Text============//
    private java.io.File showFileDialog(final boolean open) {
        JFileChooser fc = new JFileChooser("Open an image");
        javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
            public boolean accept(java.io.File f) {
                String name = f.getName().toLowerCase();
                if (open)
                    return f.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")
                            || name.endsWith(".gif") || name.endsWith(".tiff") || name.endsWith(".bmp")
                            || name.endsWith(".dib");
                return f.isDirectory() || name.endsWith(".png") || name.endsWith(".bmp");
            }

            public String getDescription() {
                if (open)
                    return "Image (*.jpg, *.jpeg, *.png, *.gif, *.tiff, *.bmp, *.dib)";
                return "Image (*.png, *.bmp)";
            }
        };
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(ff);

        java.io.File f = null;
        if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            f = fc.getSelectedFile();
        else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            f = fc.getSelectedFile();
        return f;
    }

    private void openImage() {
        java.io.File f = showFileDialog(true);
        try {
            sourceImage = ImageIO.read(f);
            ImageIcon image = new ImageIcon(sourceImage);
            Image img = image.getImage();
            Image imageScale = img.getScaledInstance(orgImg.getWidth(), orgImg.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imageScale);
            orgImg.setIcon(scaledIcon);
            this.validate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void embedMessage() {
        String mess = message.getText();
        embeddedImage = sourceImage.getSubimage(0, 0, sourceImage.getWidth(), sourceImage.getHeight());
        embedMessage(embeddedImage, mess);
        ImageIcon image = new ImageIcon(embeddedImage);
        Image img = image.getImage();
        Image imageScale = img.getScaledInstance(encodedImg.getWidth(), encodedImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imageScale);
        encodedImg.setIcon(scaledIcon);
        this.validate();
    }

    private void embedMessage(BufferedImage img, String mess) {
        int messageLength = mess.length();

        int imageWidth = img.getWidth(), imageHeight = img.getHeight(), imageSize = imageWidth * imageHeight;
        if (messageLength * 8 + 32 > imageSize) {
            JOptionPane.showMessageDialog(this, "Message is too long for the chosen image", "Message too long!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        embedInteger(img, messageLength, 0, 0);

        byte b[] = mess.getBytes();
        for (int i = 0; i < b.length; i++)
            embedByte(img, b[i], i * 8 + 32, 0);
    }

    private void embedInteger(BufferedImage img, int n, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(), startX = start / maxY, startY = start - startX * maxY,
                count = 0;
        for (int i = startX; i < maxX && count < 32; i++) {
            for (int j = startY; j < maxY && count < 32; j++) {
                int rgb = img.getRGB(i, j), bit = getBitValue(n, count);
                rgb = setBitValue(rgb, storageBit, bit);
                img.setRGB(i, j, rgb);
                count++;
            }
        }
    }

    private void embedByte(BufferedImage img, byte b, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(), startX = start / maxY, startY = start - startX * maxY,
                count = 0;
        for (int i = startX; i < maxX && count < 8; i++) {
            for (int j = startY; j < maxY && count < 8; j++) {
                int rgb = img.getRGB(i, j), bit = getBitValue(b, count);
                rgb = setBitValue(rgb, storageBit, bit);
                img.setRGB(i, j, rgb);
                count++;
            }
        }
    }

    private void saveImage() {
        if (embeddedImage == null) {
            JOptionPane.showMessageDialog(this, "No message has been embedded!", "Nothing to save",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        java.io.File f = showFileDialog(false);
        String name = f.getName();
        String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        if (!ext.equals("png") && !ext.equals("bmp") && !ext.equals("dib")) {
            ext = "png";
            f = new java.io.File(f.getAbsolutePath() + ".png");
        }
        try {
            if (f.exists())
                f.delete();
            ImageIO.write(embeddedImage, ext.toUpperCase(), f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int getBitValue(int n, int location) {
        int v = n & (int) Math.round(Math.pow(2, location));
        return v == 0 ? 0 : 1;
    }

    private int setBitValue(int n, int location, int bit) {
        int toggle = (int) Math.pow(2, location), bv = getBitValue(n, location);
        if (bv == bit)
            return n;
        if (bv == 0 && bit == 1)
            n |= toggle;
        else if (bv == 1 && bit == 0)
            n ^= toggle;
        return n;
    }

    private void encReset() {
        message.setText(null);
        orgImg.setIcon(null);
        encodedImg.setIcon(null);
    }

    private void decReset() {
        dmessage.setText(null);
        decImg.setIcon(null);
    }

    // ======================================================================================================//
    private java.io.File showdFileDialog(boolean open) {
        JFileChooser fc = new JFileChooser("Open an image");
        javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
            public boolean accept(java.io.File f) {
                String name = f.getName().toLowerCase();
                return f.isDirectory() || name.endsWith(".png") || name.endsWith(".bmp");
            }

            public String getDescription() {
                return "Image (*.png, *.bmp)";
            }
        };
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(ff);

        java.io.File f = null;
        if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            f = fc.getSelectedFile();
        else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            f = fc.getSelectedFile();
        return f;
    }

    private void dOpenImage() {
        java.io.File f = showdFileDialog(true);
        try {
            image = ImageIO.read(f);

            ImageIcon dImage = new ImageIcon(image);
            Image img = dImage.getImage();
            Image imageScale = img.getScaledInstance(decImg.getWidth(), decImg.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imageScale);
            decImg.setIcon(scaledIcon);
            // JLabel l = new JLabel(new ImageIcon(image));
            this.validate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void decodeMessage() {
        int len = extractInteger(image, 0, 0);
        byte b[] = new byte[len];
        for (int i = 0; i < len; i++)
            b[i] = extractByte(image, i * 8 + 32, 0);
        dmessage.setText(new String(b));
    }

    private int extractInteger(BufferedImage img, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(), startX = start / maxY, startY = start - startX * maxY,
                count = 0;
        int length = 0;
        for (int i = startX; i < maxX && count < 32; i++) {
            for (int j = startY; j < maxY && count < 32; j++) {
                int rgb = img.getRGB(i, j), bit = getBitValue(rgb, storageBit);
                length = setBitValue(length, count, bit);
                count++;
            }
        }
        return length;
    }

    private byte extractByte(BufferedImage img, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(), startX = start / maxY, startY = start - startX * maxY,
                count = 0;
        byte b = 0;
        for (int i = startX; i < maxX && count < 8; i++) {
            for (int j = startY; j < maxY && count < 8; j++) {
                int rgb = img.getRGB(i, j), bit = dgetBitValue(rgb, storageBit);
                b = (byte) dsetBitValue(b, count, bit);
                count++;
            }
        }
        return b;
    }

    private int dgetBitValue(int n, int location) {
        int v = n & (int) Math.round(Math.pow(2, location));
        return v == 0 ? 0 : 1;
    }

    private int dsetBitValue(int n, int location, int bit) {
        int toggle = (int) Math.pow(2, location), bv = dgetBitValue(n, location);
        if (bv == bit)
            return n;
        if (bv == 0 && bit == 1)
            n |= toggle;
        else if (bv == 1 && bit == 0)
            n ^= toggle;
        return n;
    }

    // ===================ENcrypt Image =======================================//
    private void encDecFileOpen() {
        JFileChooser encDecFilechooser = new JFileChooser();
        encDecFilechooser.showOpenDialog(null);
        encDecFile = encDecFilechooser.getSelectedFile();

        ImageIcon image = new ImageIcon(encDecFile.toString());
        Image img = image.getImage();
        Image imageScale = img.getScaledInstance(encDecImageView.getWidth(), encDecImageView.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imageScale);
        encDecImageView.setIcon(scaledIcon);
    }

    private void encDecFileCrypt() {
        String encDecPass = pass.getText();
        int etemp = Integer.parseInt(encDecPass);
        int encDecKey = etemp;
        try {
            FileInputStream encDecFis = new FileInputStream(encDecFile);
            byte[] data = new byte[encDecFis.available()];
            encDecFis.read(data);
            int i = 0;
            for (byte b : data) {
                // System.out.println(b);
                data[i] = (byte) (b ^ encDecKey);
                i++;
            }

            FileOutputStream encDecFos = new FileOutputStream(encDecFile);
            encDecFos.write(data);
            encDecFos.close();
            encDecFis.close();
            JOptionPane.showMessageDialog(null, "Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (encDecImage == null) {
            encDecImage = encDecFile;
            break;
        }
        try {
            Thread.sleep(1000);
            ImageIcon image = new ImageIcon(encDecImage.toString());
            Image img = image.getImage();
            Image imageScale = img.getScaledInstance(encDecImageView.getWidth(), encDecImageView.getHeight(),
                    Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imageScale);
            encDecImageView.setIcon(scaledIcon);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ========================================================================//
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == home)
            homeJLabelOpen();
        else if (o == encode)
            encodeJLabelOpen();
        else if (o == decode)
            decodeJLabelOpen();
        else if (o == encryptImage)
            encImageJLabelOpen();
        else if (o == decryptImage)
            decImageJLabelOpen();
        else if (o == open)
            openImage();
        else if (o == embed)
            embedMessage();
        else if (o == save)
            saveImage();
        else if (o == reset)
            encReset();
        else if (o == dOpen)
            dOpenImage();
        else if (o == dDecode)
            decodeMessage();
        else if (o == dReset)
            decReset();
        else if (o == encDecOpen)
            encDecFileOpen();
        else if (o == encDecStart)
            encDecFileCrypt();
        else if (o == about)
            aboutJLabelOpen();
    }

    public static void main(String[] args) {
        new Main();
    }
}
