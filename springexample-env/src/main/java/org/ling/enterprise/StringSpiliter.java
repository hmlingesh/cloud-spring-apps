package org.ling.enterprise;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringSpiliter {

	public static void main(String[] args) {

		String s = "/bin/bash;-c;ls /var/log";

		System.out.println(commandsList(s).toString());
	}

	public static List<String> commandsList(String s) {
		StringTokenizer st = new StringTokenizer(s, ";");

		List<String> commands = new ArrayList<String>();

		while (st.hasMoreElements()) {
			commands.add(st.nextElement().toString());

		}
		return commands;

	}

}
