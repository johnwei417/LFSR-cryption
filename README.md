# LFSR-Cryption
use a Linear Feedback Shift Register (LFSR) to produce a key stream
For this challenge, the LFSR is initialized with a value (which is 0x12345678 here) and stepped to produce the key stream. The next key value is read from the LFSR after eight steps, with the actual key being the lowest byte of the current LFSR value.

<h2>How to run this program</h2>
1. clone this project
2. run main class (CryptMain.java)

<h3< Key method for decryption and encryotion: </h3>
 static byte[] Crypt(byte[] data, long initialValue)
