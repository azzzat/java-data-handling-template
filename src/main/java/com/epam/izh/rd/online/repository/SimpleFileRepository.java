package com.epam.izh.rd.online.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public class SimpleFileRepository implements FileRepository {

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {
        long count = 0;
        File file = new File("C:/Users/anpuc/Desktop/EpamIntroJava/java-data-handling-template/src/main/resources/" + path);
        File[] dirs = file.listFiles();
        try {
            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i].isFile()) {
                    count++;
                } else {
                    count += countFilesInDirectory(path + "/" + dirs[i].getName());
                }
            }
        } catch (NullPointerException e) {
            return 0;
        }
        return count;
    }

    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) throws IOException {
        long count = 1;
        File file = new File("C:/Users/anpuc/Desktop/EpamIntroJava/java-data-handling-template/src/main/resources/" + path);
        File[] dirs = file.listFiles();
        try {
            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i].isDirectory()) {
                    count += countDirsInDirectory(path + "/" + dirs[i].getName());
                } else {
                    continue;
                }
            }
        } catch (NullPointerException e) {
            return 0;
        }

        return count;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        File copied = new File(from);
        File pasted = new File(to);
        File[] files = copied.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
                if (files[i].getName().endsWith(".txt")){
                    try {
                        Files.copy(files[i].toPath(), pasted.toPath());
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }

    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    //не получилось
    @Override
    public boolean createFile(String path, String name) {
        boolean fileCreated = false;
        try{

            File dir = new File ("C:/Users/anpuc/Desktop/EpamIntroJava/java-data-handling-template/src/main/resources/" + path);
            dir.mkdir();
            File file = new File("C:/Users/anpuc/Desktop/EpamIntroJava/java-data-handling-template/src/main/resources/" + path, name);

            if (file.createNewFile()) {
                fileCreated = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileCreated;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        StringBuilder answer = new StringBuilder();

        try {
            FileInputStream fileIS = new FileInputStream("C://Users//anpuc//Desktop//EpamIntroJava//java-data-handling-template//src//main//resources//" + fileName);
            int input = 0;

            while((input = fileIS.read()) != -1){
                answer.append((char) input);
            }

        } catch (IOException e) {

        }

        return answer.toString();
    }
}
