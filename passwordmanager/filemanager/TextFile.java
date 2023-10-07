package passwordmanager.filemanager;

public enum TextFile {
    ACCOUNT(TextFileManager.ACCOUNT_FILE),
    LOGIN(TextFileManager.LOGIN_FILE);

    private String filename;

    TextFile(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }
}
