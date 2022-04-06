package spring.prueba_tecnica;

public class File {
	private String fileName;
	private String hash;

	public File(String fileName, String hash) {
        this.fileName = fileName;
		this.hash = hash;
	}

    public String getFileName() {
		return this.fileName;
	}

	public String getHash() {
		return this.hash;	
	}
}
