import java.util.Arrays;

public class Encrypt {
    public static byte[] encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] holder = new byte[str.length() * 7];
        int holder_ptr = 0;
        for (int i = 0; i < str.length() ; i++) {
            int value = (int) str.charAt(i);
            if (value > 127) {
                //check if the char is valid or not;
                throw new RuntimeException("unicode value is bigger than 127");
            }
            byte[] subset = convert(value);
            for (int j = 0; j < 7; j++) {
                holder[holder_ptr] = subset[j];
                holder_ptr++;
            }
        }
        return holder;
    }
    private static byte[] convert(int n) {
        byte[] conversion = new byte[7];
        int num = n;
        int iter = 6;
        while (num > 0) {
            if (num % 2 == 0) {
                conversion[iter] = 0;
                num = num / 2;
            } else {
                conversion[iter] = 1;
                num = (num - 1) / 2;
            }
            iter--;
        }
        return conversion;
    }

    public static String decode(byte[] bits) {
        String res = "";
        if (bits == null) {
            return null;
        }
        if (bits.length % 7 != 0) {
            throw new RuntimeException("Not a multiple of 7");
        }
        int[] seven = new int[7];
        int bits_ptr = 0;
        while (bits_ptr < bits.length) {
            for (int i = 0; i < 7; i++) {
                seven[i] = bits[bits_ptr];
                bits_ptr++;
            }
            char unicode = decodeHelper(seven);
            res += unicode;
        }
        return res;
    }

    private static char decodeHelper(int[] bits) {
        int unicode = 0;
        for (int i=0; i< 7; i++) {
            unicode += bits[6 - i] * Math.pow(2, i);
        }
        return (char) unicode;
    }

    public static byte[] encrypt(byte[] message, Long seed, int tapPosition) {
        LFSR maker = new LFSR(convertSeedToBinary(seed), tapPosition);
        int ptr = 0;
        while (ptr < message.length) {
            message[ptr] = (byte) (message[ptr] ^ maker.nextBit());
            ptr++;
        }
        return message;
    }

    public static void decrypt(byte[] cipher, Long seed, int tapPosition) {
        encrypt(cipher, seed, tapPosition);
    }

    public static String convertSeedToBinary(Long hexSeed){
        String hexString = Long.toString(hexSeed);
        hexString = hexString.substring(2);
        long num = Long.parseLong(hexString, 16);
        return Long.toBinaryString(num);
    }
}
