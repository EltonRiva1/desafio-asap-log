package br.com.viavarejo.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.viavarejo.enums.MessagesValidation;

public final class MessageUtils {
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messagesValidation", new Locale("pt", "BR"));

	private MessageUtils() {
		super();
	}

	public static String getMessage(MessagesValidation messagesValidation) {
		return new String(RESOURCE_BUNDLE.getString(messagesValidation.toString()).getBytes());

	}

	public static String getMessage(MessagesValidation messagesValidation, Object... args) {
		String mensagem = getMessage(messagesValidation);
		if (args.length > 0) {
			mensagem = MessageFormat.format(mensagem, args);
		}
		return mensagem;
	}
}
