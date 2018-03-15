package de.charaktar.ge.graphic.image.png;

import de.charaktar.util.Bytes;

public class PngSignature {

    private final byte[] bytes;
    private final long value;

    public PngSignature(byte[] value) {
        this.bytes = value;
        long first = Bytes.toInt(Bytes.subBytes(value, 0, 4));
        long second = Bytes.toInt(Bytes.subBytes(value, 4, 4));
        this.value = Bytes.toLong(bytes);
    }

    public byte[] getBytes() {
        return bytes;
    }

    public long getValue() {
        return value;
    }
}
