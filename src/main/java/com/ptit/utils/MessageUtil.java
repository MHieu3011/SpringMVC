package com.ptit.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {

	public static Map<String, String> getMessage(String message) {
		Map<String, String> results = new HashMap<>();
		if (message.equals("insert_success")) {
			results.put("message", "Insert success");
			results.put("alert", "success");
		} else if (message.equals("update_success")) {
			results.put("message", "Update success");
			results.put("alert", "success");
		} else if (message.equals("delete_success")) {
			results.put("message", "Delete success");
			results.put("alert", "success");
		} else if (message.equals("error_system")) {
			results.put("message", "Error system");
			results.put("alert", "danger");
		}
		return results;
	}
}
