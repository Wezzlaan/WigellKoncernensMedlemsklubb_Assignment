package com.vestrin.storage;

import java.io.*;

public class FileWriter {

    public FileWriter()
    {
    }

    public void writeToFile(String path, Object object) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(object);
        }
    }

    public Object loadFromFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public Inventory loadInventory(String path) throws IOException{
        try {
            return (Inventory) loadFromFile(path);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("FEL: Filen innehöll ingen 'Inventory'-Klass.", e);
        } catch (FileNotFoundException e){
            throw e;
        }
    }

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
