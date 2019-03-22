package ru.eltex.phonebook;

public interface CSV {
	void toCSV(User user, boolean append);
	void fromCSV();
}
