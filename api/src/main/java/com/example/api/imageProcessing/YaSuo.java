package com.example.api.imageProcessing;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

public class YaSuo {
    public static void main(String[] args) throws IOException {
        Thumbnails.of("image/srcnn.png").scale(0.3f)
                .outputQuality(0.3f)
                .toFile("image/srcnn-6.png");
    }
}


//0.5  0.5
//0.7 0.8
//0.75 0.83


//0.4 0.4
// 0.6 0.6
