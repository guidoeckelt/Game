package de.charaktar.game.graphic.image.png;

public class PNG {

    public enum ChunkType {

        IHDR,
        PLTE,
        IDAT,
        IEND,

        UNRECOGNIZED;

        public static ChunkType valueOf(int value) {
            switch (value) {
                case 0x49484452:
                    return IHDR;
                case 0x504C5445:
                    return PLTE;
                case 0x49444154:
                    return IDAT;
                case 0x49454E44:
                    return IEND;
                default:
                    return UNRECOGNIZED;
            }
        }

    }

    public enum ColorType {
        GRAY_SCALE, // 0
        TRUECOLOR, // 2
        INDEXED_COLOR, // 3
        GRAY_SCALE_ALPHA, // 4
        TRUECOLOR_ALPHA; // 6

        public static ColorType valueOf(int value) {
            switch (value) {
                case 0:
                    return GRAY_SCALE;
                case 2:
                    return TRUECOLOR;
                case 3:
                    return INDEXED_COLOR;
                case 4:
                    return GRAY_SCALE_ALPHA;
                case 6:
                    return TRUECOLOR_ALPHA;
                default:
                    return GRAY_SCALE;
            }
        }

    }

    public enum CompressionType {
        DEFLATE; // 0

        public static CompressionType valueOf(int value) {
            switch (value) {
                case 0:
                    return DEFLATE;
                default:
                    return DEFLATE;
            }
        }

    }

    public enum FilterType {
        ADAPTIVE; // 0

        public static FilterType valueOf(int value) {
            switch (value) {
                case 0:
                    return ADAPTIVE;
                default:
                    return ADAPTIVE;
            }
        }

    }

    public enum InterlaceType {
        NONE, // 0
        ADAM7; // 1

        public static InterlaceType valueOf(int value) {
            switch (value) {
                case 0:
                    return NONE;
                case 1:
                    return ADAM7;
                default:
                    return NONE;
            }
        }

    }

}
