package de.charaktar.game.util;

public class Bytes {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String toHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static int toInt(byte[] bytes) { //TODO implement correctly
        int last = bytes.length - 1;
        int first = 0;
        int result = 0;
        for (int i = first; i <= last; i++) {
            int value = bytes[i];
            int offset = (bytes.length * 8) - ((i + 1) * 8);
            result += (value << offset);
//            System.out.println("offset : " + offset + " | value : " + value+ " | result : " + result);
        }
        return result;
    }

    public static long toLong(byte[] bytes) { //TODO implement correctly
        int last = bytes.length - 1;
        int first = 0;
        long result = 0;
        for (int i = first; i <= last; i++) {
            long value = bytes[i];
            long offset = (bytes.length * 8) - ((i + 1) * 8);
            result += (value << offset);
        }
        return result;
    }

    public static byte[] subBytes(byte[] allBytes, int start, int length) {
        byte[] result = new byte[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = allBytes[start + i];
        }
        return result;
    }
}
