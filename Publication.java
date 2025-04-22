package exercise1;

class Publication {
	private String title;
	private int year;

	public Publication(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getInfo() {
		return title + " " + year;
	}
}
