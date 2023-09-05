package com.codePlus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptChoice {

	private int index;
    private ChatGptMessage message;
    private String finishReason;
}
