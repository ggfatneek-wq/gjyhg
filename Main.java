interface FileAccess {
    void openFile();
}

class RealFile implements FileAccess {
    private String name;

    public RealFile(String name) {
        this.name = name;
    }

    public void openFile() {
        System.out.println("Opening " + name);
    }
}

class FileProxy implements FileAccess {
    private RealFile realFile;
    private boolean accessGranted;

    public FileProxy(RealFile realFile, boolean accessGranted) {
        this.realFile = realFile;
        this.accessGranted = accessGranted;
    }

    public void openFile() {
        // Add the access check here during the live coding part
        realFile.openFile();
    }
}

public class Main {
    public static void main(String[] args) {
        RealFile file = new RealFile("grades.txt");

        FileProxy noAccess = new FileProxy(file, false);
        FileProxy hasAccess = new FileProxy(file, true);

        noAccess.openFile();
        hasAccess.openFile();
    }
}
