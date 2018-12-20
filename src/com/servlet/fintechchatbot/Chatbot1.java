package com.servlet.fintechchatbot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;

public class Chatbot1 {
	private static final boolean TRACE_MODE = false;
	static String botName = "super";
	private Chat chatSession;
	private Bot bot;
	public Chatbot1() {
		String resourcesPath = getResourcesPath();
		System.out.println(resourcesPath);
		MagicBooleans.trace_mode = TRACE_MODE;
		bot = new Bot("super", resourcesPath);
		chatSession = new Chat(bot);
		bot.brain.nodeStats();
		
	}
	public String chat(String textLine) {
		try {
			System.out.print("Human : "+textLine);
			if ((textLine == null) || (textLine.length() < 1))
				textLine = MagicStrings.null_input;
			if (textLine.equals("q")) {
				System.exit(0);
			} else if (textLine.equals("wq")) {
				bot.writeQuit();
				System.exit(0);
			}else {
				String request = textLine;
				if (MagicBooleans.trace_mode)
					System.out.println(
							"STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
							+ ":TOPIC=" + chatSession.predicates.get("topic"));
				String response = chatSession.multisentenceRespond(request);
				while (response.contains("&lt;"))
					response = response.replace("&lt;", "<");
				while (response.contains("&gt;"))
					response = response.replace("&gt;", ">");
				System.out.println("Robot : " + response);
				//Text2Speechhi obj=new Text2Speech(); 
				//obj.dospeak(response,"kevin16");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getResourcesPath() {
		return "C:\\Users\\hp-pc\\fintechchatbot\\fintechchatbot\\src\\main\\resources";
	}
}