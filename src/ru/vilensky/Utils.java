package ru.vilensky;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;

public class Utils {

    public static void showImageWindow(Image image) {
        showImageWindow(image, 1024, 768);
    }

    public static void showImageWindow(Image image, int width, int height) {
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel picLabel = new JLabel(new ImageIcon(image));

        BorderLayout borderLayout = new BorderLayout();
        frame.getContentPane().setLayout(borderLayout);
        frame.getContentPane().add(picLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void measureTime(Runnable task, String taskName) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println(taskName + ": " + elapsed + " ms");
    }

    public static BufferedImage toGray(BufferedImage source) {
        BufferedImage grayImage = new BufferedImage(source.getWidth(), source.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);

        byte[] outBuffer = ((DataBufferByte)grayImage.getRaster().getDataBuffer()).getData();
        int[] inBuffer = ((DataBufferInt)source.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < source.getWidth() * grayImage.getHeight(); i++) {
            int color = inBuffer[i];
            int r = color >> 16 & 0xff;
            int g = color >> 8 & 0xff;
            int b = color & 0xff;
            int gray = (r + g + b) / 3;
            outBuffer[i] = (byte) gray;
        }
        return grayImage;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    public static void saveFileDialog(File fileToSave){

    }

    public static File getFileDialog(){
        JFrame frame = new JFrame("Image chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "tif");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);

        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }else
            return null;
    }
}
