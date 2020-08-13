# LFSR-Cryption
Use a Linear Feedback Shift Register (LFSR) to produce a key stream
For this challenge, the LFSR is initialized with a value (which is 0x12345678 here) and stepped to produce the key stream. The next key value is read from the LFSR after eight steps, with the actual key being the lowest byte of the current LFSR value.

## How to run this program
Clone this project, and run main class (CryptMain.java)

## Key method for decryption and encryption: 
 static byte[] Crypt(byte[] data, long initialValue)

<h3>Sample test input</h3>

```
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

```

<h3>Sample test output</h3>


```
        Original data is: apple
        Original byte data: [1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1]
        Encrypted data is: [0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0]
        Start Decrypting data ...
        Reverse encryption [1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1]
        Original data recovered: apple

```
