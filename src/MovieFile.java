import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by matias on 6/22/16.
 */
public class MovieFile {
    private File f;
    private RandomAccessFile raf;
    private long size = 0;

    public MovieFile(String filename) throws FileNotFoundException {
        f = new File(filename);
        raf = new RandomAccessFile(f,"rw");
    }

    public void addMovieRegister(Movie movie) throws IOException{
        raf.writeUTF(movie.getTitle());
        raf.writeInt(movie.getYear());
        raf.writeUTF(movie.getGenre());
        raf.writeBoolean(movie.isChildFriendly());
        raf.writeBoolean(true); //Movie is now available
        size += 5; //Adds 4 for the Integer and 1 for the Boolean.
        int titleSize = movie.getTitle().toCharArray().length +2;
        int genreSize = movie.getGenre().toCharArray().length +2;
        size += titleSize + genreSize;
    }

    public Movie readMovieRegister() throws IOException{
        return new Movie(raf.readUTF(),raf.readInt(),raf.readUTF(),raf.readBoolean());
    }

    public void deleteRegister(String name) throws IOException{
        //Logic elimination of movie that matches parameter
    }

    public String readString(String str) throws  IOException{
        return raf.readUTF();
    }

    public long getFileLength() throws IOException{
        return raf.length(); //Retorna la cantidad de bytes del archivo
    }

    public int readInt() throws IOException{
        return raf.readInt(); //O lo que sea que haya
    }

    public long amountOfRegisters() throws IOException {
        return raf.length(); // y lo divido por el tamano del registro
    }

    public void addRegister() throws IOException {
        raf.seek(0); // pone al puntero al inicoi del archivo
        raf.seek(raf.length()); //pone al punter al final del archivo;
    }
}
