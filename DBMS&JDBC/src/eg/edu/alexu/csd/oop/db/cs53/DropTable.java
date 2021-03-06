package eg.edu.alexu.csd.oop.db.cs53;

import java.util.HashMap;
import java.util.Map;

public class DropTable implements Parser {
	private Map<String, Object> collected = new HashMap<String, Object>();
	private String selectedCommand;
	private String TableName = "";

	public DropTable() {
		collected.put("Operation", getClass().getSimpleName());
	}

	public String getTableName() {
		selectedCommand = selectedCommand.replace(" ", "");
		String Allcaps = selectedCommand.toUpperCase();
		String x = selectedCommand.substring(Allcaps.indexOf("TABLE") + 5, Allcaps.indexOf(";"));
		TableName = x.trim();
		return TableName;
	}

	@Override
	public Map<String, Object> getMap(String quary) {
		this.selectedCommand = quary;
		collected.put("TableName", getTableName());
		return collected;
	}

}
