import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "Hello, Lena";
        String path = "/Users/zlatahayvoronska/Documents/OOP/Homeworks/Steganography/src/main/resources/img/cat.png";
        String path2 = "/Users/zlatahayvoronska/Documents/OOP/Homeworks/Steganography/src/main/resources/img/cat_2.png";
        MyImage img = new MyImage(path);
        BufferedImage original = img.getImage(path);
        BufferedImage for_work = img.easy_to_use(original);
        byte[] colors = img.get_byte_data(for_work);
        byte[] message = text.getBytes();
        byte[] len = img.convert_to_byte(message.length);
        img.coding(colors, len, 0);
        img.coding(colors, message, 32);

        img.setImage(for_work, new File(path2));
        String decoded = img.decoding(path2);
        System.out.println(decoded);

    }




}