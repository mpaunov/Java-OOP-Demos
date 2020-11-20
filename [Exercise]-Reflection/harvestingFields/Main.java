package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		Class<?> clazz = RichSoilLand.class;

		Map<String, List<Field>> fieldsByModifiers = new HashMap<>();

		fieldsByModifiers.put("private", new ArrayList<>());
		fieldsByModifiers.put("protected", new ArrayList<>());
		fieldsByModifiers.put("public", new ArrayList<>());
		fieldsByModifiers.put("all", new ArrayList<>());

		for(Field field : clazz.getDeclaredFields()) {
			fieldsByModifiers.get(Modifier.toString(field.getModifiers()))
					.add(field);
			fieldsByModifiers.get("all").add(field);
		}

		Map<String, String> outputMap = new HashMap<>();

		outputMap.put("private", formatFieldOutput(fieldsByModifiers.get("private")));
		outputMap.put("protected", formatFieldOutput(fieldsByModifiers.get("protected")));
		outputMap.put("public", formatFieldOutput(fieldsByModifiers.get("public")));
		outputMap.put("all", formatFieldOutput(fieldsByModifiers.get("all")));

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();

		StringBuilder output = new StringBuilder();

		while (!input.equals("HARVEST")) {

			output.append(outputMap.get(input)).append(System.lineSeparator());

			input = reader.readLine();
		}

		System.out.print(output.toString());
	}

	public static String formatFieldOutput(Collection<Field> fields) {
		return fields.stream().map(f -> String.format(
				"%s %s %s",
				Modifier.toString(f.getModifiers()),
				f.getType().getSimpleName(),
				f.getName()
		)).collect(Collectors.joining(System.lineSeparator())).trim();
	}
}
