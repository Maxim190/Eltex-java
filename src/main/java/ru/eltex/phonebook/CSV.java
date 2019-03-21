package ru.eltex.phonebook;

public interface CSV {
	void toCSV(String str, boolean append);
	String fromCSV();
}
