package eg.edu.alexu.csd.oop.db.cs53;

import java.util.HashMap;
import java.util.Map;

public class CreateDB implements Parser {
	private Map<String, Object> collected = new HashMap<String, Object>();
	private String selectedCommand;
	private String DBName = "";

	public CreateDB() {
		collected.put("Operation", getClass().getSimpleName());

	}

	public String getDBName() {
		selectedCommand = selectedCommand.replace(" ", "");
		String Allcaps = selectedCommand.toUpperCase();
		String x = selectedCommand.substring(Allcaps.indexOf("DATABASE") + 8, Allcaps.indexOf(";"));
		DBName = x.trim();
		return DBName;
	}

	@Override
	public Map<String, Object> getMap(String quary) {
		this.selectedCommand = quary;
		collected.put("DataBaseName", getDBName());
		return collected;
	}

}
