package com.campusfix.service;

import org.springframework.stereotype.Service;
import java.util.Locale;
import java.util.Map;

@Service
public class SmartClassifier {
    private static final Map<String, String[]> KEYWORDS = Map.of(
        "Electricity", new String[]{"electric", "light", "fan", "power", "switch", "socket", "wiring", "plug"},
        "Wi-Fi & Network", new String[]{"wifi", "wi-fi", "internet", "network", "router", "connectivity"},
        "Washroom", new String[]{"washroom", "toilet", "bathroom", "tap", "flush", "leakage", "water leak"},
        "Classroom", new String[]{"classroom", "desk", "chair", "board", "projector", "bench"},
        "Laboratory", new String[]{"lab", "laboratory", "computer", "printer", "equipment"}
    );

    public String category(String text) {
        String t = text.toLowerCase(Locale.ROOT);
        for (var entry : KEYWORDS.entrySet())
            for (String word : entry.getValue())
                if (t.contains(word)) return entry.getKey();
        return "General Facilities";
    }

    public String priority(String text) {
        String t = text.toLowerCase(Locale.ROOT);
        if (containsAny(t, "sparking", "fire", "smoke", "exposed wire", "flood", "burst pipe", "danger", "emergency"))
            return "High";
        if (containsAny(t, "not working", "broken", "urgent", "blocked", "no power", "no internet", "leaking"))
            return "Medium";
        return "Low";
    }

    public String department(String category) {
        return switch (category) {
            case "Electricity" -> "Electrical Maintenance";
            case "Wi-Fi & Network", "Laboratory" -> "IT Support";
            case "Washroom" -> "Housekeeping & Plumbing";
            case "Classroom" -> "Campus Facilities";
            default -> "General Maintenance";
        };
    }

    private boolean containsAny(String text, String... words) {
        for (String word : words) if (text.contains(word)) return true;
        return false;
    }
}
