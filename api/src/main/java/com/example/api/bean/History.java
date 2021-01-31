package com.example.api.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class History {
    public String lr;
    public String hr;
    public String time;
}
