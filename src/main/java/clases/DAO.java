package clases;

import java.io.IOException;
import java.util.ArrayList;

public interface DAO {

	public void add(Indumentaria objeto) throws IOException;
	public void delete(Indumentaria objeto) throws IOException;
	public ArrayList<Indumentaria> getAll() throws IOException;
	public void update(Indumentaria objeto);
	
}
