//EmbedMessage.java
 import java.awt.image.*;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.imageio.*;
  public class Embed extends JFrame implements ActionListener
 {
 JButton open = new JButton("Open"), embed = new JButton("Embed"),
    save = new JButton("Save into new file"), reset = new JButton("Reset");
 JTextArea message = new JTextArea(10,3);
 BufferedImage sourceImage = null, embeddedImage = null;
 JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
 JScrollPane originalPane = new JScrollPane(),
    embeddedPane = new JScrollPane();
  public Embed() {
    super("Embed stegonographic message in image");
    assembleInterface();
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
    this.setVisible(true);
    sp.setDividerLocation(0.5);
    this.validate();
    }
 private void assembleInterface() {
    JPanel p = new JPanel(new FlowLayout());
    p.add(open);
    p.add(embed);
    p.add(save);   
    p.add(reset);
    this.getContentPane().add(p, BorderLayout.SOUTH);
    open.addActionListener(this);
    embed.addActionListener(this);
   save.addActionListener(this);   
    reset.addActionListener(this);
    open.setMnemonic('O');
    embed.setMnemonic('E');
    save.setMnemonic('S');
    reset.setMnemonic('R');
    p = new JPanel(new GridLayout(1,1));
    p.add(new JScrollPane(message));
    message.setFont(new Font("Arial",Font.BOLD,20));
    p.setBorder(BorderFactory.createTitledBorder("Message to be embedded"));
    this.getContentPane().add(p, BorderLayout.NORTH);
    sp.setLeftComponent(originalPane);
    sp.setRightComponent(embeddedPane);
    originalPane.setBorder(BorderFactory.createTitledBorder("Original Image"));
    embeddedPane.setBorder(BorderFactory.createTitledBorder("Steganographed Image"));
    this.getContentPane().add(sp, BorderLayout.CENTER);
    }
 
 public void actionPerformed(ActionEvent ae) {
    Object o = ae.getSource();
    if(o == open)
       openImage();
    else if(o == embed)
       embedMessage();
    else if(o == save) 
       saveImage();
    else if(o == reset) 
       resetInterface();
    }
 
 private java.io.File showFileDialog(final boolean open) {
    JFileChooser fc = new JFileChooser("Open an image");
    javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
       public boolean accept(java.io.File f) {
          String name = f.getName().toLowerCase();
          if(open)
             return f.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") ||
                name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".tiff") ||
                name.endsWith(".bmp") || name.endsWith(".dib");
          return f.isDirectory() || name.endsWith(".png") ||    name.endsWith(".bmp");
          }
       public String getDescription() {
          if(open)
             return "Image (*.jpg, *.jpeg, *.png, *.gif, *.tiff, *.bmp, *.dib)";
          return "Image (*.png, *.bmp)";
          }
       };
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(ff);
 
    java.io.File f = null;
   if(open && fc.showOpenDialog(this) == fc.APPROVE_OPTION)
       f = fc.getSelectedFile();
    else if(!open && fc.showSaveDialog(this) == fc.APPROVE_OPTION)
       f = fc.getSelectedFile();
    return f;
    }
 
 private void openImage() {
    java.io.File f = showFileDialog(true);
    try {   
       sourceImage = ImageIO.read(f);
       JLabel l = new JLabel(new ImageIcon(sourceImage));
       originalPane.getViewport().add(l);
       this.validate();
       } catch(Exception ex) { ex.printStackTrace(); }
    }
 
 private void embedMessage() {
    String mess = message.getText();
    embeddedImage = sourceImage.getSubimage(0,0,
       sourceImage.getWidth(),sourceImage.getHeight());
    embedMessage(embeddedImage, mess);
    JLabel l = new JLabel(new ImageIcon(embeddedImage));
    embeddedPane.getViewport().add(l);
    this.validate();
    }
 
 private void embedMessage(BufferedImage img, String mess) {
    int messageLength = mess.length();
    
    int imageWidth = img.getWidth(), imageHeight = img.getHeight(),
       imageSize = imageWidth * imageHeight;
    if(messageLength * 8 + 32 > imageSize) {
       JOptionPane.showMessageDialog(this, "Message is too long for the chosen image",
          "Message too long!", JOptionPane.ERROR_MESSAGE);
       return;
       }
    embedInteger(img, messageLength, 0, 0);
 
    byte b[] = mess.getBytes();
    for(int i=0; i<b.length; i++)
       embedByte(img, b[i], i*8+32, 0);
    }
 
 private void embedInteger(BufferedImage img, int n, int start, int storageBit) {
    int maximumX = img.getWidth(), maximumY = img.getHeight(), 
       startX = start/maximumY, startY = start - startX*maximumY, count=0;
    for(int i=startX; i<maximumX && count<32; i++) {
       for(int j=startY; j<maximumY && count<32; j++) {
          int rgb = img.getRGB(i, j), bit = getBitValue(n, count);
          rgb = setBitValue(rgb, storageBit, bit);
          img.setRGB(i, j, rgb);
          count++;
          }
       }
    }
 
 private void embedByte(BufferedImage img, byte b, int start, int storageBit) {
    int maxX = img.getWidth(), maxY = img.getHeight(), 
       startX = start/maxY, startY = start - startX*maxY, count=0;
    for(int i=startX; i<maxX && count<8; i++) {
       for(int j=startY; j<maxY && count<8; j++) {
          int rgb = img.getRGB(i, j), bit = getBitValue(b, count);
          rgb = setBitValue(rgb, storageBit, bit);
          img.setRGB(i, j, rgb);
          count++;
          }
       }
    }
 
 private void saveImage() {
    if(embeddedImage == null) {
       JOptionPane.showMessageDialog(this, "No message has been embedded!", 
         "Nothing to save", JOptionPane.ERROR_MESSAGE);
       return;
      }
   java.io.File f = showFileDialog(false);
    String name = f.getName();
    String ext = name.substring(name.lastIndexOf(".")+1).toLowerCase();
    if(!ext.equals("png") && !ext.equals("bmp") &&   !ext.equals("dib")) {
          ext = "png";
          f = new java.io.File(f.getAbsolutePath()+".png");
          }
    try {
       if(f.exists()) f.delete();
       ImageIO.write(embeddedImage, ext.toUpperCase(), f);
       } catch(Exception ex) { ex.printStackTrace(); }
    }

 private void resetInterface() {
    message.setText("");
    originalPane.getViewport().removeAll();
    embeddedPane.getViewport().removeAll();
    sourceImage = null;
    embeddedImage = null;
    sp.setDividerLocation(0.5);
    this.validate();
    }
 
 private int getBitValue(int n, int location) {
    int v = n & (int) Math.round(Math.pow(2, location));
    return v==0?0:1;
    }
 
 private int setBitValue(int n, int location, int bit) {
    int toggle = (int) Math.pow(2, location), bv = getBitValue(n, location);
    if(bv == bit)
       return n;
    if(bv == 0 && bit == 1)
       n |= toggle;
    else if(bv == 1 && bit == 0)
       n ^= toggle;
    return n;
    }
 
 public static void main(String arg[]) {
    new Embed();
    }
}