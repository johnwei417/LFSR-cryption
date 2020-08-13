public class LFSR {
    public String seed;
    public int tapPosition;
    public int[] shiftRegister;

    public LFSR(String seed, int tapPosition) {
        if (seed == null) {
            throw new RuntimeException("Seed cannot be null.");
        }

        shiftRegister = new int[seed.length()];
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) != '0' && seed.charAt(i) != '1') {
                throw new RuntimeException("seed can only be in binary format");
            }
            shiftRegister[shiftRegister.length - 1 - i] = seed.charAt(i) - '0';
        }

        this.seed = seed;
        if (tapPosition > 0 && tapPosition <= seed.length() - 1) {
            this.tapPosition = tapPosition;
        } else {
            throw new RuntimeException("Tap position not valid.");
        }

    }

    public LFSR(int seedLength, int tapPosition) {
        if (seedLength < 1) {
            throw new RuntimeException("Seed length must be at least 1.");
        }
        shiftRegister = new int[seedLength];
        int generated;
        for (int i = 0; i < seedLength; i++) {
            if (Math.random() > 0.5) {
                generated = 1;
            } else {
                generated = 0;
            }
            shiftRegister[i] = generated;
        }
        if (tapPosition > 0 && tapPosition <= seedLength - 1) {
            this.tapPosition = tapPosition;
        } else {
            throw new RuntimeException("Tap position not valid.");
        }
    }

    public String toString() {
        String holder = "";
        for (int i = shiftRegister.length - 1; i >= 0; i--) {
            holder += (char) (shiftRegister[i] + '0');
        }
        return holder;
    }

    public int getTapPosition() {
        return tapPosition;
    }

    public int nextBit() {
        int next = shiftRegister[shiftRegister.length-1] ^ shiftRegister[tapPosition];
        for (int i = shiftRegister.length - 1; i > 0; i--) {
            shiftRegister[i] = shiftRegister[i-1];
        }
        shiftRegister[0] = next;
        return next;
    }
    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int bit = lfsr.nextBit();
            System.out.println(lfsr.toString() + " " + bit);
        }
    }
}
