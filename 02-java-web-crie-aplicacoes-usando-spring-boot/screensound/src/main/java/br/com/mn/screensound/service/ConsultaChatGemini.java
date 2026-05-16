package br.com.mn.screensound.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaChatGemini {

    public static String obterInformacao(String texto) {
        // Seguindo o exemplo da imagem: pegando a chave de uma variável de ambiente
        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
            .apiKey(System.getenv("GEMINI_API_KEY"))
            .modelName("gemini-2.5-flash")
            .maxOutputTokens(1000)
            .temperature(0.7)
            .build();

        String prompt = "me fale sobre o artista: " + texto;

        try {
            return model.generate(prompt);
        } catch (Exception e) {
            return "Erro ao conectar com o Gemini: " + e.getMessage();
        }
    }
}
