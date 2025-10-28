package com.vestrin.storage;

import java.io.*;

public class FileWriter {

    public FileWriter(){
    }

    /** @param path File to write to.
     * @param object Object to add to file.
     * @throws IOException ...*/
    public void writeToFile(String path, Object object) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(object);
        }
    }
    /**METHOD FOR LOADING OBJECTS FROM FILE.
     * @param path File to initialize/read from.
     * @return Found objects in file.
     * @throws IOException ...
     * @throws ClassNotFoundException ...*/
    private Object loadFromFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
    /** @param path Filepath of Inventory local 'Database'.
     * @return Inventory from file.
     * @throws IOException ...*/
    public Inventory loadInventory(String path) throws IOException{
        try {
            return (Inventory) loadFromFile(path);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("FEL: Filen innehöll ingen 'Inventory'-Klass.", e);
        } catch (FileNotFoundException e){
            throw e;
        }
    }
    /** @param path Filepath of Member Registry local 'Database'.
     * @return Member Registry from file.
     * @throws IOException ...*/
    public MemberRegistry loadMemberRegistry(String path) throws IOException{
        try {
            return (MemberRegistry) loadFromFile(path);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("FEL: Filen innehöll ingen 'MemberRegistry'-Klass.", e);
        } catch (FileNotFoundException e){
            throw e;
        }
    }
}
