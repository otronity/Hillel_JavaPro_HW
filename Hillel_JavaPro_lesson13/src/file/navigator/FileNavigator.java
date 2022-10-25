package file.navigator;

import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {

    Map<String, List<FileData>> filelist = new HashMap<>();

    public void add(String path, String filename, byte size) {
        if ((path != null) && (filename != null)) {
            if (!path.isEmpty() && !filename.isEmpty() && (size > 0)) {
                if (filelist.containsKey(path)) {
                    List<FileData> lfd = filelist.get(path);
                    lfd.add(new FileData(path, filename, size));
                } else {
                    List<FileData> lfd = new ArrayList<>();
                    lfd.add(new FileData(path, filename, size));
                    filelist.put(path, lfd);
                }
            } else {
                System.out.println("Некоректні параметри!");
            }
        } else {
            System.out.println("Некоректні параметри (null) !");
        }
    }

    public void find(String path) {
        if (path != null) {
            if (!filelist.isEmpty()) {
                if (filelist.containsKey(path)) {
                    List<FileData> lfd = filelist.get(path);
                    System.out.println("Список файлів по путі " + path + " : ");
                    print(lfd);
                }
            } else {
                System.out.println("Список файлів пустий");
            }
        } else {
            System.out.println("Некоректний параметр path");
        }
    }

    public void filterBySize(byte maxSize) {
        if (!filelist.isEmpty()) {
            System.out.println("Список файлів по розміру <= " + maxSize + ":");
            int cnt = 0;
            System.out.println("Path            |  FileName        |  Size");
            for (Map.Entry<String, List<FileData>> entry : filelist.entrySet()) {
                List<FileData> fileData = entry.getValue();
                for (FileData fd : fileData) {
                    if (fd.getSize() <= maxSize) {
                        String s = "               ";
                        System.out.println(
                                fd.getPath() + s.substring(1, s.length() - fd.getPath().length()) + "  |  " +
                                        fd.getFilename() + s.substring(1, s.length() - fd.getFilename().length()) + "  |  " +
                                        fd.getSize());
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println("Немоє файлів < " + maxSize);
            }
        } else {
            System.out.println("Список файлів пустий");
        }

    }

    public void remove(String path) {
        if (path != null) {
            if (filelist.containsKey(path)) {
                filelist.remove(path);
            } else {
                System.out.println("Немає чого видаляти");
            }
        } else {
            System.out.println("Некоректний параметр path");
        }

    }

    public void sortBySize() {
        if (!filelist.isEmpty()) {
            List<FileData> lf = new ArrayList<>();
            for (Map.Entry<String, List<FileData>> entry : filelist.entrySet()) {
                if (entry.getValue() != null) {
                    lf.addAll(entry.getValue());
                }
            }
            List<FileData> sortedlist =
                    lf.stream().sorted(Comparator.comparing(FileData::getSize)).collect(Collectors.toList());
            System.out.println("Список файлів відсортированих по розміру");
            print(sortedlist);
        } else {
            System.out.println("Список файлів пустий");
        }
    }

    public void print(List<FileData> list) {
        if (!list.isEmpty()) {
            System.out.println("Path            |  FileName        |  Size");
            for (FileData fd : list) {
                String s = "               ";
                System.out.println(
                        fd.getPath() + s.substring(1, s.length() - fd.getPath().length()) + "  |  " +
                                fd.getFilename() + s.substring(1, s.length() - fd.getFilename().length()) + "  |  " +
                                fd.getSize());
            }
        } else {
            System.out.println("Передан пустий список");
        }
    }

}
