package homework2.Trees.Assets;

/**
 * Interface for a phone book. Each entry in the phone book is made up of 2
 * components: a name (String) and a phone number (long).
 *
 * For example, assume we have a phone book with the following data:
 *
 * {"name": "ABC", "phoneNumber": 1111111111} {"name": "XYZ", "phoneNumber":
 * 9999999999} {"name": "DEF", "phoneNumber": 2222222222}
 *
 * then, the size() method should return 3, find("ABC") should return
 * 1111111111, find("XYZ") should return 9999999999, find("PQR") should return
 * -1.
 */

public interface PhoneBook {

	/**
	 * @return The number of entries in this phone book.
	 */
	public int size();

	/**
	 * Inserts an entry in this phone book.
	 * 
	 * @param name
	 *            The name for the entry.
	 * @param phoneNumber
	 *            The phone number for the entry.
	 */
	public void insert(String name, long phoneNumber);

	/**
	 * Returns the phone number associated with a name in the phone book.
	 * 
	 * @param name
	 *            The name to search for.
	 * @return The phone number for the entry, or -1 if the name is not present in
	 *         the phone book.
	 */
	public long find(String name);

}
