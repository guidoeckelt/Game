package de.charaktar.ge.graphic.image.png;

import de.charaktar.ge.graphic.image.Pixel;
import de.charaktar.ge.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class PngImageReader {

    private final byte[] allBytes;
    private final String correctSig = "89504E470D0A1A0A";
    private PngChunk IHDR;
    private PngChunk PLTE;
    private List<PngChunk> IDAT_List;
    private PngChunk IEND;

    public PngImageReader(byte[] allBytes) {

        this.allBytes = allBytes;
        this.IDAT_List = new ArrayList<>();
    }

    public Pixel[][] decodeToPixels() {

        System.out.println("total bytes : " + this.allBytes.length);
        byte[] temp = Bytes.subBytes(this.allBytes, 0, 8);
        PngSignature signature = new PngSignature(temp);
        System.out.println("signature : " + Bytes.toHex(signature.getBytes()));
        int currentByte = 8;
        if (Bytes.toHex(signature.getBytes()).equals(correctSig)) {
            System.out.println("signature is correct");
//            while(currentByte < this.allBytes.length){
//                PngChunk chunk = new PngChunk();
//                int readBytes = chunk.decode(this.allBytes, currentByte);
//                currentByte += readBytes;
//                switch(PNG.ChunkType.valueOf(chunk.getType())){
//                    case IHDR: this.IHDR = chunk;
//                    case PLTE: this.PLTE = chunk;
//                    case IDAT: this.IDAT_List.add(chunk);
//                    case IEND: this.IEND = chunk;
//                    case UNRECOGNIZED: System.out.println("chunk unrecognize");
//                }
//            }
            this.IHDR = new IHDRChunk();
            int readBytes = this.IHDR.decode(this.allBytes, currentByte);

//            System.out.println("typeInt : " + this.IHDR.getType() + "| ChunkType : " + PngChunk.ChunkType.valueOf(this.IHDR.getType()));
//            System.out.println(this.IHDR.getWidth() + " : " + this.IHDR.getHeight());
//            System.out.println("BitDepth : " + this.IHDR.getBitDepth());
//            System.out.println("ColorType : " + this.IHDR.getColorType());
//            System.out.println("CompressionType : " + this.IHDR.getCompressionType());
//            System.out.println("FilterType : " + this.IHDR.getFilterType());
//            System.out.println("InterlacerType : " + this.IHDR.getInterlaceType());

        }
        return new Pixel[1][1];
    }


}
