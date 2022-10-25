package file.navigator;

public class FileData {

    String path;
    String filename;
    Byte size;

    public FileData(String path, String filename, Byte size) {
        this.path = path;
        this.filename = filename;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public String getFilename() {
        return filename;
    }

    public Byte getSize() {
        return size;
    }

//    @Override
    public static int compareTo(FileData f1, FileData f2){
        if(f1.getSize() < f2.getSize())
            return -1;
        return 1;
    }
}
