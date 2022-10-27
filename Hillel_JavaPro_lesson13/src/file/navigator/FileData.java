package file.navigator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return getPath().equals(fileData.getPath()) && getFilename().equals(fileData.getFilename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getFilename());
    }
}
