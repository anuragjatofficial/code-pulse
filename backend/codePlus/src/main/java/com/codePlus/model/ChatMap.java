package com.codePlus.model;

import java.util.Map;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ChatMap {
	private Map<Question, Answer> chatMap;
}
