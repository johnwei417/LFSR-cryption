import java.util.Arrays;

public class CryptMain {
    public static void main(String[] args) {
        String data = "apple";
        long seed = 0x12345678;
        System.out.println("Original data is: "+data);
        byte[] bytedata = Encrypt.encode(data);
        System.out.println("Original byte data: "+Arrays.toString(bytedata));
        Crypt(bytedata, seed);

        System.out.println("Encrypted data is: " + Arrays.toString(bytedata));

        System.out.println("Start Decrypting data ...");
        Crypt(bytedata, seed);
        System.out.println("Reverse encryption "+Arrays.toString(bytedata));
        System.out.println("Original data recovered: " + Encrypt.decode(bytedata));

    }

    static byte[] Crypt(byte[] data, long initialValue){
        return Encrypt.encrypt(data, initialValue, 8);
    }
}
