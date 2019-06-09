package clases;

import java.io.IOException;
import java.util.ArrayList;

public interface DAO {

	public void add(Prenda objeto) throws IOException;
	public void delete(Prenda objeto) throws IOException;
	public ArrayList<Prenda> getAll() throws IOException;
	public void update(Prenda objeto);
	
}
