package de.charaktar.game.graphic.image.png;

import de.charaktar.game.util.Bytes;

public class IHDRChunk extends PngChunk {

    private int width;
    private int height;
    private byte bitDepth;
    private byte colorType;
    private byte compressionType;
    private byte filterType;
    private byte interlaceType;

    @Override
    protected void decodeData() {
        byte[] widthBytes = Bytes.subBytes(this.data, 0, 4);
        byte[] heightBytes = Bytes.subBytes(this.data, 4, 4);
//        System.out.println(Bytes.toHex(widthBytes) + " : "+heightBytes);
        this.width = Bytes.toInt(widthBytes);
        this.height = Bytes.toInt(heightBytes);
        this.bitDepth = this.data[8]; //
        this.colorType = this.data[9];
        this.compressionType = this.data[10];
        this.filterType = this.data[11];
        this.interlaceType = this.data[12];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBitDepth() {
        return bitDepth;
    }

    public PNG.ColorType getColorType() {
        return PNG.ColorType.valueOf(this.colorType);
    }

    public PNG.CompressionType getCompressionType() {
        return PNG.CompressionType.valueOf(this.compressionType);
    }

    public PNG.FilterType getFilterType() {
        return PNG.FilterType.valueOf(this.filterType);
    }

    public PNG.InterlaceType getInterlaceType() {
        return PNG.InterlaceType.valueOf(this.interlaceType);
    }

}
