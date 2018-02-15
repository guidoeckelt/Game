package game.graphic.image.png;

import game.util.Bytes;

public class PngChunk {

    private final int INTEGER_LENGTH = 4;
    private int dataLength;
    private byte[] type;
    protected byte[] data;
    private byte[] crc_checksum; // from type and data

    public int decode(byte[] allBytes, int currentByte) {

        int readBytes = 0;
        byte[] dataSize = Bytes.subBytes(allBytes, currentByte + readBytes, INTEGER_LENGTH);
        readBytes += INTEGER_LENGTH;
        this.dataLength = Bytes.toInt(dataSize);
        System.out.println("data Length : " + this.dataLength);
        this.type = Bytes.subBytes(allBytes, currentByte + readBytes, INTEGER_LENGTH);
        readBytes += INTEGER_LENGTH;
        this.data = Bytes.subBytes(allBytes, currentByte + readBytes, this.dataLength);
        readBytes += this.dataLength;
        this.decodeData();
        this.crc_checksum = Bytes.subBytes(allBytes, currentByte + readBytes, INTEGER_LENGTH);
        readBytes += INTEGER_LENGTH;
        this.confirmChecksum();
        return readBytes;
    }

    protected void decodeData() {
//        switch(PNG.ChunkType.valueOf(this.getType())){
//            case IHDR: this.IHDR = chunk;
//            case PLTE: this.PLTE = chunk;
//            case IDAT: this.IDAT_List.add(chunk);
//            case IEND: this.IEND = chunk;
//            case UNRECOGNIZED: System.out.println("chunk unrecognize");
//        }
    }

    private void confirmChecksum() {


    }

    public int getDataLength() {
        return dataLength;
    }

    public int getType() {
        return Bytes.toInt(this.type);
    }

    public byte[] getData() {
        return data;
    }

    public int getCrc_checksum() {
        return Bytes.toInt(this.crc_checksum);
    }

}
