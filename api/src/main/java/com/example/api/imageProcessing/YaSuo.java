package com.example.api.imageProcessing;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

public class YaSuo {
    public static void main(String[] args) throws IOException {
        Thumbnails.of("image/baby_GT.bmp").scale(0.3f)
                .outputQuality(0.3f)
                .toFile("image/baby_GT4.png");
    }
}
