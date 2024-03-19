package com.navan.exe;

public interface Message {
    String getTopic();
    String getPayload(String payload);
}
