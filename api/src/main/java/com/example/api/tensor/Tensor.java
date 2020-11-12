package com.example.api.tensor;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;

public class Tensor {
    public static void main(String[] args) {
        SavedModelBundle b = SavedModelBundle.load("");
        Session session = b.session();
    }
}
