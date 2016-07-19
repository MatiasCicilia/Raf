import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by matias on 6/22/16.
 */
public class MovieFile {
    private File f;
    private RandomAccessFile raf;
    private int registrySize = 79;
    private BinarySearchTree<MovieIndex> indexFile;

    public MovieFile(String filename) throws FileNotFoundException {
        f = new File(filename);
        raf = new RandomAccessFile(f,"rw");
    }

    public void start() throws IOException {
        raf.seek(0);
    }

    public void end() throws IOException {
        raf.seek(raf.length());
    }

    public void goTo(long reg) throws IOException{
        raf.seek((reg-1)*registrySize);
    }

    public void close() throws IOException{
        raf.close();
    }

    public long getLength() throws IOException {
        return raf.length();
    }

    public boolean isEnd() throws IOException {
        return raf.getFilePointer()==raf.length();
    }

    public void write(Movie movie) throws IOException{
        raf.writeUTF(Utilities.adapt(movie.getTitle(), 50));
        raf.writeInt(movie.getYear());
        raf.writeUTF(Utilities.adapt(movie.getGenre(), 20));
        raf.writeBoolean(movie.isAvailable());
        if (hasIndexFile()) {
            indexFile.insert(new MovieIndex(movie, raf.getFilePointer()-registrySize));
        }
    }

    public long getFileLength() throws IOException{
        return raf.length();
    }

    public Movie read() throws IOException {
        return new Movie(raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readBoolean());
    }

    public Movie readAt(int index) throws IOException {
        raf.seek(index*registrySize);
        return new Movie(raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readBoolean());
    }

    public long amountOfRegisters() throws IOException{
        return raf.length()/registrySize;
    }

    public void listAll() throws IOException {
        Movie movie;
        for (long i = 0; i < amountOfRegisters() ; i++) {
            movie = readAt((int)i);
            if (movie.isAvailable()) System.out.println(movie.toString());
        }
    }


    public void listAllYear(int year) throws IOException {
        Movie movie;
        for (long i = 0; i < amountOfRegisters(); i++) {
            movie = readAt((int)i);
            if (movie.isAvailable() && movie.getYear() == year) System.out.println(movie.toString());
        }
    }

    public Movie search (String name) throws IOException {
        if (hasIndexFile()) {
            name = Utilities.adapt(name, 50);
            if (indexFile.contains(new MovieIndex(new Movie(name, 0, "", true), 0))) {
                raf.seek(indexFile.search(new MovieIndex(new Movie(name, 0, "", true), 0)).getPosition());
                return read();
            }
        }
        else {
            System.out.println("Index file not found. Starting sequential search... ");
            long size = amountOfRegisters();
            start();
            Movie movie;
            name = Utilities.adapt(name, 50);
            for (int i = 0; i < size; i++) {
                movie = read();
                if (movie.isAvailable() && movie.getTitle().equals(name)) {
                    System.out.println("Movie found!");
                    return movie;
                }
            }
        }
        return new Movie();
    }

    public boolean delete(String name) throws IOException {
        Movie m = search(name);
        if (m.isAvailable()) {
            raf.seek(raf.getFilePointer() - registrySize);
            m.setAvailable(false);
            write(m);
            return true;
        }
        return false;
    }

    public boolean modify(Movie m) throws IOException{
        Movie toModify = search(m.getTitle());
        if (toModify.isAvailable()) {
            raf.seek(raf.getFilePointer() - registrySize);
            write(m);
            return true;
        }
        else return false;
    }

    public void generateIndexFile(String filename) throws IOException {
        indexFile = new BinarySearchTree<>();
        long size = amountOfRegisters();
        start();

        for (int i = 0; i < size; i++) {
            Movie movie = read();
            if (movie.isAvailable()) {
                indexFile.insert(new MovieIndex(movie,raf.getFilePointer()-registrySize));
            }
        }
        saveIndexFile(filename);
    }

    public void loadIndexFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream(filename));
        indexFile = (BinarySearchTree<MovieIndex>) objectInputStream.readObject();
        objectInputStream.close();
    }

    public void saveIndexFile(String filename) throws IOException{
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(indexFile);
        objectOutputStream.close();
    }

    public boolean hasIndexFile(){
        return indexFile!=null;
    }
}
